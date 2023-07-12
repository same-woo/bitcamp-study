package bitcamp.myapp.myproject.handler.Employee;

import bitcamp.myapp.myproject.dao.EmployeeDao;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeAddListener implements ActionListener {

  EmployeeDao employeeDao;

  public TrainingCenterEmployeeAddListener(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    TrainingCenterEmployee employee = new TrainingCenterEmployee();
    employee.setName(prompt.inputString("이름? "));
    employee.setAge(prompt.inputInt("나이? "));
    employee.setLocation(prompt.inputString("주소? "));
    employee.setRank(prompt.inputString("직급? "));
    employee.setDepartment(prompt.inputString("부서? "));

    employee.setPassword(prompt.inputString("비밀번호? "));

    this.employeeDao.insert(employee);
  }
}
