// 파라미터 타입 - 레퍼런스와 인스턴스 - 상속 관계 : extends
package com.eomcs.generic.ex02;

public class Exam0112 {

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
    Box<? extends B1> box1;
    // <B1>의 기능을 가진 박스라면 올 수 있다. <- B1이나 B1의 자식들 !

    // box1 = new Box<A>(); //컴파일 오류!
    // box1 = new Box<Object>(); //컴파일 오류!
    box1 = new Box<B1>();
    box1 = new Box<C>(); // <- B1의 자식인 C도 올 수 있는 것이다.
    // box1 = new Box<C>(); //컴파일 오류!

  }
}


