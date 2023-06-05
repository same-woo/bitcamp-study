package bitcamp.myapp;

import java.util.Scanner;

public class App_copy {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 100;
    int userId = 1;
    int length = 0;

    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    String[] email = new String[MAX_SIZE];
    String[] password = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];
    int[] remainingDays = new int[MAX_SIZE]; // 회원의 남은 기간 정보 (일 단위)

    // 회원 등록 및 정보 입력
    printTitle();
    for (int i = 0; i < MAX_SIZE; i++) {
      inputMember(scanner, i, name, email, password, gender, no, remainingDays, userId++);
      length++;
      if (!promptContinue(scanner)) {
        break;
      }
    }

    // 회원 목록 출력
    printMembers(length, no, name, email, gender);

    // 남은 기간에 따른 회원 목록 출력
    System.out.println("---------------------------------------");
    System.out.println("남은 기간에 따른 회원 목록");
    System.out.println("---------------------------------------");

    // 1. 전체 회원의 남은 기간 출력
    System.out.println("1. 전체 회원의 남은 기간:");
    printRemainingDays(length, no, name, remainingDays);

    // 2. 30일 이하 남은 회원 목록 출력
    System.out.println("2. 30일 이하 남은 회원 목록:");
    printMembersByRemainingDays(length, no, name, remainingDays, 30);

    // 3. 10일 이하 남은 회원 목록 출력
    System.out.println("3. 10일 이하 남은 회원 목록:");
    printMembersByRemainingDays(length, no, name, remainingDays, 10);

    scanner.close();
  }

  static void printTitle() {
    System.out.println("헬스장 회원 관리 시스템");
    System.out.println("----------------------------------");
  }

  static void inputMember(Scanner scanner, int i, String[] name, String[] email, String[] password,
      char[] gender, int[] no, int[] remainingDays, int userId) {

    System.out.print("이름? ");
    name[i] = scanner.next();

    System.out.print("이메일? ");
    email[i] = scanner.next();

    System.out.print("암호? ");
    password[i] = scanner.next();

    loop: while (true) {
      System.out.println("성별: ");
      System.out.println("  1. 남자");
      System.out.println("  2. 여자");
      System.out.print("> ");
      String menuNo = scanner.next();
      scanner.nextLine();

      switch (menuNo) {
        case "1":
          gender[i] = 'M';
          break loop;
        case "2":
          gender[i] = 'W';
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    no[i] = userId;
    remainingDays[i] = (int) (Math.random() * 365) + 1; // 임의의 값으로 회원의 남은 기간 설정 (1일부터 365일)
  }

  static boolean promptContinue(Scanner scanner) {
    System.out.print("계속 하시겠습니까?(Y/n) ");
    String response = scanner.nextLine();
    if (!response.equals("") && !response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers(int length, int[] no, String[] name, String[] email, char[] gender) {
    System.out.println("---------------------------------------");
    System.out.println("회원 목록");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %c\n", no[i], name[i], email[i], gender[i]);
    }
  }

  static void printRemainingDays(int length, int[] no, String[] name, int[] remainingDays) {
    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s: %d일\n", no[i], name[i], remainingDays[i]);
    }
  }

  static void printMembersByRemainingDays(int length, int[] no, String[] name, int[] remainingDays,
      int daysThreshold) {
    for (int i = 0; i < length; i++) {
      if (remainingDays[i] <= daysThreshold) {
        System.out.printf("%d, %s: %d일\n", no[i], name[i], remainingDays[i]);
      }
    }
  }
}
