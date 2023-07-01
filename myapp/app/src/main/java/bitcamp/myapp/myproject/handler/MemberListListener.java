package bitcamp.myapp.myproject.handler;

import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.myproject.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

public class MemberListListener extends AbstractMemberLinstener {

  public MemberListListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    // 목록에서 데이터를 대신 꺼내주는 객체를 얻는다.
    Iterator<Member> iterator = list.iterator();
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(),
          toGenderString(m.getGender()));
    }
  }


  private static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

}
