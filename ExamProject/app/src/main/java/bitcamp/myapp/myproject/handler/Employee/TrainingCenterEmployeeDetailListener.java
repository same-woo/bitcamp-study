package bitcamp.myapp.myproject.handler.Employee;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeDetailListener extends AbstractTrainingCenterEmployeeListener {

  public TrainingCenterEmployeeDetailListener(List<TrainingCenterEmployee> list) {
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

    System.out.printf("이름: %s\n", center.getName());
    System.out.printf("나이: %d\n", center.getAge());
    System.out.printf("주소: %s\n", center.getLocation());
    System.out.printf("직급: %s\n", center.getRank());
    System.out.printf("부서: %s\n", center.getDepartment());
  }
}
