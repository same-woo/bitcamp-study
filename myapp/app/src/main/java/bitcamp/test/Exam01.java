package bitcamp.test;

class A {
  int v1; // 변수선언만 실행
  int v2;

  {
    System.out.println("111");
    System.out.println("222");
    System.out.println("333");
  }

  public A() {
    v1 = 100;
    v2 = 200;
    System.out.println("444");
  }

  public A(int a) {
    v1 = 100;
    v2 = 200;
    System.out.println("555");
  }

  public A(int a, int b) {
    v1 = 100;
    v2 = 200;
    System.out.println("666");
  }


}



public class Exam01 {
  public static void main(String[] args) {
    new A();
    new A();
    new A();
  }
}
