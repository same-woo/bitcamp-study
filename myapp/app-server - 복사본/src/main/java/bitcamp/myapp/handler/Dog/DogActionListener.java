package bitcamp.myapp.handler.Dog;

import java.io.IOException;

import bitcamp.myapp.vo.MyDog; // Member 대신 MyDog를 사용하도록 import문 변경
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public interface DogActionListener extends ActionListener {

  static char inputGender(char gender, BreadcrumbPrompt prompt) throws IOException {
    String label;
    if (gender == 0) {
      label = "성별?\n";
    } else {
      label = String.format("성별(%s)?\n", gender == 'M' ? "수컷" : "암컷");
    }

    while (true) {
      String menuNo = prompt.inputString(label + "  1. 수컷\n" + "  2. 암컷\n" + "> ");

      switch (menuNo) {
        case "1":
          return MyDog.MALE; // Member.MALE 대신 MyDog.MALE로 변경
        case "2":
          return MyDog.FEMALE; // Member.FEMALE 대신 MyDog.FEMALE로 변경
        default:
          prompt.println("무효한 번호입니다.");
      }
    }
  }

}
