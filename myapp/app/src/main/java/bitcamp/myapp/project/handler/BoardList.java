package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.vo.Board;

public class BoardList {
  private final static int DEFAULT_SIZE = 3;
  private Board[] boards = new Board[DEFAULT_SIZE];
  private int length = 0;

  public void add(Board b) {
    if (this.length == boards.length) {
      increase();
    }
    this.boards[this.length++] = b;
  }


  public Board[] list() {
    // 리턴할 값을 담은 배열을 생성
    Board[] arr = new Board[this.length];

    // 원본 배열에서 입력된 인스턴스 주소를 꺼내
    // 새 배열에 담는다.
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  private void increase() {
    Board[] arr = new Board[boards.length + (boards.length >> 1)];
    // 기존 배열의 값을 새 배열로 복사한다.

    for (int i = 0; i < boards.length; i++) {
      arr[i] = boards[i];
    }
    boards = arr;
    System.out.println("배열늘렸음!" + boards.length);
  }


  public Board get(int no) {

    for (Board b : boards) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  public boolean delete(int no) {
    int deletedIndex = indexOf(no);
    if (deletedIndex == -1) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return false;
    }

    for (int i = deletedIndex; i < this.length - 1; i++) {
      this.boards[i] = this.boards[i + 1];
    }
    this.boards[--this.length] = null;
    return true;
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


}
