package bitcamp.myapp.myproject.handler.Employee;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.ActionListener;

public abstract class AbstractTrainingCenterEmployeeListener implements ActionListener {

  protected List<TrainingCenterEmployee> list;

  public AbstractTrainingCenterEmployeeListener(List<TrainingCenterEmployee> list) {
    this.list = list;
  }

  protected TrainingCenterEmployee findBy(int id) {
    for (int i = 0; i < this.list.size(); i++) {
      TrainingCenterEmployee t = this.list.get(i);
      if (t.getId() == id) {
        return t;
      }
    }
    return null;
  }



}
