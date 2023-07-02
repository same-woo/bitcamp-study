package bitcamp.myapp.myproject.handler.Employee;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeAddListener extends AbstractTrainingCenterEmployeeListener {

  public TrainingCenterEmployeeAddListener(List<TrainingCenterEmployee> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    TrainingCenterEmployee center = new TrainingCenterEmployee();
    center.setName(prompt.inputString("이름? "));
    center.setAge(prompt.inputString("나이? "));
    center.setLocation(prompt.inputString("주소?"));
    center.setRank(prompt.inputString("직급?"));
    center.setDepartment(prompt.inputString("부서?"));

    center.setPassword(prompt.inputString("비밀번호? "));

    this.list.add(center);
  }
}
