package bitcamp.myapp;
import java.util.Scanner;

public class App3 {
  final static int MAX_SIZE = 3; // 배열 길이

  public static void main(String[] args) {
    //int
    int userid = 1;
    int length = 0;

    // 타이틀 메소드 출력
    printTitle();
  
    //배열생성
    int[] num = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];

    //  키보드 스캐너 준비
    Scanner keyboardScanner = new Scanner(System.in);

    // for문 배열 입력 (회원정보 입력)
    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(keyboardScanner, i, name, email, password, gender, num);
      length++;
      if (!promptContinue(keyboardScanner)) {
        break;
      }
    }

    // 회원정보 출력
    printMembers(num, name, email, gender);
    keyboardScanner.close();
  }



  // methods
  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
  }

  static void inputMember(Scanner keyboardScanner, int i, 
      String[] name, String[] email, String[] password, 
      char[] gender, int[] num) {

    System.out.print("이름은? ");
    name[i] = keyboardScanner.nextLine();

    System.out.print("이메일은? ");
    email[i] = keyboardScanner.nextLine();

    System.out.print("암호는? ");
    password[i] = keyboardScanner.nextLine();

    loop: while (true) { //true가 나올 때까지 반복한다.(라벨생성)
      System.out.print("성별은? (1. 남자 / 2. 여자) ");
      String menuNO = keyboardScanner.nextLine(); 

      switch (menuNO) {  // if문 대신 사용가능. break때문에 loop 사용해야한다.
        case "1":
          gender[i] = 'M';  
          break loop;
        case "2":
          gender[i] = 'W';  
          break loop;
        default:
          System.out.print("무효한 번호입니다.\n");
      }
    }
    num[i] = i + 1;
  }

  static boolean promptContinue(Scanner keyboardScanner) {
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

  static void printMembers(int[] num, String[] name, String[] email, char[] gender) {
    //출력
    System.out.println("------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    for (int i = 0; i < MAX_SIZE; i++) {
        System.out.printf("%d %s %s %c\n",
            num[i], name[i], email[i], gender[i]);
    }
  }
}
