package bitcamp.test;

import bitcamp.test.p1.A;

public class Test2 {
  public static void main(String[] args) {
    A obj = new A();

    // obj.v1 = 100; // private
    // obj.v2 = 200; // default
    // obj.v3 = 300; // protected
    obj.v4 = 300; // public
    // obj.m();
  }
}
