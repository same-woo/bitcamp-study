// 파라미터 타입 - 레퍼런스와 인스턴스 - 기본
package com.eomcs.generic.ex02;

public class Exam0111 {

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

    Box<B1> box1;
    // <B1>을 담는 박스만 올 수 있다. 서브클래스도 못온다.

    // box1 = new Box<A>(); //컴파일 오류!
    // box1 = new Box<Object>(); //컴파일 오류!
    box1 = new Box<B1>();
    // box1 = new Box<C>(); //컴파일 오류!



  }
}


