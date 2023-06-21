package bitcamp.myapp.project.handler;

import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class FooterListener implements ActionListener {

  @Override
  public void service(BreadcrumbPrompt prompt) {
    System.out.printf("Copyright by 네클 7기---------------------");
  }
}
