package bitcamp.myapp.myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import bitcamp.myapp.myproject.handler.Admin.AdminManager;
import bitcamp.myapp.myproject.handler.Board.TrainingCenterBoardAddListener;
import bitcamp.myapp.myproject.handler.Board.TrainingCenterBoardDeleteListener;
import bitcamp.myapp.myproject.handler.Board.TrainingCenterBoardDetailListener;
import bitcamp.myapp.myproject.handler.Board.TrainingCenterBoardListListener;
import bitcamp.myapp.myproject.handler.Board.TrainingCenterBoardUpdateListener;
import bitcamp.myapp.myproject.handler.Center.TrainingCenterAddListener;
import bitcamp.myapp.myproject.handler.Center.TrainingCenterDeleteListener;
import bitcamp.myapp.myproject.handler.Center.TrainingCenterDetailListener;
import bitcamp.myapp.myproject.handler.Center.TrainingCenterListListener;
import bitcamp.myapp.myproject.handler.Center.TrainingCenterUpdateListener;
import bitcamp.myapp.myproject.handler.Employee.TrainingCenterEmployeeAddListener;
import bitcamp.myapp.myproject.handler.Employee.TrainingCenterEmployeeDeleteListener;
import bitcamp.myapp.myproject.handler.Employee.TrainingCenterEmployeeDetailListener;
import bitcamp.myapp.myproject.handler.Employee.TrainingCenterEmployeeListListener;
import bitcamp.myapp.myproject.handler.Employee.TrainingCenterEmployeeUpdateListener;
import bitcamp.myapp.myproject.vo.CsvObject;
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {
  ArrayList<TrainingCenter> trainingCenterList = new ArrayList<>();
  ArrayList<TrainingCenterEmployee> trainingCenterEmployeeList = new ArrayList<>();
  LinkedList<TrainingCenterBoard> trainingCenterboardList = new LinkedList<>();
  LinkedList<TrainingCenterBoard> trainingCenternoticeList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();
  MenuGroup mainMenu = new MenuGroup("메인");

  // 관리자 이름 변수
  private String adminName;

  public static void main(String[] args) {
    new App().execute();
  }

  public App() {
    prepareMenu();
  }

  static void printTitle() {
    System.out.println("");
    System.out.println("국비학원 인사 관리 시스템 v1.1.1");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();
    setAdminName();
    loadAdmin();
    AdminManager adminManager = new AdminManager(adminName);
    if (!adminManager.loginAdmin()) {
      System.out.println("로그인에 실패하였습니다. 프로그램을 종료합니다.");
      return;
    }
    mainMenu.execute(prompt);
    saveAdmin();
    prompt.close();
  }

  private void loadAdmin() {
    String trainingCenterCsv = adminName + "_TrainingCenter.csv";
    String trainingCenterEmployeeCsv = adminName + "_TrainingCenterEmployee.csv";
    String trainingCenterBoardCsv = adminName + "_TrainingCenterBoard.csv";
    String trainingCenterNoticeCsv = adminName + "_TrainingCenterNotice.csv";

    AdminManager adminManager = new AdminManager(adminName);
    loadData(trainingCenterCsv, trainingCenterEmployeeCsv, trainingCenterBoardCsv,
        trainingCenterNoticeCsv);
  }

  protected void setAdminName() {
    System.out.print("학원명을 입력하세요: ");
    adminName = prompt.inputString("");
  }

  private void loadData(String trainingCenterCsv, String trainingCenterEmployeeCsv,
      String trainingCenterBoardCsv, String trainingCenterNoticeCsv) {

    loadCsv(trainingCenterCsv, trainingCenterList, TrainingCenter.class);
    loadCsv(trainingCenterEmployeeCsv, trainingCenterEmployeeList, TrainingCenterEmployee.class);
    loadCsv(trainingCenterBoardCsv, trainingCenterboardList, TrainingCenterBoard.class);
    loadCsv(trainingCenterNoticeCsv, trainingCenternoticeList, TrainingCenterBoard.class);
  }

  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);
      FileReader fileReader = new FileReader(filename);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String line;

      while ((line = bufferedReader.readLine()) != null) {
        Object obj = factoryMethod.invoke(null, line);
        if (clazz.isInstance(obj)) {
          list.add(clazz.cast(obj));
        } else {
          System.out.println("잘못된 타입의 객체입니다: " + obj);
        }
      }

      bufferedReader.close();
    } catch (Exception e) {
      if (list.size() > 0) {
        System.out.println(filename + " 파일을 읽는 중 오류 발생!");
      }
    }
  }

  private void saveData(String trainingCenterCsv, String trainingCenterEmployeeCsv,
      String trainingCenterBoardCsv, String trainingCenterNoticeCsv) {
    saveCsv(trainingCenterCsv, trainingCenterList);
    saveCsv(trainingCenterEmployeeCsv, trainingCenterEmployeeList);
    saveCsv(trainingCenterBoardCsv, trainingCenterboardList);
    saveCsv(trainingCenterNoticeCsv, trainingCenternoticeList);
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter fileWriter = new FileWriter(filename);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      PrintWriter printWriter = new PrintWriter(bufferedWriter);

      for (CsvObject obj : list) {
        printWriter.println(obj.toCsvString());
      }

      printWriter.close();
      System.out.println(filename + " 파일을 성공적으로 저장했습니다.");
    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }

  private void saveAdmin() {
    String trainingCenterCsv = adminName + "_TrainingCenter.csv";
    String trainingCenterEmployeeCsv = adminName + "_TrainingCenterEmployee.csv";
    String trainingCenterBoardCsv = adminName + "_TrainingCenterBoard.csv";
    String trainingCenterNoticeCsv = adminName + "_TrainingCenterNotice.csv";

    saveData(trainingCenterCsv, trainingCenterEmployeeCsv, trainingCenterBoardCsv,
        trainingCenterNoticeCsv);
  }

  private void prepareMenu() {
    this.mainMenu = new MenuGroup("메인");
    MenuGroup trainingCenterMenu = new MenuGroup("수강생 관리");
    trainingCenterMenu.add(new Menu("등록", new TrainingCenterAddListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("목록", new TrainingCenterListListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("조회", new TrainingCenterDetailListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("변경", new TrainingCenterUpdateListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("삭제", new TrainingCenterDeleteListener(trainingCenterList))); // Add
    mainMenu.add(trainingCenterMenu); // Add this line

    MenuGroup trainingCenterMenuEmployee = new MenuGroup("직원 관리");
    trainingCenterMenuEmployee
        .add(new Menu("등록", new TrainingCenterEmployeeAddListener(trainingCenterEmployeeList))); // Add
    trainingCenterMenuEmployee
        .add(new Menu("목록", new TrainingCenterEmployeeListListener(trainingCenterEmployeeList))); // Add
    trainingCenterMenuEmployee
        .add(new Menu("조회", new TrainingCenterEmployeeDetailListener(trainingCenterEmployeeList))); // Add
    trainingCenterMenuEmployee
        .add(new Menu("변경", new TrainingCenterEmployeeUpdateListener(trainingCenterEmployeeList))); // Add
    trainingCenterMenuEmployee
        .add(new Menu("삭제", new TrainingCenterEmployeeDeleteListener(trainingCenterEmployeeList))); // Add
    mainMenu.add(trainingCenterMenuEmployee); // Add this line

    MenuGroup trainingCenterboardMenu = new MenuGroup("게시판 관리");
    trainingCenterboardMenu
        .add(new Menu("등록", new TrainingCenterBoardAddListener(trainingCenterboardList)));
    trainingCenterboardMenu
        .add(new Menu("목록", new TrainingCenterBoardListListener(trainingCenterboardList)));
    trainingCenterboardMenu
        .add(new Menu("조회", new TrainingCenterBoardDetailListener(trainingCenterboardList)));
    trainingCenterboardMenu
        .add(new Menu("변경", new TrainingCenterBoardUpdateListener(trainingCenterboardList)));
    trainingCenterboardMenu
        .add(new Menu("삭제", new TrainingCenterBoardDeleteListener(trainingCenterboardList)));
    mainMenu.add(trainingCenterboardMenu);

    MenuGroup trainingCenternoticeMenu = new MenuGroup("공지사항");
    trainingCenternoticeMenu
        .add(new Menu("등록", new TrainingCenterBoardAddListener(trainingCenternoticeList)));
    trainingCenternoticeMenu
        .add(new Menu("목록", new TrainingCenterBoardListListener(trainingCenternoticeList)));
    trainingCenternoticeMenu
        .add(new Menu("조회", new TrainingCenterBoardDetailListener(trainingCenternoticeList)));
    trainingCenternoticeMenu
        .add(new Menu("변경", new TrainingCenterBoardUpdateListener(trainingCenternoticeList)));
    trainingCenternoticeMenu
        .add(new Menu("삭제", new TrainingCenterBoardDeleteListener(trainingCenternoticeList)));
    mainMenu.add(trainingCenternoticeMenu);
  }
}
