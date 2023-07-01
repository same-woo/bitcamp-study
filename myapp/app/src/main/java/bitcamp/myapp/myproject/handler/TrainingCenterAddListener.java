package bitcamp.myapp.myproject.handler;

import java.util.List;
import bitcamp.myapp.project.vo.TrainingCenter;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterAddListener extends AbstractTrainingCenterListener {

  public TrainingCenterAddListener(List<TrainingCenter> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    TrainingCenter center = new TrainingCenter();
    center.setName(prompt.inputString("이름? "));
    center.setLocation(prompt.inputString("지역? "));
    center.setDuration(prompt.inputString("기간? "));
    center.setCurriculum(prompt.inputString("커리큘럼? "));
    center.setPassword(prompt.inputString("비밀번호? "));

    this.list.add(center);
  }
}
