package bitcamp.myapp.myproject.handler.Employee;

import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterEmployeeListListener extends AbstractTrainingCenterEmployeeListener {

  public TrainingCenterEmployeeListListener(List<TrainingCenterEmployee> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 주소, 직급, 부서");
    System.out.println("---------------------------------------");

    // Get an iterator to retrieve data from the list.
    Iterator<TrainingCenterEmployee> iterator = list.iterator();
    while (iterator.hasNext()) {
      TrainingCenterEmployee center = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s\n", center.getId(), center.getName(), center.getAge(),
          center.getLocation(), center.getRank(), center.getDepartment());
    }
  }
}
