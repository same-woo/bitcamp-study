package Test;

public class Test {

  public static void main(String[] args) {

    System.out.println(factorial(5));
  }

  static int factorial(int value) {
    if (value == 1) {
      return 1;
    }
    System.out.println(value);
    return factorial(value - 1) * value;
  }

}
