package bitcamp.myapp.myproject.handler.Board;

import bitcamp.myapp.myproject.dao.BoardDao;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardAddListener implements ActionListener {

  BoardDao boardDao;

  public TrainingCenterBoardAddListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    TrainingCenterBoard board = new TrainingCenterBoard();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));
    this.boardDao.insert(board);
  }
}


