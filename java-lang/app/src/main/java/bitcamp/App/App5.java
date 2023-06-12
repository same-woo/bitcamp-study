package bitcamp.myapp;

import bitcamp.myapp.Prompt;
import bitcamp.myapp.MemberHandler;

public class App5 {

  public static void main(String[] args) {
    printTitle();
    printmenu();




    while (true) {
      String menuNO = Prompt.prompt("> ");

        if (menuNO.equals("6")) {
          Prompt.close();
          System.out.println("프로그램을 종료합니다.");
          break;
          
        } else if (menuNO.equals("menu")) {
          printmenu();
        } else if (menuNO.equals("1")) {
          MemberHandler.inputMember();
        } else if (menuNO.equals("2")) {
          MemberHandler.printMembers();
        } else if (menuNO.equals("3")) {
          MemberHandler.viewMember();
        } else if (menuNO.equals("4")) {
          MemberHandler.updateMember();
        } else {
          System.out.println(menuNO);
        }
    }




  }
    



  static void printmenu() { 
    System.out.println("1.회원등록");
    System.out.println("2.회원목록");
    System.out.println("3.회원조회");
    System.out.println("4.회원변경");
    System.out.println("5.회원삭제");
    System.out.println("6. 종료");
  }


  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
  }



  static boolean promptContinue() {
    while (true) {
      String choice = Prompt.prompt("계속 하시겠습니까? (Y/n): ");
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

