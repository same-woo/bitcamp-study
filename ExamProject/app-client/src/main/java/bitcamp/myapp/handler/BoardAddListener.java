package bitcamp.myapp.handler;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class BoardAddListener implements ActionListener {

  int categoryNumber;
  BoardDao boardDao;

  public BoardAddListener(BoardDao boardDao, int categoryNumber) {
    this.boardDao = boardDao;
    this.categoryNumber = categoryNumber;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Board board = new Board();
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));
    board.setCategory(categoryNumber);

    boardDao.insert(board);
  }
}


