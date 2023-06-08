package bitcamp.myapp;

import java.util.Scanner;

public class Prompt {
  
  Scanner scanner = new Scanner(System.in);

  public static String prompt(String message) {
    System.out.print(message);
    return scanner.nextLine();
  }

  public static void close() {
    scanner.close();
  }
}
