package bitcamp.myapp.myproject.handler.Employee;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeUpdateListener extends AbstractTrainingCenterEmployeeListener {

  public TrainingCenterEmployeeUpdateListener(List<TrainingCenterEmployee> list) {
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

    center.setName(prompt.inputString("이름(%s)? ", center.getName()));
    center.setName(prompt.inputString("나이(%s)? ", center.getAge()));
    center.setLocation(prompt.inputString("주소(%s)? ", center.getLocation()));
    center.setRank(prompt.inputString("직급(%s)? ", center.getRank()));
    center.setDepartment(prompt.inputString("부서(%s)? ", center.getDepartment()));
    center.setPassword(prompt.inputString("비밀번호(%s)? ", center.getPassword()));
  }
}
