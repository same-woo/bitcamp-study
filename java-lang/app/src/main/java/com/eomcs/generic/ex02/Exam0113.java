// 파라미터 타입 - 레퍼런스와 인스턴스 - 상속 관계 : super
package com.eomcs.generic.ex02;

public class Exam0113 {

  static class A {
  }
  static class B1 extends A {
  }
  static class B2 extends A {
  }
  static class C extends B1 {
  }

  // /*
  // * Object
  // * |
  // * A
  // * / \
  // * B1 B2
  // * | \
  // * C D
  // */


  static class Box<T> {
    void set(T obj) {}
  }

  public static void main(String[] args) {
    Box<? super B1> box1;
    // <B1>이 담겨있거나 B1의 수퍼클래스가 담겨있는 박스라면 올 수 있다. <- B1이나 B1의 자식들 !

    box1 = new Box<Object>(); // B1의 수퍼클래스
    box1 = new Box<A>(); // B1의 수퍼클래스
    box1 = new Box<B1>(); // B1 자신 클래스
    // box1 = new Box<C>(); //컴파일 오류! 자식클래스로서, 더 많은 기능이 담겨있어서 오류 !

  }
}


