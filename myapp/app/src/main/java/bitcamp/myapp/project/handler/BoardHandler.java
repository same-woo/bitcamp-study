package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.util.Prompt;
import bitcamp.myapp.project.vo.Board;

public class BoardHandler {

  private final static int MAX_SIZE = 100;

  private Prompt prompt;
  private Board[] boards = new Board[MAX_SIZE];
  private int length = 0;

  public BoardHandler(Prompt prompt) {
    this.prompt = prompt;
  }

  public void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    Board board = new Board();
    board.setTitle(this.prompt.inputString("제목? "));
    board.setContent(this.prompt.inputString("내용? "));
    board.setWriter(this.prompt.inputString("작성자 "));
    board.setPassword(this.prompt.inputString("암호? "));

    // 위에서 만든 Board 인스턴스의 주소를 잃어버리지 않게
    // 레퍼런스 배열에 담는다.
    this.boards[this.length++] = board;
  }

  public void printBoards() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 작성일");
    System.out.println("---------------------------------------");


    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];

      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td-%5$tH:%5$tM\n", board.getNo(),
          board.getTitle(), board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

  public void viewBoard() {
    String boardNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        System.out.printf("제목: %s\n", board.getTitle());
        System.out.printf("내용: %s\n", board.getContent());
        System.out.printf("작성자: %s\n", board.getWriter());
        System.out.printf("조회수: %s\n", board.getViewCount());
        System.out.printf("등록일 : %tY-%1$tm-%1$td-%1$tH:%1$tM\n", board.getCreatedDate());
        board.setViewCount(board.getViewCount() + 1);
        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }


  public void updateBoard() {
    String boardNo = this.prompt.inputString("번호? ");
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == Integer.parseInt(boardNo)) {
        if (!this.prompt.inputString("암호?").equals(board.getPassword())) {
          System.out.printf("암호가 일치하지 않습니다.");
          return;
        }

        board.setTitle(this.prompt.inputString("제목(%s)?", board.getTitle()));
        board.setContent(this.prompt.inputString("내용(%s)", board.getContent()));

        return;
      }
    }
    System.out.println("해당 번호의 게시글이 없습니다!");
  }

  public void deleteBoard() {
    int deletedIndex = indexOf(this.prompt.inputInt("번호? "));
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.boards[i] = this.boards[i + 1];
    }

    this.boards[--this.length] = null;
  }

  private int indexOf(int boardNo) {
    for (int i = 0; i < this.length; i++) {
      Board board = this.boards[i];
      if (board.getNo() == boardNo) {
        return i;
      }
    }
    return -1;
  }

  private boolean available() {
    return this.length < MAX_SIZE;
  }
}
