package bitcamp.myapp.myproject.handler;

import java.util.List;
import bitcamp.myapp.myproject.vo.Board;
import bitcamp.util.ActionListener;

public abstract class AbstractBoardLinstener implements ActionListener {

  protected List<Board> list;

  public AbstractBoardLinstener(List<Board> list) {
    this.list = list;
  }

  protected Board findBy(int no) {
    for (int i = 0; i < this.list.size(); i++) {
      Board b = this.list.get(i);
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }



}
