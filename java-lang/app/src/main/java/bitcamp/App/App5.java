package bitcamp.myapp;

// import java.util.Scanner;
import bitcamp.myapp.Prompt;
import bitcamp.myapp.MemberHandler;

public class App5 {

  public static void main(String[] args) {
    // 타이틀 메소드 출력
    printTitle();

    // for문 배열 입력 (회원정보 입력)
    while (MemberHandler.available()) {
      MemberHandler.inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    // 회원정보 출력
    MemberHandler.printMembers();

    Prompt.close();
  }

  // methods
  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
  }

  static boolean promptContinue() {
    // 계속 진행 할 것인지 확인
    while (true) {
      String choice = Prompt.prompt("계속 하시겠습니까? (Y/n): "); // Pass the keyboardScanner as an argument
      System.out.println("");
      if (choice.equalsIgnoreCase("Y") || choice.equals("")) {
        return true;
      } else if (choice.equalsIgnoreCase("N")) {
        System.out.println("실행을 종료합니다.");
        return false;
      } else {
        System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
      }
    }
  }

}
