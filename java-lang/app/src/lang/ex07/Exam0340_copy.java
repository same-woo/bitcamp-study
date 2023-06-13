package bitcamp.ex07;
public class Exam0340_copy {

  static int a;
  static int b;

  static void swap() {
    int temp = a;
    a = b;
    b = temp;
  }

  public static void main(String[] args) {
    a = 100;
    b = 200;

    swap();

    System.out.printf("main(): a=%d, b=%d\n", a, b);
  }
}
