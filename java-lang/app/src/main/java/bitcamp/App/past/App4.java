package bitcamp.myapp;
import java.util.Scanner;

public class App4 {
  final static int MAX_SIZE = 3; // 배열 길이
  static int[] num = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static Scanner keyboardScanner = new Scanner(System.in);
  static int userid = 1;
  static int length = 0;

  public static void main(String[] args) {
    //int

    // 타이틀 메소드 출력
    printTitle();
  
    //배열생성

    //  키보드 스캐너 준비

    // for문 배열 입력 (회원정보 입력)
    // for (int i = 0; i < MAX_SIZE; i++) {
    while (length < MAX_SIZE) {
      inputMember();
      if (!promptContinue()) {
        break;
      }
    }

    // 회원정보 출력
    printMembers();

    keyboardScanner.close();
  }



  // methods
  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
  }

  static void inputMember() {

    System.out.print("이름은? ");
    name[length] = keyboardScanner.nextLine();

    System.out.print("이메일은? ");
    email[length] = keyboardScanner.nextLine();

    System.out.print("암호는? ");
    password[length] = keyboardScanner.nextLine();

    loop: while (true) { //true가 나올 때까지 반복한다.(라벨생성)
      System.out.print("성별은? (1. 남자 / 2. 여자) ");
      String menuNO = keyboardScanner.nextLine(); 

      switch (menuNO) {  // if문 대신 사용가능. break때문에 loop 사용해야한다.
        case "1":
          gender[length] = 'M';  
          break loop;
        case "2":
          gender[length] = 'W';  
          break loop;
        default:
          System.out.print("무효한 번호입니다.\n");
      }
    }
    num[length] = userid ++;
    length++;
  }

  static boolean promptContinue() {
    //계속 진행 할 것인지 확인
    System.out.print("계속 하시겠습니까? (Y/n): ");
    String choice = keyboardScanner.nextLine(); // Enter를 빈문자열로 인식한다.
    System.out.println("");
    if (!choice.equals("") && !choice.equalsIgnoreCase("Y")) { // ignoreCase는 대소문자를 구분x
      System.out.println("실행을 종료합니다.");
      return false;
    } else {
      return true;
    }
  }

  static void printMembers() {
    //출력
    System.out.println("------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("------------------------------");
    for (int i = 0; i < MAX_SIZE; i++) {
        System.out.printf("%d %s %s %c\n",
            num[i], name[i], email[i], gender[i]);
    }
  }
}
