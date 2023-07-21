// 파라미터 타입 - 상속 관계
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


  static <T extends B1> T echo(T obj) {
    return obj;
  }

  public static void main(String[] args) {

    // Object obj = echo(new Object());
    // A obj = echo(new A());
    B1 obj3 = echo(new B1());
    // B2 obj4 = echo(new B2());
    C obj5 = echo(new C());



  }
}


