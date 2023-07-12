package bitcamp.myapp.myproject.handler.Center;

import bitcamp.myapp.myproject.dao.CenterDao;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterDeleteListener implements ActionListener {

  CenterDao centerDao;

  public TrainingCenterDeleteListener(CenterDao centerDao) {
    this.centerDao = centerDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int centerNo = prompt.inputInt("번호? ");

    TrainingCenter center = centerDao.findBy(centerNo);
    if (center == null) {
      System.out.println("해당 번호의 수강생이 없습니다!");
      return;
    }
    System.out.println(centerNo + "번의 수강생 정보를 삭제했습니다");
    this.centerDao.delete(centerNo);
  }
}
