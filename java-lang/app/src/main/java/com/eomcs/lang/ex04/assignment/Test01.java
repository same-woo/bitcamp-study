
package assignment;
public class Test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        System.out.print("이름이 무엇입니까? ");
        String name = keyScan.nextLine();

        System.out.print("리눅스 시험은 몇점입니까? ");
        int kor = keyScan.nextInt();

        System.out.print("파이썬 시험은 몇점입니까? ");
        // 이전에 국어 점수를 입력받을 때 들어온 줄바꿈 코드는 
        // nextInt() 메서드에서 버린다.
        int eng = keyScan.nextInt();

        System.out.print("자바 시험은 몇점입니까? ");
        int math = keyScan.nextInt();

        int sum = kor + eng + math;
        float average = sum / 3;

        System.out.println("------------------------------");
        System.out.print(name+"님의 점수는");
        System.out.print(" ");
        System.out.print("리눅스"+kor+"점");
        System.out.print(" ");
        System.out.print("파이썬"+eng+"점");
        System.out.print(" ");
        System.out.print("자바"+math+"점");
        System.out.print(" ");
        System.out.println();       
        System.out.print("총합"+sum+"점");
        System.out.print(" ");
        System.out.println();
        System.out.println("평균점수는 " + average + "점입니다.");
        System.out.println();
    }
}