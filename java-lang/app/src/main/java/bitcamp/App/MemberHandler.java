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
    }


  static void printMembers() {
        // 출력
        System.out.println("------------------------------");
        System.out.println("번호, 이름, 이메일, 성별");
        System.out.println("------------------------------");
        for (int i = 0; i < length; i++) {
            System.out.printf("%d %s %s %c\n",
                    num[i], name[i], email[i], gender[i]);
        }
  }


  public static boolean available() {
    return length < MAX_SIZE;
  }


}
