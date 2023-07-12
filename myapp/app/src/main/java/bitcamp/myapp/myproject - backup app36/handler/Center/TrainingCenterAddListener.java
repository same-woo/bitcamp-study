package bitcamp.myapp.myproject.handler.Center;

import bitcamp.myapp.myproject.dao.CenterDao;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterAddListener implements ActionListener {

  CenterDao centerDao;

  public TrainingCenterAddListener(CenterDao centerDao) {
    this.centerDao = centerDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    TrainingCenter center = new TrainingCenter();
    center.setName(prompt.inputString("이름? "));
    center.setAge(prompt.inputInt("나이? "));
    center.setLocation(prompt.inputString("주소? "));
    center.setDuration(prompt.inputInt("기간(개월)? "));
    center.setCurriculum(prompt.inputString("커리큘럼? "));
    center.setPassword(prompt.inputString("비밀번호? "));

    this.centerDao.insert(center);
  }
}
