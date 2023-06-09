package bitcamp.util;

public class Calculator {
  
  private int result;
  
  public int getResult() {
    //Calculator this = 외부에서 넘겨준 주소
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