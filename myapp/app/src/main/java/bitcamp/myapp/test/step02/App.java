package bitcamp.myapp.test.step02;

// 1) 낱개의 변수사용
// 2) 낱개의 변수 재사용
public class App {

  public static void main(String[] args) {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    name = "홍길동";
    kor = 100;
    eng = 100;
    math = 100;

    sum = kor + eng + math;
    aver = sum / 3f;

    System.out.printf("%s: 합계=%d, 평균=%f\n", name, sum, aver);

    name = "임꺽정";
    kor = 100;
    eng = 100;
    math = 100;

    sum = kor + eng + math;
    aver = sum / 3f;

    System.out.printf("%s: 합계=%d, 평균=%f\n", name, sum, aver);

    name = "유관순";
    kor = 100;
    eng = 100;
    math = 100;

    sum = kor + eng + math;
    aver = sum / 3f;

    System.out.printf("%s: 합계=%d, 평균=%f\n", name, sum, aver);
  }


}
