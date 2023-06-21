package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.vo.Member;
import bitcamp.util.ActionListener;
import bitcamp.util.List;

public abstract class AbstractMemberLinstener implements ActionListener {

  protected List list;

  public AbstractMemberLinstener(List list) {
    this.list = list;
  }

  protected Member findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Member m = (Member) this.list.get(i);
      if (m.getNo() == no) {
        return m;
      }
    }
    return null;
  }



}
