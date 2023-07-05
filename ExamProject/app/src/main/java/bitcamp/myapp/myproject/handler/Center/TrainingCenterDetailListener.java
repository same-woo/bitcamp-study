package bitcamp.myapp.myproject.handler.Center;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterDetailListener extends AbstractTrainingCenterListener {

  public TrainingCenterDetailListener(List<TrainingCenter> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int centerNo = prompt.inputInt("번호? ");

    TrainingCenter center = findBy(centerNo);
    if (center == null) {
      System.out.println("해당 번호의 수강생이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", center.getName());
    System.out.printf("나이: %s\n", center.getAge());
    System.out.printf("지역: %s\n", center.getLocation());
    System.out.printf("기간: %s\n", center.getDuration());
    System.out.printf("커리큘럼: %s\n", center.getCurriculum());
  }
}
