package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  private Scanner scanner;

  // default constructor
  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  // 다른 입력 도구와 연결한다면
  public Prompt(InputStream in) {
    this.scanner = new Scanner(in);
  }

  public String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return this.scanner.nextLine();
  }

  public int inputInt(String title, Object... args) {
    while (true) {
      try {
        return Integer.parseInt(this.inputString(title, args));
      } catch (NumberFormatException e) {
        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
      }
    }
  }

  public void close() {
    this.scanner.close();
  }

}
