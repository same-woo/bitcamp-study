package bitcamp.myapp.myproject.handler.Admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import bitcamp.myapp.myproject.App;
import bitcamp.util.BreadcrumbPrompt;

public class AdminManager extends App {

  private int count = 0;
  private String adminName;
  private String adminPassword;
  private String trainingCenterPasswordCsv;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();


  public AdminManager(String adminName) {
    this.adminName = adminName;
    this.trainingCenterPasswordCsv = adminName + "_AdminPassword.csv";
  }

  private boolean isNewAdmin() {
    return !new File(trainingCenterPasswordCsv).exists();
  }

  public void setAdminPassword(String password) {
    this.adminPassword = password;
  }

  public boolean loginAdmin() {
    String storedPassword = loadAdminPassword();
    if (storedPassword == null) {
      System.out.println("새로운 관리자입니다. 비밀번호를 설정해주세요.");
      setAdminPassword(prompt.inputString("비밀번호 입력: "));
      saveAdminPassword();
      return true;
    }

    while (count < 4) {
      String enteredPassword = prompt.inputString("비밀번호 입력: ");

      if (enteredPassword.equals(storedPassword)) {
        System.out.println("비밀번호가 일치합니다. 로그인되었습니다.\n");
        return true;
      } else {
        count++;
        System.out.println("비밀번호가 일치하지 않습니다.");
        System.out.println("남은 시도 횟수: " + (4 - count));
      }
    }

    System.out.println("로그인 시도 횟수를 초과하였습니다.");
    count = 0;
    System.out.println("학원명을 다시 입력하세요.");
    setAdminName();
    return loginAdmin();
  }


  private String loadAdminPassword() {
    try (BufferedReader reader = new BufferedReader(new FileReader(trainingCenterPasswordCsv))) {
      return reader.readLine();
    } catch (Exception e) {
      return null;
    }
  }

  public void saveAdminPassword() {
    try (PrintWriter writer = new PrintWriter(trainingCenterPasswordCsv)) {
      writer.println(adminPassword);
      System.out.println("비밀번호를 성공적으로 저장했습니다.");
    } catch (Exception e) {
      System.out.println("비밀번호를 저장하는 중 오류 발생!");
    }
  }
}
