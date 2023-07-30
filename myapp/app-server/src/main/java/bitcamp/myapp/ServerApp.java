package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DogDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.MySQLBoardDao;
import bitcamp.myapp.dao.MySQLDogDao;
import bitcamp.myapp.dao.MySQLMemberDao;
import bitcamp.myapp.handler.Board.BoardAddListener;
import bitcamp.myapp.handler.Board.BoardDeleteListener;
import bitcamp.myapp.handler.Board.BoardDetailListener;
import bitcamp.myapp.handler.Board.BoardListListener;
import bitcamp.myapp.handler.Board.BoardUpdateListener;
import bitcamp.myapp.handler.Dog.DogAddListener;
import bitcamp.myapp.handler.Dog.DogDeleteListener;
import bitcamp.myapp.handler.Dog.DogDetailListener;
import bitcamp.myapp.handler.Dog.DogListListener;
import bitcamp.myapp.handler.Dog.DogUpdateListener;
import bitcamp.myapp.handler.Login.LoginListener;
import bitcamp.myapp.handler.Member.MemberAddListener;
import bitcamp.myapp.handler.Member.MemberDeleteListener;
import bitcamp.myapp.handler.Member.MemberDetailListener;
import bitcamp.myapp.handler.Member.MemberListListener;
import bitcamp.myapp.handler.Member.MemberUpdateListener;
import bitcamp.net.NetProtocol;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;
import bitcamp.util.SqlSessionFactoryProxy;

public class ServerApp {

  // 자바 스레드풀 준비
  ExecutorService threadPool = Executors.newFixedThreadPool(2);

  SqlSessionFactory sqlSessionFactory;

  DogDao dogDao;
  MemberDao memberDao;
  BoardDao boardDao;

  MenuGroup mainMenu = new MenuGroup("메인");

  int port;

  public ServerApp(int port) throws Exception {

    this.port = port;

    // 1) mybatis 설정 파일을 읽어들일 도구를 준비한다.  d
    InputStream mybatisConfigIn = Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml");

    // 2) SqlSessionFactory를 만들어줄 빌더 객체 준비
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

    // 3) 빌더 객체를 통해 SqlSessionFactory를 생성
    sqlSessionFactory = new SqlSessionFactoryProxy(builder.build(mybatisConfigIn));

    this.dogDao = new MySQLDogDao(sqlSessionFactory);
    this.memberDao = new MySQLMemberDao(sqlSessionFactory);
    this.boardDao = new MySQLBoardDao(sqlSessionFactory);

    prepareMenu();
  }

  public void close() throws Exception {

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp(8888);
    app.execute();
    app.close();
  }

  public void execute() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        Socket socket = serverSocket.accept();
        threadPool.execute(() -> processRequest(socket));
      }
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
      e.printStackTrace();
    }
  }

  private void processRequest(Socket socket) {
    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      BreadcrumbPrompt prompt = new BreadcrumbPrompt(in, out);

      InetSocketAddress clientAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("%s 클라이언트 접속함!\n", clientAddress.getHostString());

      out.writeUTF("[전국 보호동물센터.com]\n"
          + "-----------------------------------------");

      new LoginListener(memberDao).service(prompt);

      mainMenu.execute(prompt);
      out.writeUTF(NetProtocol.NET_END);

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();

    } finally {
      ((SqlSessionFactoryProxy) sqlSessionFactory).clean();
    }
  }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원관리");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao, sqlSessionFactory)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao, sqlSessionFactory)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao, sqlSessionFactory)));
    mainMenu.add(memberMenu);
    
    MenuGroup dogMenu = new MenuGroup("보호동물");
    dogMenu.add(new Menu("등록", new DogAddListener(dogDao, sqlSessionFactory)));
    dogMenu.add(new Menu("목록", new DogListListener(dogDao)));
    dogMenu.add(new Menu("조회", new DogDetailListener(dogDao)));
    dogMenu.add(new Menu("변경", new DogUpdateListener(dogDao, sqlSessionFactory)));
    dogMenu.add(new Menu("삭제", new DogDeleteListener(dogDao, sqlSessionFactory)));
    mainMenu.add(dogMenu);

    MenuGroup boardMenu = new MenuGroup("입양신청");
    boardMenu.add(new Menu("등록", new BoardAddListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("목록", new BoardListListener(1, boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(1, boardDao, sqlSessionFactory)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(1, boardDao, sqlSessionFactory)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("게시판");
    readingMenu.add(new Menu("등록", new BoardAddListener(2, boardDao, sqlSessionFactory)));
    readingMenu.add(new Menu("목록", new BoardListListener(2, boardDao)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(2, boardDao, sqlSessionFactory)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(2, boardDao, sqlSessionFactory)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(2, boardDao, sqlSessionFactory)));
    mainMenu.add(readingMenu);

  }
}