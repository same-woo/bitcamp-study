package bitcamp.myapp;

<<<<<<< HEAD
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.config.AppConfig;
import bitcamp.util.ApplicationContext;
import bitcamp.util.DispatcherServlet;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.HttpSession;
=======
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
import bitcamp.myapp.vo.Member;
import bitcamp.net.NetProtocol;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;
>>>>>>> 1f70ccb8656b36556158980f1dd27eac3570c4b5
import bitcamp.util.SqlSessionFactoryProxy;
import io.netty.handler.codec.http.cookie.Cookie;
import io.netty.handler.codec.http.cookie.DefaultCookie;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.NettyOutbound;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

public class ServerApp {

  public static final String MYAPP_SESSION_ID = "myapp_session_id";

  ApplicationContext iocContainer;
  DispatcherServlet dispatcherServlet;
  Map<String,HttpSession> sessionMap = new HashMap<>();

  int port;

  public ServerApp(int port) throws Exception {
<<<<<<< HEAD
	    this.port = port;
	    iocContainer = new ApplicationContext(AppConfig.class);
	    dispatcherServlet = new DispatcherServlet(iocContainer);
	  }
=======

    this.port = port;

    // 1) mybatis 설정 파일을 읽어들일 도구를 준비한다. d
    InputStream mybatisConfigIn =
        Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml");

    // 2) SqlSessionFactory를 만들어줄 빌더 객체 준비
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

    // 3) 빌더 객체를 통해 SqlSessionFactory를 생성
    sqlSessionFactory = new SqlSessionFactoryProxy(builder.build(mybatisConfigIn));

    this.dogDao = new MySQLDogDao(sqlSessionFactory);
    this.memberDao = new MySQLMemberDao(sqlSessionFactory);
    this.boardDao = new MySQLBoardDao(sqlSessionFactory);

    // prepareMenu(prompt);
  }
>>>>>>> 1f70ccb8656b36556158980f1dd27eac3570c4b5

  public void close() throws Exception {

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp(8888);
    app.execute();
    app.close();
  }

