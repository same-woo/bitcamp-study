package bitcamp.myapp.myproject.handler.Board;

import java.util.List;
import bitcamp.myapp.myproject.dao.BoardDao;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardListListener implements ActionListener {

  BoardDao boardDao;

  public TrainingCenterBoardListListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");


    List<TrainingCenterBoard> list = boardDao.list();
    for (TrainingCenterBoard board : list) {
      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

}


