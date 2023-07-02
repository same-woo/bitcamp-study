package bitcamp.myapp.myproject.handler.Center;

import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterListListener extends AbstractTrainingCenterListener {

  public TrainingCenterListListener(List<TrainingCenter> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 지역, 기간, 커리큘럼");
    System.out.println("---------------------------------------");

    // Get an iterator to retrieve data from the list.
    Iterator<TrainingCenter> iterator = list.iterator();
    while (iterator.hasNext()) {
      TrainingCenter center = iterator.next();
      System.out.printf("%d,%s,%d,%s,%d" + "개월" + ",%s\n", center.getId(), center.getName(),
          center.getAge(), center.getLocation(), center.getDuration(), center.getCurriculum());
    }
  }
}
