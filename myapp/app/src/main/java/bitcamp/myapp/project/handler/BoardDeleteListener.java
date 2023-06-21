package bitcamp.myapp.project.handler;

import bitcamp.myapp.project.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardDeleteListener implements ActionListener {

  private List list;

  public BoardDeleteListener(List list) {
    this.list = list;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    if (!this.list.remove(new Board(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }
}