<<<<<<< HEAD
  public void execute() throws Exception {
	    DisposableServer server = HttpServer
	        .create()
	        .port(8888)
	        .handle((request, response) -> processRequest(request, response))
	        .bindNow();
	    System.out.println("서버 실행됨!");

	    server.onDispose().block();
	    System.out.println("서버 종료됨!");
	  }

  private NettyOutbound processRequest(HttpServerRequest request, HttpServerResponse response) {
	    System.out.println(response.getClass().getName());
	    HttpServletRequest request2 = new HttpServletRequest(request);
	    HttpServletResponse response2 = new HttpServletResponse(response);

	    try {
	      // 클라이언트 세션 ID 알아내기
	      String sessionId = null;
	      boolean firstVisit = false;

	      // 클라이언트가 보낸 쿠키들 중에서 세션ID가 있는지 확인한다.
	      List<Cookie> cookies = request2.allCookies().get(MYAPP_SESSION_ID);
	      if (cookies != null) {
	        // 세션ID가 있으면 이 값을 가지고 클라이언트를 구분한다.
	        sessionId = cookies.get(0).value();
	      } else {
	        // 세션ID가 없으면 이 클라이언트를 구분하기 위해 새 세션ID를 발급한다.
	        sessionId = UUID.randomUUID().toString();
	        firstVisit = true;
	      }

	      // 세션ID로 클라이언트에게 배정된 HttpSession 객체를 찾는다.
	      HttpSession session = sessionMap.get(sessionId);
	      if (session == null) {
	        // 현재 클라이언트가 사용할 HttpSession 객체가 배정되지 않았다면, 새로 만든다.
	        session = new HttpSession(sessionId);

	        // 새로 만든 세션 객체를 세션ID를 사용하여 맵에 보관한다.
	        sessionMap.put(sessionId, session);
	      }

	      // 서블릿에서 HttpSession 보관소를 사용할 수 있도록 HttpServletRequest에 담아 둔다.
	      request2.setSession(session);

	      if (firstVisit) {
	        // 세션ID가 없는 클라이언트를 위해 새로 발급한 세션ID를 쿠키로 보낸다.
	        // 웹브라우저는 이 값을 내부 메모리에 저장할 것이다.
	        response.addCookie(new DefaultCookie(MYAPP_SESSION_ID, sessionId));
	      }

	      String servletPath = request2.getServletPath();

	      // favicon.ico 요청에 대한 응답
	      if (servletPath.equals("/favicon.ico")) {
	        response.addHeader("Content-Type", "image/vnd.microsoft.icon");
	        return response.sendFile(Path.of(ServerApp.class.getResource("/static/favicon.ico").toURI()));
	      }

	      // welcome 파일 또는 HTML 파일을 요청할 때
	      if (servletPath.endsWith("/") || servletPath.endsWith(".html")) {
	        String resourcePath = String.format("/static%s%s",
	            servletPath,
	            (servletPath.endsWith("/") ? "index.html" : ""));

	        response.addHeader("Content-Type", "text/html;charset=UTF-8");
	        return response.sendFile(Path.of(ServerApp.class.getResource(resourcePath).toURI()));
	      }

	      if (request.isFormUrlencoded()) {
	        // POST 방식으로 요청했다면,
	        return response.sendString(request.receive()
	            .aggregate()
	            .asString()
	            .map(body -> {
	              try {
	                request2.parseFormBody(body);
	                dispatcherServlet.service(request2, response2);
	              } catch (Exception e) {
	                e.printStackTrace();
	              }
	              response.addHeader("Content-Type", response2.getContentType());
	              return response2.getContent();
	            }));

	      } else {
	        // GET 방식으로 요청했다면,
	        dispatcherServlet.service(request2, response2);
	        response.addHeader("Content-Type", response2.getContentType());
	        return response.sendString(Mono.just(response2.getContent()));
	      }

	    } catch (Exception e) {
	      e.printStackTrace();
	      return response.sendString(Mono.just(response2.getContent()));

	    } finally {
	      SqlSessionFactoryProxy sqlSessionFactoryProxy =
	          (SqlSessionFactoryProxy) iocContainer.getBean(SqlSessionFactory.class);
	      sqlSessionFactoryProxy.clean();
	    }

	  }

	}
=======
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
      BreadcrumbPrompt prompt = new BreadcrumbPrompt(in, out); // 로그인 이후에 prompt 생성
      InetSocketAddress clientAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("%s 클라이언트 접속함!\n", clientAddress.getHostString());

      out.writeUTF("[전국 보호동물센터.com]\n" + "-----------------------------------------");

      // 초기 화면에서 회원가입 또는 로그인 여부를 물어봅니다.
      String choice = prompt.inputString("1. 회원가입\n2. 로그인\n> ");
      switch (choice) {
        case "1":
          new MemberAddListener(memberDao, sqlSessionFactory).service(prompt); // 회원가입 기능 실행
          break;
        case "2":
          new LoginListener(memberDao).service(prompt); // 로그인 기능 실행
          break;
        default:
          prompt.println("잘못된 선택입니다.");
          prompt.end();
          return;
      }



      prepareMenu(prompt); // 메뉴를 준비합니다.

      mainMenu.execute(prompt);
      out.writeUTF(NetProtocol.NET_END);

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();

    } finally {
      ((SqlSessionFactoryProxy) sqlSessionFactory).clean();
    }
  }


  private void prepareMenu(BreadcrumbPrompt prompt) {
    MenuGroup memberMenu = new MenuGroup("회원관리");

    if (((Member) prompt.getAttribute("loginUser")).getEmail().contains("@test.com")) {
      memberMenu.add(new Menu("등록", new MemberAddListener(memberDao, sqlSessionFactory)));
      memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
      memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
      memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao, sqlSessionFactory)));
      memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao, sqlSessionFactory)));
    }
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
>>>>>>> 1f70ccb8656b36556158980f1dd27eac3570c4b5
