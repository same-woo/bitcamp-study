package bitcamp.myapp.handler.Dog;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.myapp.dao.DogDao; // MemberDao 대신 DogDao를 사용하도록 import문 변경
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class DogDeleteListener implements ActionListener { // MemberDeleteListener 대신 DogDeleteListener로 이름 변경

  DogDao dogDao; // MemberDao 대신 DogDao를 사용하도록 변수 선언 변경
  SqlSessionFactory sqlSessionFactory;

  public DogDeleteListener(DogDao dogDao, SqlSessionFactory sqlSessionFactory) { // MemberDeleteListener 대신 DogDeleteListener로 이름 변경
    this.dogDao = dogDao; // MemberDao 대신 DogDao를 사용하도록 변수 초기화 변경
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    try {
    	System.out.println("보호동물 리스트 삭제는 권장되지 않습니다.\n");
      if (dogDao.delete(prompt.inputInt("번호? ")) == 0) { // MemberDao 대신 DogDao를 사용하도록 메서드 호출 변경
        prompt.println("해당 번호의 보호동물이 없습니다!");
      }
      prompt.println("해당 보호동물 정보를 삭제했습니다");
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }

}
