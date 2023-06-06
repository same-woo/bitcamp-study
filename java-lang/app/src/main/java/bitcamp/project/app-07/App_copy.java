package bitcamp.myapp;

import java.util.Scanner;

public class App_copy {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    final int MAX_SIZE = 50;
    int userId = 1;
    int length = 0;

    int[] no = new int[MAX_SIZE];
    String[] name = new String[MAX_SIZE];
    int[] age = new int[MAX_SIZE];
    String[] locker = new String[MAX_SIZE];
    char[] gender = new char[MAX_SIZE];
    int[] remainingDays = new int[MAX_SIZE]; // 회원의 남은 기간 정보 (일 단위)

    // Add default members
    addDefaultMembers(MAX_SIZE, name, age, locker, gender, no, remainingDays);

    // 회원 조회 또는 회원 추가 선택
    System.out.println("1. 회원 조회");
    System.out.println("2. 회원 추가");
    System.out.print("선택: ");
    int choice = scanner.nextInt();

    if (choice == 1) {
      // 회원 목록 출력
      System.out.println("---------------------------------------");
      System.out.println("회원 목록");
      System.out.println("---------------------------------------");
      printMembers(length, no, name, age, gender);

      // 남은 기간에 따른 회원 목록 출력
      System.out.println("---------------------------------------");
      System.out.println("헬스 남은 기간 및 회원 목록");
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

    } else if (choice == 2) {
      // 회원 등록 및 정보 입력
      printTitle();
      for (int i = 0; i < MAX_SIZE; i++) {
        inputMember(scanner, i, name, age, locker, gender, no, remainingDays, userId++);
        length++;
        if (!promptContinue(scanner)) {
          break;
        }
      }
    } else {
      System.out.println("잘못된 선택입니다.");
    }

    scanner.close();
  }

  static void printTitle() {
    System.out.println("헬스장에 등록할 회원정보를 입력합니다.");
    System.out.println("----------------------------------");
  }

  static void inputMember(Scanner scanner, int i, String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays, int userId) {

    System.out.print("이름? ");
    name[i] = scanner.next();

    System.out.print("나이? ");
    age[i] = scanner.nextInt();

    System.out.print("암호? ");
    locker[i] = scanner.next();

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
    String response = scanner.next();
    if (!response.equalsIgnoreCase("Y")) {
      return false;
    }
    return true;
  }

  static void printMembers(int length, int[] no, String[] name, int[] age, char[] gender) {
    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %d, %c\n", no[i], name[i], age[i], gender[i]);
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

  static void addDefaultMembers(int length, String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays) {
    String[] defaultNames = {
        "John", "Jane", "Michael", "Emily", "William", "Olivia", "James", "Sophia", "Benjamin",
        "Isabella", "Jacob", "Mia", "Matthew", "Ava", "Daniel", "Charlotte", "Joseph", "Amelia",
        "David", "Harper", "Andrew", "Evelyn", "Logan", "Abigail", "Joshua", "Emily", "Ethan",
        "Elizabeth", "Alexander", "Sofia"
    };

    for (int i = 0; i < length; i++) {
      name[i] = defaultNames[i];
      age[i] = i + 1; // Assign a unique age for each member
      locker[i] = "Locker " + (i + 1);
      gender[i] = (i % 2 == 0) ? 'M' : 'F';
      no[i] = i + 1;
      remainingDays[i] = (int) (Math.random() * 365) + 1;
    }
  }
}
