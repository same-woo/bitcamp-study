package bitcamp.myapp.myproject.handler.Board;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardDeleteListener extends AbstractTrainingCenterBoardLinstener {

  public TrainingCenterBoardDeleteListener(List<TrainingCenterBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int centerNo = prompt.inputInt("번호? ");

    TrainingCenterBoard center = findBy(centerNo);
    if (center == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }
    System.out.println(centerNo + "번의 게시글 정보를 삭제했습니다");
    this.list.remove(center);
  }
}


