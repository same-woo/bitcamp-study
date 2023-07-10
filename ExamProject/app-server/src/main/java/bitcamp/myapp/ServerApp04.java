package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import bitcamp.myapp.dao.BoardListDao;
import bitcamp.myapp.dao.MemberListDao;
import bitcamp.net.RequestEntity;
import bitcamp.net.ResponseEntity;

// 1) 클라이언트가 보낸 명령을 데이터 이름과 메서드 이름으로 분리한다.
// 2) 클라이언트가 요청한 DAO 객체와 메서드를 찾는다.
// 3) 메서드의 파라미터와 리턴 타입을 알아내기
// 4) 메서드 호출 및 리턴 값 받기
public class ServerApp04 {

  int port;
  ServerSocket serverSocket;

  // 클라이언트 요청을 처리 할 DAO 객체를 맵에 보관한다.
  HashMap<String, Object> daoMap = new HashMap<>();


  public ServerApp04(int port) throws Exception {
    this.port = port;

    // DAO 객체 생성 및 보관
    daoMap.put("member", new MemberListDao("member.json"));
    daoMap.put("board", new BoardListDao("board.json"));
    daoMap.put("reading", new BoardListDao("reading.json"));
  }

  public void close() throws Exception {
    serverSocket.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("실행 예) java ... bitcamp.myapp.ServerApp 포트번호");
      return;
    }

    ServerApp04 app = new ServerApp04(Integer.parseInt(args[0]));
    app.execute();
    app.close();
  }

  public void execute() throws Exception {
    System.out.println("[MyList 서버 애플리케이션]");

    this.serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");

    Socket socket = serverSocket.accept();
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    while (true) {
      RequestEntity request = RequestEntity.fromJson(in.readUTF());

      String command = request.getCommand();
      System.out.println(command);

      if (command.equals("quit")) {
        break;
      }

      // 데이터 이름과 메서드 이름 알아내기
      String[] values = command.split("/");
      String dataName = values[0];
      String methodName = values[1];


      // 데이터 이름으로 DAO 객체를 꺼낸다.
      Object dao = daoMap.get(dataName);
      if (dao == null) { // 만약 데이터를 처리 할 DAO를 찾지 못한다면 오류 정보를 클라이언트에게 보낸다.
        out.writeUTF(
            new ResponseEntity().status(ResponseEntity.ERROR).result("데이터를 찾을 수 없습니다.").toJson());
        continue;
      }

      // DAO에 해당 메서드가 있는지 알아낸다.
      Method[] methods = dao.getClass().getDeclaredMethods();
      Method method = null;
      for (int i = 0; i < methods.length; i++) {
        if (methods[i].getName().equals(methodName)) {
          method = methods[i];
          break;
        }
      }

      if (method == null) {
        // 만약 클라이언트가 요청한 메서드를 찾지 못한다면 오류 정보를 클라이언트에게 보낸다.
        out.writeUTF(
            new ResponseEntity().status(ResponseEntity.ERROR).result("메서드를 찾을 수 없습니다.").toJson());
        continue;
      }

      // System.out.printf("%s.%s\n", dataName, methodName);

      // 메서드의 파라미터와 리턴 타입 알아내기
      Parameter[] params = method.getParameters();


      // 메서드 호출
      Object returnValue = null;
      // 호출할 메서드가 파라미터를 가지고 있다면,

      if (params.length > 0) {
        // 클라이언트가 보낸 Json 데이터를 메서드의 파라미터 값으로 deserialize 한다.
        Object arg = request.getObject(params[0].getType());
        returnValue = method.invoke(dao, arg);
      } else {
        returnValue = method.invoke(dao);
      }

      // 메서드 호출 결과를 클라이언트에게 보낸다.
      ResponseEntity response = new ResponseEntity();
      response.status(ResponseEntity.SUCCESS);
      response.result(returnValue);
      out.writeUTF(response.toJson());
    }

    in.close();
    out.close();
    socket.close();
  }
}


