package bitcamp.myapp.myproject.handler.Employee;

import bitcamp.myapp.myproject.dao.EmployeeDao;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeDeleteListener implements ActionListener {

  EmployeeDao employeeDao;

  public TrainingCenterEmployeeDeleteListener(EmployeeDao employeeDao) {
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
    System.out.println(centerId + "번의 직원 정보를 삭제했습니다");
    this.employeeDao.delete(centerId);
  }
}
