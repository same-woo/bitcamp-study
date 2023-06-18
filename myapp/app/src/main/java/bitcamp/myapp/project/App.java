package bitcamp.myapp.project;

import bitcamp.myapp.project.handler.BoardHandler;
import bitcamp.myapp.project.handler.Handler;
import bitcamp.myapp.project.handler.MemberHandler;
import bitcamp.myapp.project.util.Prompt;

// 푸시확인
public class App {

  public static void main(String[] args) {

    Prompt prompt = new Prompt();

    Handler memberHandler = new MemberHandler(prompt, "회원");
    Handler boardHandler = new BoardHandler(prompt, "게시글");
    Handler readingHandler = new BoardHandler(prompt, "독서록");



    // 기본 생성자를 이용해 prompt 인스턴스를 준비한다.
    // 기본 생성자는 Scanner를 키보드와 연결한다.

    printTitle();
    printMenu();

    while (true) {
      String menuNo = prompt.inputString("메인> ");
      if (menuNo.equals("0")) {
        break;
      } else if (menuNo.equals("menu")) {
        printMenu();
      } else if (menuNo.equals("1")) {
        memberHandler.execute();
      } else if (menuNo.equals("2")) {
        boardHandler.execute();
      } else if (menuNo.equals("3")) {
        readingHandler.execute();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }

    prompt.close();
  }

  static void printMenu() {
    System.out.println("1. 회원");
    System.out.println("2. 게시글");
    System.out.println("3. 독서록");
    System.out.println("0. 종료");


  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }
}
