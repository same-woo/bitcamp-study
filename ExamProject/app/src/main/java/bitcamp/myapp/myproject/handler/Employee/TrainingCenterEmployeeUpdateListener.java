package bitcamp.myapp.myproject.handler.Employee;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeUpdateListener extends AbstractTrainingCenterEmployeeListener {

  private String temp = "";

  public TrainingCenterEmployeeUpdateListener(List<TrainingCenterEmployee> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int centerNo = prompt.inputInt("번호? ");

    TrainingCenterEmployee employee = findBy(centerNo);
    if (employee == null) {
      System.out.println("해당 번호의 직원이 없습니다!");
      return;
    }

    System.out.println("어떤 정보를 변경하시겠습니까?");
    System.out.println("(0) 전체 변경");
    System.out.println("(1) 이름 변경");
    System.out.println("(2) 나이 변경");
    System.out.println("(3) 주소 변경");
    System.out.println("(4) 직급 변경");
    System.out.println("(5) 부서 변경");

    int changeNo = prompt.inputInt("번호? ");
    switch (changeNo) {
      case 1:
        temp = employee.getName();
        employee.setName(prompt.inputString("이름(%s)? ", employee.getName()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, employee.getName());
        break;
      case 2:
        temp = Integer.toString(employee.getAge());
        employee.setAge(prompt.inputInt("나이(%d)? ", employee.getAge()));
        System.out.printf("기존 : (%s) -> (%d). 변경완료\n", temp, employee.getAge());
        break;
      case 3:
        temp = employee.getLocation();
        employee.setLocation(prompt.inputString("주소(%s)? ", employee.getLocation()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, employee.getLocation());
        break;
      case 4:
        temp = employee.getRank();
        employee.setRank(prompt.inputString("직급(%s)? ", employee.getRank()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, employee.getRank());
        break;
      case 5:
        temp = employee.getDepartment();
        employee.setDepartment(prompt.inputString("부서(%s)? ", employee.getDepartment()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, employee.getDepartment());
        break;
      case 0:
        employee.setName(prompt.inputString("이름(%s)? ", employee.getName()));
        employee.setAge(prompt.inputInt("나이(%d)? ", employee.getAge()));
        employee.setLocation(prompt.inputString("주소(%s)? ", employee.getLocation()));
        employee.setRank(prompt.inputString("직급(%s)? ", employee.getRank()));
        employee.setDepartment(prompt.inputString("부서(%s)? ", employee.getDepartment()));
        employee.setPassword(prompt.inputString("비밀번호(%s)? ", employee.getPassword()));
        break;
      default:
        System.out.println("잘못된 번호입니다.");
        break;
    }
  }
}
