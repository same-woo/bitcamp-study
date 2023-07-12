package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
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
// 5) 리팩토링
public class ServerApp {

  int port;
  ServerSocket serverSocket;

  // 클라이언트 요청을 처리 할 DAO 객체를 맵에 보관한다.
  HashMap<String, Object> daoMap = new HashMap<>();

  public ServerApp(int port) throws Exception {
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

    ServerApp app = new ServerApp(Integer.parseInt(args[0]));
    app.execute();
    app.close();
  }

  public void execute() throws Exception {
    class RequestAgentThread extends Thread {
      Socket socket;

      public RequestAgentThread(Socket socket) {
        this.socket = socket;
      }

      @Override
      public void run() {
        processRequest(socket);
      }
    }


    System.out.println("[MyList 서버 애플리케이션]");

    this.serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");

    while (true) {
      new RequestAgentThread(serverSocket.accept()).start();
    }
  }

  public static Method findMethod(Object obj, String methodName) {
    // DAO에 해당 메서드가 있는지 알아낸다.
    Method[] methods = obj.getClass().getDeclaredMethods();
    for (int i = 0; i < methods.length; i++) {
      if (methods[i].getName().equals(methodName)) {
        return methods[i];
      }
    }
    return null;
  }

  // 메서드 호출하기
  public static Object call(Object obj, Method method, RequestEntity request) throws Exception {
    Parameter[] params = method.getParameters();
    if (params.length > 0) {
      @SuppressWarnings("unused")
      Object arg = request.getObject(params[0].getType());
      return method.invoke(obj, request.getObject(params[0].getType()));
    } else {
      return method.invoke(obj);
    }
  }

  // 클라이언트와 접속이 이루어지면 클라이언트의 요청을 처리한다.
  public void processRequest(Socket socket) {

    try (Socket s = socket; // 사용할 용도 외에 오류 시에 자원을 닫아주는 용도로 명시
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

      InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("%s:%s 클라이언트가 접속했음!\n", socketAddress.getHostName(),
          socketAddress.getPort());

      // 클라이언트 요청을 반복해서 처리하지 않는다.
      // 요청 -> 실행 -> 응답 ->
      RequestEntity request = RequestEntity.fromJson(in.readUTF());

      String command = request.getCommand();
      System.out.println(command);

      // 데이터 이름과 메서드 이름 알아내기
      String[] values = command.split("/");
      String dataName = values[0];
      String methodName = values[1];

      // 데이터 이름으로 DAO 객체를 꺼낸다.
      Object dao = daoMap.get(dataName);
      if (dao == null) { // 만약 데이터를 처리 할 DAO를 찾지 못한다면 오류 정보를 클라이언트에게 보낸다.
        out.writeUTF(
            new ResponseEntity().status(ResponseEntity.ERROR).result("데이터를 찾을 수 없습니다.").toJson());
        return;
      }
      // Dao객체에서 메서드 찾기
      Method method = findMethod(dao, methodName);
      if (method == null) {
        // 만약 클라이언트가 요청한 메서드를 찾지 못한다면 오류 정보를 클라이언트에게 보낸다.
        out.writeUTF(
            new ResponseEntity().status(ResponseEntity.ERROR).result("메서드를 찾을 수 없습니다.").toJson());
        return;
      }

      try {
        // DAO 메서드 호출하기
        Object result = call(dao, method, request);

        // 메서드 호출 결과를 클라이언트에게 보낸다.
        ResponseEntity response = new ResponseEntity();
        response.status(ResponseEntity.SUCCESS);
        response.result(result);
        out.writeUTF(response.toJson());

      } catch (Exception e) {
        // 메서드 호출 결과를 클라이언트에게 보낸다.
        ResponseEntity response = new ResponseEntity();
        response.status(ResponseEntity.ERROR);
        response.result(e.getMessage());
        out.writeUTF(response.toJson());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}


