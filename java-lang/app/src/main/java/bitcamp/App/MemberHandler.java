package bitcamp.myapp;
import bitcamp.myapp.Prompt; // Import the Prompt class

class MemberHandler {
    final static int MAX_SIZE = 3; // 배열 길이
    static int[] num = new int[MAX_SIZE];
    static String[] name = new String[MAX_SIZE];
    static String[] email = new String[MAX_SIZE];
    static String[] password = new String[MAX_SIZE];
    static char[] gender = new char[MAX_SIZE];
    static int userid = 1;
    static int length = 0;
    static final char MALE = 'M';
    static final char FEMALE = 'W';

    static void inputMember() {
      if (!available()) {
        System.out.println("더 이상 입력할 수 없습니다!");
        return;

      }
        name[length] = Prompt.prompt("이름?");
        email[length] = Prompt.prompt("이메일?");
        password[length] = Prompt.prompt("암호?");

        loop: while (true) { // true가 나올 때까지 반복한다.(라벨생성)
            String menuNO = Prompt.prompt("성별: \n" +
                " 1. 남자\n" +
                " 2. 여자\n" +
                "> ");

            switch (menuNO) { // if문 대신 사용가능. break때문에 loop 사용해야한다.
                case "1":
                    gender[length] = MALE;
                    break loop;
                case "2":
                    gender[length] = FEMALE;
                    break loop;
                default:
                    System.out.print("무효한 번호입니다.\n");
            }
        }
        num[length] = userid++;
        length++;
        whileinputMember();
    }


      // for문 배열 입력 (회원정보 입력)
    static void whileinputMember() {
    while (available()) {
    if (!App5.promptContinue()) {
      System.out.println("프로그램을 종료합니다.");
      break;
      inputMember();
      }

    }
  }

  static void printMembers() {
        // 출력
        System.out.println("------------------------------");
        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("------------------------------");
        for (int i = 0; i < length; i++) {
            System.out.printf("%d %s %s %c\n",
              num[i], name[i], email[i], 
              toGenderString(gender[i]));
        }
  }

  public static void viewMember() {
    String memberNo = Prompt.prompt("번호?");
    for (int i = 0; i <length; i++ ) {
      if (num[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", name[i]);
        System.out.printf("이메일: %s\n", email[i]);
        System.out.printf("성별: %s\n", toGenderString(gender[i]));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다.");
  }

  static boolean available() {
    return length < MAX_SIZE;
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

}
