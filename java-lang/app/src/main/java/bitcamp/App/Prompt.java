package bitcamp.myapp;
import java.util.Scanner;

class Prompt {
  static Scanner keyboardScanner = new Scanner(System.in);

  static String prompt(String title)  {
    System.out.print(title);
    return keyboardScanner.nextLine();
  }

  public static void close() {
    keyboardScanner.close();
  }
}
