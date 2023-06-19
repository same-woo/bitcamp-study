package bitcamp.myapp.myproject.handler;

import bitcamp.myapp.myproject.vo.Member;
import bitcamp.util.Prompt;


public class MemberHandler {

  static final int MAX_SIZE = 100;
  static Member[] members = new Member[MAX_SIZE];
  static int length = 0;


  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();
    m.setName(Prompt.inputString("이름? "));
    m.setAge(Prompt.inputInt("나이?"));
    m.setRemainingDays(inputdays());
    m.setGender(inputGender((char) 0));
    m.setLocker(inputlocker());

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    members[length++] = m;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 남은기간, 성별, 락커사용유무");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %d, %d, %s,%s\n", m.getNo(), m.getName(), m.getAge(),
          m.getRemainingDays(), toGenderString(m.getGender()), tolockerString(m.isLocker()));
    }
  }

  public static void viewMember() {
    System.out.println("");
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("나이: %d살\n", m.getAge());
        System.out.printf("남은기간: %d일\n", m.getRemainingDays());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        System.out.printf("락커사용유무: %s\n", tolockerString(m.isLocker()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public static String tolockerString(boolean locker) {
    return locker ? "O" : "X";
  }


  public static void updateMember() {
    System.out.println("");
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름(%s)? ", m.getName());
        m.setName(Prompt.inputString(""));
        System.out.printf("나이(%d)? ", m.getAge());
        m.setAge(Prompt.inputInt(""));
        System.out.printf("남은기간(%d)? ", m.getRemainingDays());
        m.setRemainingDays(inputdays());
        m.setGender(inputGender(m.getGender()));
        m.setLocker(inputlocker());
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private static char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    loop: while (true) {
      String menuNo = Prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    System.out.println("");
    int memberNo = Prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < length - 1; i++) {
      members[i] = members[i + 1];
    }

    members[--length] = null;
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      Member m = members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private static boolean inputlocker() {
    String choice = Prompt.inputString("락커를 사용하시겠습니까? (Y/n) ");
    while (true) {
      if (choice.equalsIgnoreCase("Y") || choice.isBlank()) {
        return true;
      } else {
        return false;
      }
    }
  }


  private static int inputdays() {
    System.out.println("");
    System.out.println("등록할 기간을 정해주세요");

    loop: while (true) {
      String menuNo2 = Prompt.inputString("  1. 3개월\n" + "  2. 6개월\n" + "  3. 12개월\n" + "> ");

      switch (menuNo2) {
        case "1":
          return 90;
        case "2":
          return 180;
        case "3":
          return 360;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }


}
