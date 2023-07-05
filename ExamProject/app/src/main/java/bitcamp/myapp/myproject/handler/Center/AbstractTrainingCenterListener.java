package bitcamp.myapp.myproject.handler.Center;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.ActionListener;

public abstract class AbstractTrainingCenterListener implements ActionListener {

  protected List<TrainingCenter> list;

  public AbstractTrainingCenterListener(List<TrainingCenter> list) {
    this.list = list;
  }

  protected TrainingCenter findBy(int id) {
    for (int i = 0; i < this.list.size(); i++) {
      TrainingCenter t = this.list.get(i);
      if (t.getId() == id) {
        return t;
      }
    }
    return null;
  }



}
