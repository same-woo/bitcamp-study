package bitcamp.myapp.myproject.handler.Center;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.BreadcrumbPrompt;


public class TrainingCenterUpdateListener extends AbstractTrainingCenterListener {

  private String temp = "";

  public TrainingCenterUpdateListener(List<TrainingCenter> list) {

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

    System.out.println("어떤 정보를 바꾸시겠습니까 ?");
    System.out.println("(0) 전체변경");
    System.out.println("(1) 이름 변경");
    System.out.println("(2) 나이 변경");
    System.out.println("(3) 지역 변경");
    System.out.println("(4) 기간 변경");
    System.out.println("(5) 커리큘럼 변경");

    int changeNo = prompt.inputInt("번호? ");
    switch (changeNo) {
      case 1:
        temp = center.getName();
        center.setName(prompt.inputString("이름(%s)? ", center.getName()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, center.getName());
        break;
      case 2:
        temp = Integer.toString((center.getAge()));
        center.setAge(prompt.inputInt("나이(%d)? ", center.getAge()));
        System.out.printf("기존 : (%s) -> (%d). 변경완료\n", temp, center.getAge());
        break;
      case 3:
        temp = center.getLocation();
        center.setLocation(prompt.inputString("지역(%s)? ", center.getLocation()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, center.getLocation());
        break;
      case 4:
        temp = Integer.toString((center.getDuration()));
        center.setDuration(prompt.inputInt("기간(%s)? ", center.getDuration()));
        System.out.printf("기존 : (%s) -> (%d). 변경완료\n", temp, center.getDuration());
        break;
      case 5:
        temp = center.getCurriculum();
        center.setCurriculum(prompt.inputString("커리큘럼(%s)? ", center.getCurriculum()));
        System.out.printf("기존 : (%s) -> (%s). 변경완료\n", temp, center.getCurriculum());
        break;
      case 0:
        System.out.println("전체 내용을 변경합니다.");
        center.setName(prompt.inputString("이름(%s)? ", center.getName()));
        center.setAge(prompt.inputInt("나이(%s)? ", center.getAge()));
        center.setLocation(prompt.inputString("지역(%s)? ", center.getLocation()));
        center.setDuration(prompt.inputInt("기간(%s" + "개월)?", center.getDuration()));
        center.setCurriculum(prompt.inputString("커리큘럼(%s)? ", center.getCurriculum()));
        break;
      default:
        break;
    }
  }

}
