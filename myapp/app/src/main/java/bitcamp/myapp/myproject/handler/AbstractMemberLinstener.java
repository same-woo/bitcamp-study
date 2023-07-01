package bitcamp.myapp.myproject.handler;

import java.util.List;
import bitcamp.util.ActionListener;
import bitcamp.myproject.
public abstract class AbstractMemberLinstener implements ActionListener {

  protected List<Member> list;

  public AbstractMemberLinstener(List<Member> list) {
    this.list = list;
  }

  protected Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }



}
