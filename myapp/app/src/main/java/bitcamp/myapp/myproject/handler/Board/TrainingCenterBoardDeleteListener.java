package bitcamp.myapp.myproject.handler.Board;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.myapp.project.vo.Board;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardDeleteListener extends AbstractTrainingCenterBoardLinstener {

  public TrainingCenterBoardDeleteListener(List<TrainingCenterBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Board(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }
}


