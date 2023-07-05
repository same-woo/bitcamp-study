package bitcamp.test.p1;

public class Test {
  public static void main(String[] args) {
    A obj = new A();

    // obj.v1 = 100; 접근불가 ! private이기 때문에 같은 클래스가 아니면 안된다 !
    obj.v2 = 200; // default
    obj.v3 = 300; // protect
    obj.v4 = 300; // public
    obj.m();
  }
}
