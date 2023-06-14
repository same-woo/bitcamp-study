package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.util.Prompt;
import bitcamp.myapp.project.vo.Member;

public class MemberHandler {

  // variable initializer(변수 초기화 문장) -> static 블록으로 이동
  // 단 final 변수는 상수로 다룬다.
  private static final int MAX_SIZE = 100;

  private Prompt prompt;

  // variable initializer(변수 초기화 문장) -> 생성자로 이동
  private Member[] members = new Member[MAX_SIZE];

  private int length;

  // 생성자 : 인스턴스를 사용할 수 있도록 유효한 값으로 초기화 시키는 일을 한다.
  // 팔요한 값을 외부에서 받고 싶으면 파라미터를 선언하라.
  public MemberHandler(Prompt prompt) {
    // private Member[] members = new Member[MAX_SIZE]; //이렇게 이동된다.
    this.prompt = prompt;
  }

  public void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Member m = new Member();

    m.setName(this.prompt.inputString("이름? "));
    m.setEmail(this.prompt.inputString("이메일? "));
    m.setPassword(this.prompt.inputString("암호? "));
    m.setGender(inputGender((char) 0));

    // 위에서 만든 Member 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    members[this.length++] = m;
  }

  public void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }

  public void viewMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", m.getName());
        System.out.printf("이메일: %s\n", m.getEmail());
        System.out.printf("성별: %s\n", toGenderString(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  public void updateMember() {
    String memberNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == Integer.parseInt(memberNo)) {
        m.setName(this.prompt.inputString("이름(%s)? ", m.getName()));
        m.setEmail(this.prompt.inputString("이메일(%s)? ", m.getEmail()));
        m.setPassword(this.prompt.inputString("새암호? "));
        m.setGender(inputGender(m.getGender()));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  private char inputGender(char gender) {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }

    while (true) {
      String menuNo = this.prompt.inputString(label + "  1. 남자\n" + "  2. 여자\n" + "> ");

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

  public void deleteMember() {
    int memberNo = this.prompt.inputInt("번호? ");

    int deletedIndex = indexOf(memberNo);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.members[i] = this.members[i + 1];
    }

    this.members[--this.length] = null;
  }

  private int indexOf(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member m = this.members[i];
      if (m.getNo() == memberNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
