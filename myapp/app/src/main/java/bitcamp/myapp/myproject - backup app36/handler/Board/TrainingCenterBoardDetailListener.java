package bitcamp.myapp.myproject.handler.Board;

import bitcamp.myapp.myproject.dao.BoardDao;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardDetailListener implements ActionListener {

  BoardDao boardDao;

  public TrainingCenterBoardDetailListener(BoardDao boardDao) {
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

    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("내용: %s\n", board.getContent());
    System.out.printf("작성자: %s\n", board.getWriter());
    System.out.printf("조회수: %s\n", board.getViewCount());
    System.out.printf("등록일: %tY-%1$tm-%1$td\n", board.getCreatedDate());
    board.setViewCount(board.getViewCount() + 1);
  }


}


