package bitcamp.myapp.myproject.handler.Board;

import bitcamp.myapp.myproject.dao.BoardDao;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardUpdateListener implements ActionListener {

  BoardDao boardDao;

  private String temp = "";

  public TrainingCenterBoardUpdateListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int boardNo = prompt.inputInt("번호? ");

    TrainingCenterBoard board = boardDao.findBy(boardNo);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    System.out.println("어떤 정보를 변경하시겠습니까?");
    System.out.println("(0) 전체변경");
    System.out.println("(1) 제목 변경");
    System.out.println("(2) 내용 변경");

    int changeNo = prompt.inputInt("번호? ");
    switch (changeNo) {
      case 1:
        temp = board.getTitle();
        board.setTitle(prompt.inputString("제목(%s)? ", board.getTitle()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, board.getTitle());
        break;
      case 2:
        temp = board.getContent();
        board.setContent(prompt.inputString("내용(%s)? ", board.getContent()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, board.getContent());
        break;
      case 0:
        System.out.println("전체 내용을 변경합니다.");
        board.setTitle(prompt.inputString("제목(%s)? ", board.getTitle()));
        board.setContent(prompt.inputString("내용(%s)? ", board.getContent()));

      default:
        break;
    }
  }
}
