package bitcamp.myapp;
import java.util.Scanner;

public class App2 {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
    //배열생성
    final int MAX_SIZE = 3; // 배열 길이
    int userid = 1;
    int length = 0;
    
    // int[] num = new int[MAX_SIZE]; 
    // int[] age = new int[MAX_SIZE];
    // boolean[] working = new boolean[MAX_SIZE];
    // float[] leftEye = new float[MAX_SIZE];
    // float[] rightEye = new float[MAX_SIZE];
    int[] num = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    String[] gender = new String[MAX_SIZE];

    //  키보드 스캐너 준비
    Scanner keyboardScanner = new Scanner(System.in);
    
    // // 회원정보 등록 자동 for문
    // for (int i = 0; i < MAX_SIZE; i++) {
    //   num[i] = i + 1;
    //   name[i] = "이름" + (i + 1);
    //   email[i] = "이메일" + (i + 1);
    //   password[i] = "암호" + (i + 1);
    //   gender[i] = (i % 2 == 0) ? "M" : "W"; // 짝수 인덱스는 "M", 홀수 인덱스는 "W"
    //   num[i] = userid++;
    // }

    // for문 배열 입력
    for (int i = 0; i < MAX_SIZE; i++) {

      System.out.print("이름은?");
      name[i] = keyboardScanner.next();

      System.out.print("이메일은?");
      email[i] = keyboardScanner.next();

      System.out.print("암호는?");
      password[i] = keyboardScanner.next();

      System.out.print("성별은? M | W : ");
      gender[i] = keyboardScanner.next();
      num[i] = userid++;
      
      length++;

//계속 진행 할 것인지 확인
      System.out.print("계속 하시겠습니까? (Y/n): \n");
      keyboardScanner.nextLine(); // 이전에 next()를 실행한 후 남아있는 줄바꿈 코드를 제거한다.
      String choice = keyboardScanner.nextLine(); // Enter를 빈문자열로 인식한다.
      if (!choice.equals("") && !choice.equalsIgnoreCase("Y")) { // ignoreCase는 대소문자를 구분x
        System.out.println("실행을 종료합니다.\n");
        break; // Exit the loop and end the program
        }
      }

    //출력
    System.out.println("------------------------------");
    System.out.println("번호, 이름, 이메일, 성별\n");
    for (int i = 0; i < MAX_SIZE; i++) {
        System.out.printf("%d %s %s %s %s\n",
            num[i], name[i], email[i], password[i],  gender[i]);
    }
    keyboardScanner.close();
  }
}