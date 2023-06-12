package bitcamp.myapp;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class App_copy  {

  final static int MAX_SIZE = 50;
  static int userId = 1;
  static int length = 10; // 가져올 기존 회원수 입력
  final static int num = length;
  static int lockused = 6;

  static int[] no = new int[MAX_SIZE];
  static String[] name = new String[MAX_SIZE];
  static int[] age = new int[MAX_SIZE];
  static String[] locker = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];
  static int[] remainingDays = new int[MAX_SIZE]; // 회원의 남은 기간 정보 (일 단위)

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Add default members
    addDefaultMembers(length, name, age, locker, gender, no, remainingDays);

    // Shuffle members
    shuffleMembers(name, age, locker, gender, no, remainingDays);

    while (true) {
      // 회원 조회 또는 회원 추가 선택
      System.out.println("---------------------------------------");

      System.out.println("1. 회원 조회");
      System.out.println("2. 회원 추가");
      System.out.println("3. 종료");
      System.out.print("선택: ");
      int choice = scanner.nextInt();

      if (choice == 1) {
        // 남은 기간에 따른 회원 목록 출력
        System.out.println("---------------------------------------");
        System.out.println("비트캠프 피트니스 남은 기간 및 회원 목록");
        System.out.println("---------------------------------------");

        // 1. 전체 회원의 남은 기간 출력
        System.out.println("   이름   나이 성별 락커  남은일수");
        printMembers(length, name, age, locker, gender, no, remainingDays);

        // 2. 30일 이하 남은 회원 목록 출력
        // System.out.println("2. 30일 이하 남은 회원 목록:");
        // printMembersByRemainingDays(length, no, name, remainingDays, 30);

        // 3. 10일 이하 남은 회원 목록 출력
        // System.out.println("3. 10일 이하 남은 회원 목록:");
        // printMembersByRemainingDays(length, no, name, remainingDays, 10);

      } else if (choice == 2) {
        // 회원 등록 및 정보 입력
        printTitle();
        for (int i = length; i < MAX_SIZE; i++) {
          inputMember(scanner, i, name, age, locker, gender, no, remainingDays, userId++);
          length++;
          if (!promptContinue(scanner)) {
            break;
          }
        }

      } else if (choice == 3) {
        // 종료
        System.out.println("프로그램을 종료합니다.");
        break;

      } else {
        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
      }
    }

    scanner.close();
  }

  static void printTitle() {
    System.out.println("헬스장에 등록할 회원정보를 입력합니다.");
    System.out.println("----------------------------------");
  }

  static void inputMember(Scanner scanner, int i, String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays, int userId) {

    if (i >= MAX_SIZE) {
      System.out.println("더 이상 회원을 추가할 수 없습니다.");
      return;
    }

    System.out.print("이름? ");
    name[i] = scanner.next();

    System.out.print("나이? ");
    age[i] = scanner.nextInt();

    loop: while (true) {
      System.out.println("락커 사용유무: ");
      System.out.println("  1. 사용");
      System.out.println("  2. 미사용");
      System.out.print("> ");
      String lockerUse = scanner.next();
      scanner.nextLine();

      switch (lockerUse) {
        case "1":
          locker[i] = "Locker " + lockused++;
          break loop;
        case "2":
          locker[i] = "미사용";
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

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

    loop: while (true) {
      System.out.println("회원권 등록일수 ? : ");
      System.out.println("  1. 3개월");
      System.out.println("  2. 6개월");
      System.out.println("  3. 12개월");
      System.out.print("> ");
      String menuNo = scanner.next();
      scanner.nextLine();

      switch (menuNo) {
        case "1":
          remainingDays[i] = 90;
          break loop;
        case "2":
          remainingDays[i] = 180;
          break loop;
        case "3":
          remainingDays[i] = 360;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }

    no[i] = userId + num; // 기존 회원수가 30명이므로..
  }

  static boolean promptContinue(Scanner scanner) {
    while (true) {
      System.out.print("계속 하시겠습니까?(Y/n)\n");
      System.out.print(">");

      String choice = scanner.nextLine();

      if (choice.equalsIgnoreCase("Y") || choice.equals("")) {
        return true;
      } else if (choice.equalsIgnoreCase("N")) {
        System.out.println("실행을 종료합니다.");
        return false;
      } else {
        System.out.println("유효하지 않은 입력입니다. 다시 입력해주세요.");
      }
    }
  }

  static void addDefaultMembers(int length, String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays) {
    String[] defaultNames = { "홍길동", "김철수", "이영희", "박영수", "정미경", "최성준", "백김동", "김지영", "오상훈", "최영환" };
    int[] defaultAges = { 25, 30, 27, 32, 29, 28, 24, 26, 31, 33 };
    String[] defaultLockers = { "Locker 1", "Locker 2", "Locker 3", "Locker 4", "Locker 5", "미사용", "미사용", "미사용", "미사용",
        "미사용" };
    char[] defaultGenders = { 'M', 'M', 'F', 'M', 'F', 'M', 'F', 'F', 'M', 'M' };
    int[] defaultRemainingDays = { 121, 60, 196, 84, 168, 186, 119, 194, 174, 90 };

    for (int i = 0; i < length; i++) {
      name[i] = defaultNames[i];
      age[i] = defaultAges[i];
      locker[i] = defaultLockers[i];
      gender[i] = defaultGenders[i];
      remainingDays[i] = defaultRemainingDays[i];
      no[i] = userId + i;
    }
  }

  static void shuffleMembers(String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays) {
    Random random = new Random();
    for (int i = length - 1; i >= 0; i--) {
      int j = random.nextInt(i + 1);
      swapMembers(name, age, locker, gender, no, remainingDays, i, j);
    }
  }

  static void swapMembers(String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays, int i, int j) {
    String tempName = name[i];
    int tempAge = age[i];
    String tempLocker = locker[i];
    char tempGender = gender[i];
    int tempRemainingDays = remainingDays[i];

    name[i] = name[j];
    age[i] = age[j];
    locker[i] = locker[j];
    gender[i] = gender[j];
    remainingDays[i] = remainingDays[j];

    name[j] = tempName;
    age[j] = tempAge;
    locker[j] = tempLocker;
    gender[j] = tempGender;
    remainingDays[j] = tempRemainingDays;
  }

  static void printMembers(int length, String[] name, int[] age, String[] locker,
      char[] gender, int[] no, int[] remainingDays) {

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %d, %c, %s, %d\n", no[i], name[i], age[i],
          gender[i], locker[i], remainingDays[i]);
    }
  }

}
