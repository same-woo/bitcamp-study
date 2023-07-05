package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.dao.BoardDao;
import bitcamp.myapp.project.vo.Board;
import bitcamp.util.BreadcrumbPrompt;

public class BoardAddListener implements BoardActionListener {

  BoardDao boardDao;


  public BoardAddListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    Board board = new Board();
    board.setNo(Board.boardNo++);
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));
    board.setCreatedDate(System.currentTimeMillis());

    boardDao.insert(board);
  }
}


