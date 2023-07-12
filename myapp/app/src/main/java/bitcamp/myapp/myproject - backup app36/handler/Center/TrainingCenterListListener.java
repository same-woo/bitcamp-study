package bitcamp.myapp.myproject.handler.Center;

import java.util.List;
import bitcamp.myapp.myproject.dao.CenterDao;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterListListener implements ActionListener {

  CenterDao centerDao;

  public TrainingCenterListListener(CenterDao centerDao) {
    this.centerDao = centerDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 나이, 지역, 기간, 커리큘럼");
    System.out.println("---------------------------------------");

    List<TrainingCenter> list = centerDao.list();
    for (TrainingCenter center : list) {
      System.out.printf("%d,%s,%d,%s,%d" + "개월" + ",%s\n", center.getId(), center.getName(),
          center.getAge(), center.getLocation(), center.getDuration(), center.getCurriculum());
    }
  }
}
