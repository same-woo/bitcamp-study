package bitcamp.util;

public class BreadcrumPrompt extends Prompt {

  private Stack breadcrumbs = new Stack();

  public void appendBreadcrumb(String title) {
    this.breadcrumbs.push(title);
  }

  public void removeBreadcrumb() {
    this.breadcrumbs.pop();
  }

  public String inputMenu() {
    StringBuilder titleBuilder = new StringBuilder();// 예) 메인/회원>
    for (int i = 0; i < this.breadcrumbs.size(); i++) {
      if (titleBuilder.length() > 0) {
        titleBuilder.append("/");
        // 기존에 경로가 있다면 구분해주기 위해서 "/"를 표시
      }
      titleBuilder.append(this.breadcrumbs.get(i));
    }
    titleBuilder.append("> ");
    return this.inputString(titleBuilder.toString());
  }


}
