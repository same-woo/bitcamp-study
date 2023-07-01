package bitcamp.myapp.myproject.handler;

import java.util.List;
import bitcamp.myapp.myproject.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

public class MemberDetailListener extends AbstractMemberLinstener {

  public MemberDetailListener(List<Member> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int memberNo = prompt.inputInt("번호? ");

    Member m = this.findBy(memberNo);
    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", m.getName());
    System.out.printf("이메일: %s\n", m.getEmail());
    System.out.printf("성별: %s\n", toGenderString(m.getGender()));
  }

  private static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }


}
