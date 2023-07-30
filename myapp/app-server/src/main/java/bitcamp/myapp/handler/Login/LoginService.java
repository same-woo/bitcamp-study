package bitcamp.myapp.handler.Login;

import java.io.IOException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.handler.Member.MemberActionListener;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

public class LoginService implements MemberActionListener {

  private MemberDao memberDao;

  public LoginService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {
    while (true) {
      String email = prompt.inputString("이메일? ");
      String password = prompt.inputString("암호? ");

      Member loginUser = memberDao.findByEmailAndPassword(email, password);
      if (loginUser == null) {
        prompt.println("회원 정보가 일치하지 않습니다.");
      } else {
        prompt.println(loginUser.getName() + "님, 로그인되었습니다.");
        prompt.setAttribute("loginUser", loginUser);
        break;
      }
      prompt.end();
    }
  }
}
