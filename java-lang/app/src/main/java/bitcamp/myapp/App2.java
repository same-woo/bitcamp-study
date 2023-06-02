package bitcamp.myapp;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    
    //타이틀 메소드 출력
    printTitle();

    //배열생성
    final int MAX_SIZE = 3; // 배열 길이
    int userid = 1;
    int length = 0;

    //  키보드 스캐너 준비
    Scanner keyboardScanner = new Scanner(System.in);

    int[] num = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];



    // //회원정보 등록 자동 for문
    // for (int i = 0; i < MAX_SIZE; i++) {
    //   num[i] = i + 1;
    //   name[i] = "이름" + (i + 1);
    //   email[i] = "이메일" + (i + 1);
    //   password[i] = "암호" + (i + 1);
    //   gender[i] = ((i % 2 == 0) ? "M" : "W").charAt(0); // 짝수 인덱스는 "M", 홀수 인덱스는 "W"
    //   num[i] = userid++;
    // }

    // for문 배열 입력 (회원정보 입력)
    for (int i = 0; i < MAX_SIZE; i++) {
      inputMenber(keyboardScanner, i, name, email, password, gender, num, userid++);
      
      length++;

      if(!promptContinue(keyboardScanner))



    //출력
      System.out.println("------------------------------");
      System.out.println("번호, 이름, 이메일, 성별\n");
      for (int i = 0; i < MAX_SIZE; i++) {
          System.out.printf("%d %s %s %s %c\n",
              num[i], name[i], email[i], password[i],  gender[i]);
      }
      keyboardScanner.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
  }

  static void inputMenber(Scanner keyboardScanner, int i, 
      String[] name, String[] email, String[] password, 
      char[] gender, int[] num, int userid) {

    System.out.print("이름은?");
    name[i] = keyboardScanner.next();

    System.out.print("이메일은?");
    email[i] = keyboardScanner.next();

    System.out.print("암호는?");
    password[i] = keyboardScanner.next();


  loop: while (true) { //true가 나올 때까지 반복한다.(라벨생성)
    System.out.print("성별은? : \n");
    System.out.print("  1. 남자 : \n");
    System.out.print("  2. 여자 : \n");
    System.out.print("> ");
    String menuNO = keyboardScanner.next(); 

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
  num[i] = userid++;
  }

  static boolean promptContinue() {
    // else 뒤에는 "{}"가 붙지않아도 되지만, 반드시 마지막에 "{}"는 사용 해야한다.
    //계속 진행 할 것인지 확인
    System.out.print("계속 하시겠습니까? (Y/n): \n");
    System.out.print("> ");
    // keyboardScanner.nextLine(); // 이전에 next()를 실행한 후 남아있는 줄바꿈 코드를 제거한다.
    String choice = keyboardScanner.nextLine(); // Enter를 빈문자열로 인식한다.
    if (!choice.equals("") && !choice.equalsIgnoreCase("Y")) { // ignoreCase는 대소문자를 구분x
      return false;
      System.out.println("실행을 종료합니다.\n");
    } else {
      return true;
    }
  }
}