package bitcamp.util;

public class Calculator {
  
  private int result;
  private static int result2;

  public static int getResult2() {
    return getResult2;
  }
  
  public int getResult() {
    return this.result;
  }

  public void init(int a) {
    this.result = a;
  }

  public void plus(int a) {
    this.result += a;
  }

  public void minus(int a) {
    this.result -= a;
  }

  public void multiple(int a) {
    this.result *= a;
  }

  public void divide(int a) {
    this.result /= a;
  }
}