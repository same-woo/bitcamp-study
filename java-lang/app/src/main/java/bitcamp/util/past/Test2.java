package bitcamp.myapp;

class MyClass {
  int myVariable = 0; // 인스턴스 변수

  void setVariable(int value) {
    myVariable += value; // 인스턴스 변수에 값 할당
  }

  public static void main(String[] args) {
    MyClass myObject = new MyClass(); // MyClass의 객체 생성
    System.out.println(myObject.myVariable); // 인스턴스 변수 출력
    myObject.setVariable(10); // 인스턴스 메서드 호출하여 인스턴스 변수에 값을 할당
    System.out.println(myObject.myVariable);
    myObject.setVariable(10); // 인스턴스 메서드 호출하여 인스턴스 변수에 값을 할당
    System.out.println(myObject.myVariable); // 인스턴스 변수 출력
    myObject.print2();
  }

  void print2() {
    System.out.println(myVariable); // 인스턴스 변수 출력
  }
}
