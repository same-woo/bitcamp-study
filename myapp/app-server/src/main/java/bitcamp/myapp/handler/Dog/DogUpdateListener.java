package bitcamp.myapp.handler.Dog;

import java.io.IOException;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.DogDao; // MemberDao 대신 DogDao를 사용하도록 import문 변경
import bitcamp.myapp.vo.MyDog; // Member 대신 MyDog를 사용하도록 import문 변경
import bitcamp.util.BreadcrumbPrompt;

public class DogUpdateListener implements DogActionListener { // MemberUpdateListener 대신 DogUpdateListener로 이름 변경

  SqlSessionFactory sqlSessionFactory;
  DogDao dogDao;

  public DogUpdateListener(DogDao dogDao, SqlSessionFactory sqlSessionFactory) { // MemberUpdateListener 대신 DogUpdateListener로 이름 변경
    this.dogDao = dogDao; // MemberDao 대신 DogDao를 사용하도록 변수 초기화 변경
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    int dogNo = prompt.inputInt("번호? ");

    MyDog dog = dogDao.findBy(dogNo);
    if (dog == null) {
      prompt.println("해당 번호의 보호동물이 없습니다!");
      return;
    }

    dog.setKind(prompt.inputString("품종(%s)? ", dog.getKind()));
    dog.setAge(prompt.inputInt("나이(%d)? ", dog.getAge()));
    dog.setGender(DogActionListener.inputGender(dog.getGender(), prompt));
    dog.setLocation(prompt.inputString("위치(%s)? ", dog.getLocation()));
    dog.setId(prompt.inputDouble("ID(%.0f)? ", dog.getId()));
    dog.setCreated(prompt.inputBoolean("보호 중(%b)? ", dog.isCreated()));

    try {
      dogDao.update(dog);
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }

}
