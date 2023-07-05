package bitcamp.myapp.myproject.handler.Board;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.ActionListener;

public abstract class AbstractTrainingCenterBoardLinstener implements ActionListener {

  protected List<TrainingCenterBoard> list;

  public AbstractTrainingCenterBoardLinstener(List<TrainingCenterBoard> list) {
    this.list = list;
  }

  protected TrainingCenterBoard findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      TrainingCenterBoard b = this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }



}
