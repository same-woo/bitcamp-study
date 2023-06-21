package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.List;

public abstract class AbstractBoardLinstener implements ActionListener {

  protected List list;

  public AbstractBoardLinstener(List list) {
    this.list = list;
  }

  protected Board findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Board b = (Board) this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }



}
