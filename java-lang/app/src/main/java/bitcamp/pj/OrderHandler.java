package bitcamp.pj01;

import bitcamp.pj01.Prompt;

public class OrderHandler {
  
  static final int MAX_SIZE = 1;
  static int length = 0;

  static String[] tableNo = new String[MAX_SIZE];
  static String[] personsNo = new String[MAX_SIZE];
  static String[] food1 = new String[MAX_SIZE];
  static String[] food2 = new String[MAX_SIZE];
  static String[] soju = new String[MAX_SIZE];
  static String[] beer = new String[MAX_SIZE];

  public void inputMember() {
    loop: while (true) {
      String noTable = Prompt.inputString("테이블 번호를 선택해주세요.\n" + 
        "  1. 1번\n" +
        "  2. 2번\n" +
        "  3. 3번\n" +
        "  4. 4번\n" +
        "  5. 5번\n" +
        "  6. 6번\n" +
        "  7. 7번\n" +
        "  8. 8번\n" +
        "  9. 9번\n" +
        "  10. 10번\n" +
        "> ");

      switch (noTable) {
        case "1":
          tableNo[length] = "1번 테이블";
          break loop;
        case "2":
          tableNo[length] = "2번 테이블";
          break loop;
        case "3":
          tableNo[length] = "3번 테이블";
          break loop;
        case "4":
          tableNo[length] = "4번 테이블";
          break loop;
        case "5":
          tableNo[length] = "5번 테이블";
          break loop;
        case "6":
          tableNo[length] = "6번 테이블";
          break loop;
        case "7":
          tableNo[length] = "7번 테이블";
          break loop;
        case "8":
          tableNo[length] = "8번 테이블";
          break loop;
        case "9":
          tableNo[length] = "9번 테이블";
          break loop;
        case "10":
          tableNo[length] = "10번 테이블";
          break loop;
        default:
          System.out.println("무효한 번호입니다. 다시 선택해 주세요.");
      }
    }

    personsNo[length] = Prompt.inputString("몇 분이세요?");

    loop1: while (true) {
      String menuNo1 = Prompt.inputString("음식을 선택해주세요.\n" +
        "  1. 오뎅탕 11.0\n" +
        "  2. 화채 8.0\n" +
        "  3. 떡볶이 9.0\n" +
        "  4. 감자튀김 10.0\n" +
        "  5. 후라이드치킨 17.0\n" +
        "  6. 양념치킨 18.0\n" +
        "> ");

      switch (menuNo1) {
        case "1": 
          food1[length] = "오뎅탕";
          break loop1;
        case "2":
          food1[length] = "화채";
          break loop1;
        case "3":
          food1[length] = "떡볶이";
          break loop1;
        case "4":
          food1[length] = "감자튀김";
          break loop1;
        case "5":
          food1[length] = "후라이드치킨";
          break loop1;
        case "6":
          food1[length] = "양념치킨";
          break loop1;
        default:
          System.out.println("무효한 번호입니다. 다시 선택해 주세요.");
      }
    }

    loop2: while (true) {
      String menuNo2 = Prompt.inputString("두 번째 음식을 선택해주세요.\n" +
        "  1. 오뎅탕 11.0\n" +
        "  2. 화채 8.0\n" +
        "  3. 떡볶이 9.0\n" +
        "  4. 감자튀김 10.0\n" +
        "  5. 후라이드치킨 17.0\n" +
        "  6. 양념치킨 18.0\n" +
        "  7. 하나만 주문할게요.\n" +
        "> ");

      switch (menuNo2) {
        case "1":
          food2[length] = "오뎅탕";
          break loop2;
        case "2":
          food2[length] = "화채";
          break loop2;
        case "3":
          food2[length] = "떡볶이";
          break loop2;
        case "4":
          food2[length] = "감자튀김";
          break loop2;
        case "5":
          food1[length] = "후라이드치킨";
          break loop2;
        case "6":
          food1[length] = "양념치킨";
          break loop2;
        case "7":
          food2[length] = "주문 없음";
          break loop2;
        default:
          System.out.println("무효한 번호입니다. 다시 선택해주세요.");
      }
    }

    loop3: while (true) {
      String sojuNo = Prompt.inputString("소주를 선택해주세요. (종류 상관없이 6.0)\n" +
        "  1. 진로\n" +
        "  2. 참이슬\n" +
        "  3. 처음처럼\n" +
        "  4. 새로\n" +
        "  5. 소주 주문을 안 할래요.\n" +
        "> ");

      switch (sojuNo) {
        case "1":
          soju[length] = "진로";
          break loop3;
        case "2":
          soju[length] = "참이슬";
          break loop3;
        case "3":
          soju[length] = "처음처럼";
          break loop3;
        case "4":
          soju[length] = "새로";
          break loop3;
        case "5":
          soju[length] = "소주 주문 없음";
          break loop3;
        default:
          System.out.println("무효한 번호입니다. 다시 선택해 주세요.");
      }
    }

    loop4: while (true) {
      String beerNo = Prompt.inputString("맥주를 선택해주세요. (종류 상관없이 7.0)\n" +
        "  1. 카스\n" +
        "  2. 테라\n" +
        "  3. 켈리\n" +
        "  4. 맥주 주문 안 할래요.\n" +
        "> ");

      switch (beerNo) {
        case "1":
          beer[length] = "카스";
          break loop4;
        case "2":
          beer[length] = "테라";
          break loop4;
        case "3":
          beer[length] = "켈리";
          break loop4;
        case "4":
          beer[length] = "맥주 주문 없음";
          break loop4;
        default:
          System.out.println("무효한 번호입니다. 다시 선택해 주세요.");
      }
    }

    length++;
    System.out.println("주문해주셔서 감사합니다! 맛있게 만들어 드릴게요 :)");
  }

  public void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("테이블 번호, 손님 수, 안주 1, 안주 2, 소주, 맥주");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%s, %s, %s, %s, %s, %s\n", tableNo[i], personsNo[i], 
        food1[i], food2[i], soju[i], beer[i]);
    }
  }

  public boolean available() {
    return length < MAX_SIZE;
  }

  public static void main(String[] args) {
    // Create an instance of OrderHandler
    OrderHandler orderHandler = new OrderHandler();
    
    // Call the inputMember method
    orderHandler.inputMember();
    
    // Call the printMembers method
    orderHandler.printMembers();
  }
}
