package my.java.coding.ex01;

import java.util.HashMap;
import java.util.Map;

public class Test5 {

  public static Map<Character, Integer> main(String[] args) {

    // BiFunction<T,U,R> 인터페이스
    // => R apply(T, U);
    //
    // Map.put (키, 값);
    // => 키 : Character
    // => 값 : Integer
    // => 예) put('x', 100);
    //
    // Map.compute (키, 값을 리턴할 객체);
    // => 키 : k
    // => 값을 리턴할 객체 : BiFunction<? super k, ? super v, ? extends v>
    // => 예) compute('x', BiFunction 구현 객체);
    // ㄴ BiFunction 인터페이스가 구현하는 apply 객체의 반환 값을 저장


    String str = "Be strong, be fearless, be beautiful. "
        + "And believe that anything is possible when you have the right "
        + "people there to support you. ";

    Map<Character, Integer> result = new HashMap<>();


    for (char ch : str.toCharArray()) {
      result.compute(ch, (key, value) -> (value == null) ? 1 : value + 1);
    }
    return result;
  }
}


