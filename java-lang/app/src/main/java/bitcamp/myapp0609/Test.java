package bitcamp.myapp;
import bitcamp.util.Calculator;
import bitcamp.util.Prompt;

public class Test {

  // static int input;

  public static void main(String[] args) {
    // 2 *3 + 7 - 2  2 = ?
    // 3 -1 * 7 + 15 /3 = ?
    // => 위의 계산을 동시에 수행하기

    // 두개의 계산 결과를 저장할 수 있는 result 변수를 준비한다.
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

  //  input = Prompt.inputInt("계산 할 첫 숫자를 입력해주세요 : ");
  
    c1.init(2);
    c1.multiple(3);
    c1.plus(7);
    c1.minus(2);
    c1.divide(2);
    System.out.println("c1 출력"+c1.getResult());

    c2.init(5);
    c2.multiple(3);
    c2.plus(7);
    c2.minus(2);
    c2.divide(2);
    System.out.println("c2 출력"+c2.getResult());

  // input = Prompt.inputInt("계산 할 두 번째 숫자를 입력해주세요 : ");
  //   Calculator.init(input);
  //   Calculator.multiple(input);
  //   Calculator.plus(input);
  //   Calculator.minus(input);
  //   Calculator.divide(input);
  //   System.out.println(input);
  //   System.out.println(Calculator.getResult());
  }
  

}
