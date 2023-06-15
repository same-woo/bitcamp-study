package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.util.Prompt;
import bitcamp.myapp.project.vo.Board;

public class BoardHandler implements Handler {

  private BoardList list = new BoardList();
  private Prompt prompt;

  private String title;

  public BoardHandler(Prompt prompt, String title) {
    this.prompt = prompt;
    this.title = title;
  }

  @Override
  public void execute() {
    printMenu();

    while (true) {
      String menuNo = prompt.inputString("%s> ", this.title);
      if (menuNo.equals("0")) {
        return;
      } else if (menuNo.equals("menu")) {
        printMenu();
        // 회원등록
      } else if (menuNo.equals("1")) {
        this.inputBoard();
      } else if (menuNo.equals("2")) {
        this.printBoards();
      } else if (menuNo.equals("3")) {
        this.viewBoard();
      } else if (menuNo.equals("4")) {
        this.updateBoard();
      } else if (menuNo.equals("5")) {
        this.deleteBoard();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }


  private static void printMenu() {
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 조회");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
    System.out.println("0. 메인");
  }

  private void inputBoard() {
    Board b = new Board();
    b.setTitle(this.prompt.inputString("제목? "));
    b.setContent(this.prompt.inputString("내용? "));
    b.setWriter(this.prompt.inputString("작성자 "));
    b.setPassword(this.prompt.inputString("암호? "));

    this.list.add(b);
  }

  private void printBoards() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 작성일");
    System.out.println("---------------------------------------");


    Board[] arr = this.list.list();
    for (Board b : arr) {
      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td-%5$tH:%5$tM\n", b.getNo(), b.getTitle(),
          b.getWriter(), b.getViewCount(), b.getCreatedDate());
    }

  }

  private void viewBoard() {
    int boardNo = this.prompt.inputInt("번호? ");
    Board b = list.get(boardNo);
    if (b == null) {
      return;
    }
    System.out.printf("제목: %s\n", b.getTitle());
    System.out.printf("내용: %s\n", b.getContent());
    System.out.printf("작성자: %s\n", b.getWriter());
    System.out.printf("조회수: %s\n", b.getViewCount());
    System.out.printf("등록일: %tY-%1$tm-%1$td\n", b.getCreatedDate());
  }


  private void updateBoard() {
    int boardNo = this.prompt.inputInt("번호? ");
    Board b = list.get(boardNo);
    if (b == null) {
      System.out.printf("암호가 일치하지 않습니다.");
      return;
    }
    b.setTitle(this.prompt.inputString("제목(%s)?", b.getTitle()));
    b.setContent(this.prompt.inputString("내용(%s)", b.getContent()));

    return;
  }

  private void deleteBoard() {
    int BoardNo = this.prompt.inputInt("번호? ");

    if (this.list.delete(BoardNo)) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }
  }


}
