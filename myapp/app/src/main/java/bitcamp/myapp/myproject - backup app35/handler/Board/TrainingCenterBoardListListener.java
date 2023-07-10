package bitcamp.myapp.myproject.handler.Board;

import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardListListener extends AbstractTrainingCenterBoardLinstener {

  public TrainingCenterBoardListListener(List<TrainingCenterBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 등록일");
    System.out.println("---------------------------------------");

    Iterator<TrainingCenterBoard> iterator = list.iterator();

    while (iterator.hasNext()) {
      TrainingCenterBoard board = iterator.next();
      System.out.printf("%d, %s, %s, %d, %tY-%5$tm-%5$td\n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

}


