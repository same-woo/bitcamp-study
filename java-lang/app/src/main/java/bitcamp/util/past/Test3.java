package bitcamp.myapp;

public class Test3 {
  static int result;
  static int temp; // 스태틱 변수는 기본 값으로 0으로 초기화 된다.

  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 / 3 = ?
    // 연산자 우선 순위를 고려하지 않고 앞에서 부터 뒤로 순차적으로 계산한다.

    Calculator.init(2);
    Calculator.plus(7);
    Calculator.minus(2);
    Calculator.multiple(4);
    Calculator.divide(2);
  }


  // init. 초기 a 값 정해주기
  static void init(int a) {
    result = a;
  }

  // plus. init + plus(인자)
  static void plus(int a) {
  temp = result;
  result += a;
  System.out.println("plus : "+temp + "+"+a+" = "+result);
  }

  // minus. init - minus(인자)
  static void minus(int a) {
  temp = result;
  result -= a;
  System.out.println("minus : "+temp + "-"+a+" = "+result);
  }

  // multiple. init * multiple(인자)
  static void multiple(int a) {
  temp = result;
  result *= a;
  System.out.println("multiple : "+temp + "*"+a+" = "+result);
  }

  // divide. init / divide(인자)
  static void divide(int a) {
  temp = result;
  result /= a;
  System.out.println("divide : "+temp + "/"+a+" = "+result);
  }
}
