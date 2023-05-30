package bitcamp.myapp;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------");

    //  키보드 스캐너 준비
    Scanner keyboardScanner = new Scanner(System.in);
    
    System.out.print("번호?: ");
    int no = keyboardScanner.nextInt();
    
    // int no = 100;
    System.out.print("이름은?: ");
    String name = keyboardScanner.next();
    // String name = "홍길동";

    System.out.print("나이는?: ");
    int age = keyboardScanner.nextInt();
    // int age = 20;

    System.out.print("재직중? (true | false) : ");
    boolean working = keyboardScanner.nextBoolean();
    // boolean working = true;

    System.out.print("성별은? M | W : ");
    String str = keyboardScanner.next();
    char gender = str.charAt(0);
    // char gender = 'M';

     
    System.out.print("시력은? (왼쪽) : ");
    float leftEye = keyboardScanner.nextFloat();
    System.out.print("시력은? (오른쪽) : ");
    float rightEye = keyboardScanner.nextFloat();

    // float leftEye = 1.5f;
    // float rightEye = 1.0f;
    System.out.println("----------------------");
    

    // System.out.println("번호: ");
    // System.out.println("100");

    // System.out.printf("이름: %s\n", "홍길동");
    // System.out.println();

    // System.out.println("나이: " + 20);

    // System.out.printf("재직자: %b\n", true);

    // System.out.printf("성별(남자(M), 여자(W)): %c\n", 'M');

    // System.out.printf("좌우시력: %.1f, %.1f\n", 1.5f, 1.0f);
  }
}