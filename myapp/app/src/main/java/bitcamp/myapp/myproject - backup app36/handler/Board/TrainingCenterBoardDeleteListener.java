package bitcamp.myapp.myproject.handler.Board;

import bitcamp.myapp.myproject.dao.BoardDao;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardDeleteListener implements ActionListener {

  BoardDao boardDao;

  public TrainingCenterBoardDeleteListener(BoardDao boardDao) {
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
    System.out.println(boardNo + "번의 게시글 정보를 삭제했습니다");
    this.boardDao.delete(boardNo);
  }
}


