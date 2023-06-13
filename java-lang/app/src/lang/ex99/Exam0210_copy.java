package bitcamp.ex99;
import java.util.Scanner;

public class Exam0210_copy {
  public static void main(String[] args) {
    Scanner keyboardScanner = new Scanner(System.in);
    
    System.out.print("팀명? "); 
    String str = keyboardScanner.nextLine();

    System.out.println(str);
    keyboardScanner.close();
  }
}