// Worker 구현체 사용
package com.eomcs.oop.ex09.a1.after;

// 작업:
// 1) worker 객체의 사용 규칙을 정의한다.
// => Worker 인터페이스 정의
// 2) 클래스를 정의할 때 Worker 규칙에 따라 만든다.
// => BlueWorker, WhiteWorker, JubuWorker 클래스 변경
// 3) worker를 사용하는 측에서는 Worker 인터페이스에 정의된 대로 메서드를 호출한다.
// => Exam01 클래스 변경
//
public class Exam02 {
  public static void main(String[] args) {
    work(new BlueWorker());
    work(new JubuWorker());
    work(new WhiteWorker());
//    work(new HulWorker()); // HullWorker는 공식적으로 Worker 규칙을 따르지 않는다.


  }


  // 작업자에게 일을 시키는 메서드
  static void work(Worker worker) {
    worker.execute();
  }
}


