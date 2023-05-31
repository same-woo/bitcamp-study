package bitcamp.myapp;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");
    //배열생성
    int a = 20; // 배열 길이
    
    int[] num = new int[a];
    String[] name = new String[a];
    int[] age = new int[a];
    boolean[] working = new boolean[a];
    String[] gender = new String[a];
    float[] leftEye = new float[a];
    float[] rightEye = new float[a];

    //  키보드 스캐너 준비
    Scanner keyboardScanner = new Scanner(System.in);
    
    for문 귀찮으면..
    for (int i = 0; i < a; i++) {
      num[i] = i + 1;
      name[i] = "이름" + (i + 1);
      age[i] = 20 + i;
      working[i] = (i % 2 == 0); // 짝수 인덱스는 true, 홀수 인덱스는 false
      gender[i] = (i % 2 == 0) ? "M" : "W"; // 짝수 인덱스는 "M", 홀수 인덱스는 "W"
      leftEye[i] = 1.0f + (float) i / 10;
      rightEye[i] = 1.5f + (float) i / 10;
    }

    // // for문 배열 입력
    // for (int i = 0; i < a; i++) {
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

    System.out.println("------------------------------");
    for (int i = 0; i < a; i++) {
        System.out.printf("%d %s %d %b %s %f %f\n",
            num[i], name[i], age[i], working[i], gender[i], leftEye[i],rightEye[i]);
    }

  }
}
    ///
    // System.out.print("번호?");
    // int num = keyboardScanner.nextInt();
    
    // System.out.print("이름은?");
    // String name = keyboardScanner.next();

    // System.out.print("나이는?");
    // int age = keyboardScanner.nextInt();

    // System.out.print("재직중? (true | false)");
    // boolean working = keyboardScanner.nextBoolean();

    // System.out.print("성별은? M | W : ");
    // String gender = keyboardScanner.next();

    
    // System.out.print("시력은? (왼쪽)");
    // float leftEye = keyboardScanner.nextFloat();
    // System.out.print("시력은? (오른쪽)");
    // float rightEye = keyboardScanner.nextFloat();

    // //출력
    // System.out.printf("번호: %d\n", num);
    // System.out.printf("이름: %s\n", name);
    // System.out.printf("나이: %d\n", age);
    // System.out.printf("재직자: %b\n", working);
    // System.out.printf("성별(남자(M), 여자(W)): %c\n", gender);
    // System.out.printf("좌우시력: %.1f, %.1f\n", leftEye, rightEye);
    // keyboardScanner.close();
