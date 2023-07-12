package bitcamp.myapp.myproject.handler.Employee;

import bitcamp.myapp.myproject.dao.EmployeeDao;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeDetailListener implements ActionListener {

  EmployeeDao employeeDao;

  public TrainingCenterEmployeeDetailListener(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int centerId = prompt.inputInt("번호? ");

    TrainingCenterEmployee employee = employeeDao.findBy(centerId);
    if (employee == null) {
      System.out.println("해당 번호의 직원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", employee.getName());
    System.out.printf("나이: %d\n", employee.getAge());
    System.out.printf("주소: %s\n", employee.getLocation());
    System.out.printf("직급: %s\n", employee.getRank());
    System.out.printf("부서: %s\n", employee.getDepartment());
  }
}
