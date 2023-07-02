package bitcamp.util;

import java.util.ArrayList;

public class MenuGroup extends Menu {

  ArrayList<Menu> childs;

  public MenuGroup(String title) {
    super(title);
    this.childs = new ArrayList<>();
  }

  public void add(Menu menu) {
    this.childs.add(menu);
  }

  @Override
  public void execute(BreadcrumbPrompt prompt) {
    prompt.appendBreadcrumb(this.getTitle());
    this.printMenu();

    while (true) {
      String input = prompt.inputMenu();
      if (input.equals("menu")) {
        this.printMenu();
        continue;
      }

      if (input.isEmpty()) {
        System.out.println("메뉴 번호가 옳지 않습니다!");
        continue;
      }

      int menuNo;
      try {
        menuNo = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력해주세요.");
        continue;
      }

      if (menuNo < 0 || menuNo > childs.size()) {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      } else if (menuNo == 0) {
        prompt.removeBreadcrumb();
        System.out.println("");
        System.out.println("종료했습니다.");
        return;
      } else {
        Menu menu = this.childs.get(menuNo - 1);
        menu.execute(prompt);
      }
    }
  }


  private void printMenu() {
    for (int i = 0; i < childs.size(); i++) {
      Menu menu = childs.get(i);
      System.out.printf("%d. %s\n", i + 1, menu.getTitle());
    }
    System.out.println("0. 이전/종료");
  }
}
