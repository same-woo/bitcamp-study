package bitcamp.myapp.myproject.handler.Board;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardAddListener extends AbstractTrainingCenterBoardLinstener {


  public TrainingCenterBoardAddListener(List<TrainingCenterBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    TrainingCenterBoard board = new TrainingCenterBoard();
    // board.setNo(TrainingCenterBoard.boardNo++);
    board.setTitle(prompt.inputString("제목? "));
    board.setContent(prompt.inputString("내용? "));
    board.setWriter(prompt.inputString("작성자? "));
    board.setPassword(prompt.inputString("암호? "));
    this.list.add(board);
  }
}


