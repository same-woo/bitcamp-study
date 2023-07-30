package bitcamp.myapp.handler.Dog;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.myapp.dao.DogDao; // MemberDao 대신 MyDogDao를 사용하도록 import문 변경
import bitcamp.myapp.vo.MyDog; // Member 대신 MyDog를 사용하도록 import문 변경
import bitcamp.util.BreadcrumbPrompt;

public class DogAddListener implements DogActionListener { // MemberAddListener 대신 DogAddListener로 이름 변경

  SqlSessionFactory sqlSessionFactory;
  DogDao dogDao; // MemberDao 대신 MyDogDao를 사용하도록 변수 선언 변경

  public DogAddListener(DogDao dogDao, SqlSessionFactory sqlSessionFactory) { // MemberAddListener 대신 DogAddListener로 이름 변경
    this.dogDao = dogDao; // MemberDao 대신 MyDogDao를 사용하도록 변수 초기화 변경
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {

    MyDog myDog = new MyDog(); // Member 대신 MyDog를 사용하도록 객체 생성 변경

    // 추가 정보들을 MyDog 객체에 포함시키기
    myDog.setKind(prompt.inputString("종류? "));
    myDog.setAge(Integer.parseInt(prompt.inputString("나이? ")));
    myDog.setWeight(Double.parseDouble(prompt.inputString("체중? ")));
    myDog.setGender(DogActionListener.inputGender((char) 0, prompt));
    myDog.setLocation(prompt.inputString("위치? "));
    myDog.setId(Double.parseDouble(prompt.inputString("ID? ")));

    try {
      dogDao.insert(myDog); // MemberDao 대신 MyDogDao를 사용하도록 메서드 호출 변경
      sqlSessionFactory.openSession(false).commit();

      prompt.println("보호동물이 리스트에 추가되었습니다."); // 출력 문구 변경

    } catch (Exception e) {
      try {
        sqlSessionFactory.openSession(false).rollback();
      } catch (Exception e2) {
      }
      throw new RuntimeException(e);
    }
  }
}
