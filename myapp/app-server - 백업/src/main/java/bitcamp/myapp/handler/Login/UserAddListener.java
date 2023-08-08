// MemberAddListener.java
package bitcamp.myapp.handler.Login;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.handler.Member.MemberActionListener;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;

public class UserAddListener implements MemberActionListener {

    MemberDao MemberDao;
    SqlSessionFactory sqlSessionFactory;

    public UserAddListener(MemberDao MemberDao, SqlSessionFactory sqlSessionFactory) {
        this.MemberDao = MemberDao;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void service(BreadcrumbPrompt prompt) throws IOException {
        Member Member = new Member();
        Member.setEmail(prompt.inputString("이메일? "));
        Member.setPassword(prompt.inputString("암호? "));

        try {
            MemberDao.insert(Member);
            sqlSessionFactory.openSession(false).commit();
        } catch (Exception e) {
            try {
                sqlSessionFactory.openSession(false).rollback();
            } catch (Exception e2) {
            }
            throw new RuntimeException(e);
        }
    }
}
