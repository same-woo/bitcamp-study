package bitcamp.myapp;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
    //배열생성
    final int SIZE = 20; // 배열 길이
    
    int[] num = new int[SIZE]; 
    String[] name = new String[SIZE];
    int[] age = new int[SIZE];
    boolean[] working = new boolean[SIZE];
    String[] gender = new String[SIZE];
    float[] leftEye = new float[SIZE];
    float[] rightEye = new float[SIZE];

    //  키보드 스캐너 준비
    Scanner keyboardScanner = new Scanner(System.in);
    
    // 회원정보 등록 자동 for문
    for (int i = 0; i < SIZE; i++) {
      num[i] = i + 1;
      name[i] = "이름" + (i + 1);
      age[i] = 20 + i;
      working[i] = (i % 2 == 0); // 짝수 인덱스는 true, 홀수 인덱스는 false
      gender[i] = (i % 2 == 0) ? "M" : "W"; // 짝수 인덱스는 "M", 홀수 인덱스는 "W"
      leftEye[i] = 1.0f + (float) i / 10;
      rightEye[i] = 1.5f + (float) i / 10;
    }

    // // for문 배열 입력
    // for (int i = 0; i < SIZE; i++) {
    //   System.out.print("번호?");
    //   num[i] = keyboardScanner.nextInt();
    //   System.out.print("이름은?");
    //   name[i] = keyboardScanner.next();
    //   System.out.print("나이는?");
    //   age[i] = keyboardScanner.nextInt();
    //   System.out.print("재직중? (true | false)");
    //   working[i] = keyboardScanner.nextBoolean();
    //   System.out.print("성별은? M | W : ");
    //   gender[i] = keyboardScanner.next();
    //   System.out.print("시력은? (왼쪽)");
    //   leftEye[i] = keyboardScanner.nextFloat();
    //   System.out.print("시력은? (오른쪽)");
    //   rightEye[i] = keyboardScanner.nextFloat();
    // }

        // if (menuNO.equals("1")) {
    //   gender[i] = 'M';  
    //   break; //실행종료를 준다.
    // } else if (menuNO.equals("2")) {
    //   gender[i] = 'W';
    //   break; //실행종료를 준다.
    // } else {
    //   System.out.print("무효한 번호입니다.\n");
    // }

    
    System.out.println("------------------------------");
    for (int i = 0; i < SIZE; i++) {
        System.out.printf("%d %s %d %b %s %f %f\n",
            num[i], name[i], age[i], working[i], gender[i], leftEye[i],rightEye[i]);
    }

  }
}