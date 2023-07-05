package bitcamp.myapp.myproject.handler.Center;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterDeleteListener extends AbstractTrainingCenterListener {

  public TrainingCenterDeleteListener(List<TrainingCenter> list) {
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
    System.out.println(centerNo + "번의 수강생 정보를 삭제했습니다");
    this.list.remove(center);
  }
}
