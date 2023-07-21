package my.java.coding.ex01;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiFunction;

public class Test4 {

  public static void main(String[] args) {

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
      result.compute(ch, new BiFunction<Character, Integer, Integer>() {
        @Override
        public Integer apply(Character key, Integer value) {
          // 이 메서드는 Map.compute() 호출한다.
          // 파라미터로 넘어오는 것은 기존에 저장된 키와 값이다.
          // 해당 키의 값이 없다면 null이 넘어온다.

          return (value == null) ? 1 : value + 1;
        }
      });
    }

    for (Entry<Character, Integer> entry : result.entrySet()) {
      System.out.printf("%c:%d\n", entry.getKey(), entry.getValue());
    }

  }
}


