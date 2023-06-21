package bitcamp.myapp.project.handler;

import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class HeaderListener implements ActionListener {

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.printf("----------비트캠프----------\n");
  }
}
