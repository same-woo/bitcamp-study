// 파라미터 타입 - 레퍼런스와 인스턴스
package com.eomcs.generic.ex02;

public class Exam0110 {

  static <T> T echo(T obj) {
    return obj;
  }

  public static void main(String[] args) {

    String str = echo(new String("Hello"));
    Integer i = echo(Integer.valueOf(100));
    Member m = echo(new Member("홍길동", 20));

  }
}


