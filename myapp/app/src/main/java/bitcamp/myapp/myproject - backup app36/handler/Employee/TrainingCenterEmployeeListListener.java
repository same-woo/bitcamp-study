package bitcamp.myapp.myproject.handler.Employee;

import java.util.List;
import bitcamp.myapp.myproject.dao.EmployeeDao;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeListListener implements ActionListener {

  EmployeeDao employeeDao;

  public TrainingCenterEmployeeListListener(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 주소, 직급, 부서");
    System.out.println("---------------------------------------");

    List<TrainingCenterEmployee> list = employeeDao.list();
    for (TrainingCenterEmployee employee : list) {
      System.out.printf("%d,%s,%d,%s,%s,%s\n", employee.getId(), employee.getName(),
          employee.getAge(), employee.getLocation(), employee.getRank(), employee.getDepartment());
    }
  }
}
