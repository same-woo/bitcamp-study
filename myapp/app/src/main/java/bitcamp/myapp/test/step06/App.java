package bitcamp.myapp.test.step06;

// 1) 낱개의 변수사용
// 2) 낱개의 변수 재사용
// 3) 배열 사용
// 4) 클래스 타입을 이용하여 데이터 정의 (중첩클래스; 로컬클래스)
// 5) 출력 기능을 별도의 메서드로 분리 + (중첩클래스; 스태틱클래스)
// 6) 합계 및 평균을 계산

public class App {
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {

    // String[] name = new String[10];
    // int[] kor = new int[10];
    // int[] eng = new int[10];
    // int[] math = new int[10];
    // int[] sum = new int[10];
    // float[] aver = new float[10];

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;


    //
    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math = 100;
    compute(s);
    scores[length++] = s;

    s = new Score();
    s.name = "임꺽정";
    s.kor = 90;
    s.eng = 90;
    s.math = 90;
    compute(s);
    scores[length++] = s;

    s = new Score();
    s.name = "유관순";
    s.kor = 80;
    s.eng = 80;
    s.math = 80;
    compute(s);
    scores[length++] = s;

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }

  }

  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }


  static void printScore(Score s) {
    System.out.printf("%s: 합계=%d, 평균=%f\n", s.name, s.sum, s.aver);
  }


}

