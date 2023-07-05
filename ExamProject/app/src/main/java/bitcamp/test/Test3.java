package bitcamp.test;

import bitcamp.test.p1.A;

public class Test3 extends A {
  public static void main(String[] args) {
    A obj = new A();

    // obj.v1 = 100; // private
    // obj.v2 = 200; // default
    // obj.v3 = 300; // obj는 A라는 설계도에 따라 만든 객체이므로 자식 클래스가 아니다.
    // 따라서 protected에 접근할 수 없다.
    obj.v4 = 300; // public
    // obj.m(); // 접근불가 ! <== 상속받은 멤버가 아니다 ! 따라서 A클래스의 m 메서드에 접근 불가 !


    Test3 obj2 = new Test3();
    // obj2.v1 = 100; // private이기때문에 접근불가. 같은 클래스 멤버이어야 한다.
    // obj2.v2 = 200; // test3가 상속받아서 만든 변수이지만, 접근불가. default는 같은 패키지이어야 한다.
    obj2.v3 = 300; // test3가 상속받아서 만든 필드! 자식 클래스가 protected에 접근 가능하다.
    obj2.m(); // 자식 클래스가 상속 받아서 사용하는 멤버이다 ! (A 클래스의 m이라는 메서드에 접근)
  }

}
