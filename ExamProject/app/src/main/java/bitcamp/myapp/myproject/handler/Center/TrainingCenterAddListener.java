package bitcamp.myapp.myproject.handler.Center;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterAddListener extends AbstractTrainingCenterListener {

  public TrainingCenterAddListener(List<TrainingCenter> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    TrainingCenter center = new TrainingCenter();
    // center.setId(TrainingCenter.centerId++);
    center.setName(prompt.inputString("이름? "));
    center.setAge(prompt.inputInt("나이? "));
    center.setLocation(prompt.inputString("주소? "));
    center.setDuration(prompt.inputInt("기간(개월)? "));
    center.setCurriculum(prompt.inputString("커리큘럼? "));
    center.setPassword(prompt.inputString("비밀번호? "));

    this.list.add(center);
  }
}
