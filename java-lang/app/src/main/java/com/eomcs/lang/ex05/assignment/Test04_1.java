package bitcamp.assignment3;

//# 과제
//- 다음 int 변수에 들어 있는 값을
//  각 자릿수의 10 진수 값을 역순으로 출력하라.
//실행 예)
//값: 23459876

public class Test04_1 {

  public static void main(String[] args) {
    int value = 23459876;
    String values = "";
    for (int i = 0; i < 8; i++) {
      value = value / 10; // = 2345987
      System.out.println(value % 10);
      values += value % 10;
    }
    System.out.println(values);
  }
}








