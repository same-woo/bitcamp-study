package bitcamp.myapp.myproject.handler.Board;

import java.util.List;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.util.BreadcrumbPrompt;

public class TrainingCenterBoardUpdateListener extends AbstractTrainingCenterBoardLinstener {

  public TrainingCenterBoardUpdateListener(List<TrainingCenterBoard> list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {
    int boardNo = prompt.inputInt("번호? ");

    TrainingCenterBoard board = findBy(boardNo);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    System.out.println("어떤 정보를 변경하시겠습니까?");
    System.out.println("(0) 전체변경");
    System.out.println("(1) 제목 변경");
    System.out.println("(2) 내용 변경");

    int changeNo = prompt.inputInt("번호? ");
    switch (changeNo) {
      case 1:
        board.setTitle(prompt.inputString("제목(%s)? ", board.getTitle()));
        break;
      case 2:
        board.setContent(prompt.inputString("내용(%s)? ", board.getContent()));
        break;
      case 0:
        board.setTitle(prompt.inputString("제목(%s)? ", board.getTitle()));
        board.setContent(prompt.inputString("내용(%s)? ", board.getContent()));

      default:
        break;
    }
  }
}
