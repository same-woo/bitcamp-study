package bitcamp.myapp.project;

import bitcamp.myapp.project.handler.BoardHandler;
import bitcamp.myapp.project.handler.Handler;
import bitcamp.myapp.project.handler.MemberHandler;
import bitcamp.util.ArrayList;
import bitcamp.util.LinkedList;
import bitcamp.util.MenuPrompt;

public class App {

  public static void main(String[] args) {

    MenuPrompt prompt = new MenuPrompt();
    prompt.appendBreadcrumb("메인", getMenu());

    Handler memberHandler = new MemberHandler(prompt, "회원", new ArrayList());
    Handler boardHandler = new BoardHandler(prompt, "게시글", new LinkedList());
    Handler readingHandler = new BoardHandler(prompt, "독서록", new LinkedList());


    // 기본 생성자를 이용해 prompt 인스턴스를 준비한다.
    // 기본 생성자는 Scanner를 키보드와 연결한다.

    printTitle();

    prompt.printMenu();

    loop: while (true) {
      String menuNo = prompt.inputMenu();
      switch (menuNo) {
        case "0":
          break loop;
        case "1":
          memberHandler.execute();
          break;
        case "2":
          boardHandler.execute();
          break;
        case "3":
          readingHandler.execute();
          break;
      }
    }

    prompt.close();

  }

  static String getMenu() {
    StringBuilder menu = new StringBuilder();
    menu.append("1. 회원\n");
    menu.append("2. 게시글\n");
    menu.append("3. 독서록\n");
    menu.append("0. 종료\n");
    return menu.toString();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }
}
