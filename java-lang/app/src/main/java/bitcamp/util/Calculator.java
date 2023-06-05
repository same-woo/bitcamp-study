package bitcamp.util;

public class Calculator {
  static int result;
  static int temp;

  public static void init(int a) {
    result = a;
  }

  public static void plus(int a) {
    temp = result;
    result += a;
    System.out.println("plus: " + temp + " + " + a + " = " + result);
  }

  public static void minus(int a) {
    temp = result;
    result -= a;
    System.out.println("minus: " + temp + " - " + a + " = " + result);
  }

  public static void multiple(int a) {
    temp = result;
    result *= a;
    System.out.println("multiple: " + temp + " * " + a + " = " + result);
  }

  public static void divide(int a) {
    temp = result;
    result /= a;
    System.out.println("divide: " + temp + " / " + a + " = " + result);
  }
}
