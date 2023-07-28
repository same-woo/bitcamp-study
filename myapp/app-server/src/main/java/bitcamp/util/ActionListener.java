package bitcamp.util;

import java.io.IOException;

public interface ActionListener {
  // 사용자가 메뉴를 선택할 했을 때 호출된다.
  void service(BreadcrumbPrompt prompt) throws IOException;
}
