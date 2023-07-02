package bitcamp.myapp.myproject.handler.Employee;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeDeleteListener extends AbstractTrainingCenterEmployeeListener {

  public TrainingCenterEmployeeDeleteListener(List<TrainingCenterEmployee> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int centerNo = prompt.inputInt("번호? ");

    TrainingCenterEmployee center = findBy(centerNo);
    if (center == null) {
      System.out.println("해당 번호의 직원이 없습니다!");
      return;
    }

    this.list.remove(center);
  }
}
