package bitcamp.myapp.myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
  private String adminPassword;


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
    // checkAdmin();
    mainMenu.execute(prompt);
    saveAdmin();
    prompt.close();
  }

  public void loadAdmin() {
    String trainingCenterCsv = adminName + "_TrainingCenter.csv";
    String trainingCenterEmployeeCsv = adminName + "_TrainingCenterEmployee.csv";
    String trainingCenterBoardCsv = adminName + "_TrainingCenterBoard.csv";
    String trainingCenterNoticeCsv = adminName + "_TrainingCenterNotice.csv";

    boolean isNewAdmin = !checkAdminExists();

    if (isNewAdmin) {
      System.out.println("새로운 관리자입니다. 비밀번호를 설정해주세요.");
      setAdminPassword();
    } else {
      System.out.println("기존 관리자입니다. 비밀번호를 입력하세요.");
      loginAdmin();
    }

    if (!adminPassword.isEmpty()) {
      loadData(trainingCenterCsv, trainingCenterEmployeeCsv, trainingCenterBoardCsv,
          trainingCenterNoticeCsv);
    } else {
      System.out.println("비밀번호를 입력하지 않았습니다. 프로그램을 종료합니다.");
      System.exit(0);
    }
  }

  public void setAdminName() {
    System.out.print("학원명을 입력하세요: ");
    adminName = prompt.inputString("");
  }

  public void setAdminPassword() {
    System.out.print("비밀번호를 입력하세요: ");
    adminPassword = prompt.inputString("");
  }

  public void loginAdmin() {
    System.out.print("비밀번호를 입력하세요: ");
    String enteredPassword = prompt.inputString("");

    if (enteredPassword.equals(adminPassword.trim())) {
      System.out.println("비밀번호가 일치합니다. 로그인되었습니다.");
    } else {
      System.out.println("비밀번호가 일치하지 않습니다. 프로그램을 종료합니다.");
      System.exit(0);
    }
  }



  private boolean checkAdminExists() {
    // Check if the admin's data already exists (e.g., by checking if the CSV files exist)
    // Return true if admin data exists; false otherwise
    // You can implement your own logic here to check if the admin data exists

    // For example, you can check if the CSV files exist using the File class:
    File trainingCenterCsvFile = new File(adminName + "_TrainingCenter.csv");
    File trainingCenterEmployeeCsvFile = new File(adminName + "_TrainingCenterEmployee.csv");
    File trainingCenterBoardCsvFile = new File(adminName + "_TrainingCenterBoard.csv");
    File trainingCenterNoticeCsvFile = new File(adminName + "_TrainingCenterNotice.csv");

    return trainingCenterCsvFile.exists() && trainingCenterEmployeeCsvFile.exists()
        && trainingCenterBoardCsvFile.exists() && trainingCenterNoticeCsvFile.exists();
  }



  public void saveAdmin() {
    String trainingCenterCsv = adminName + "_TrainingCenter.csv";
    String trainingCenterEmployeeCsv = adminName + "_TrainingCenterEmployee.csv";
    String trainingCenterBoardCsv = adminName + "_TrainingCenterBoard.csv";
    String trainingCenterNoticeCsv = adminName + "_TrainingCenterNotice.csv";

    saveData(trainingCenterCsv, trainingCenterEmployeeCsv, trainingCenterBoardCsv,
        trainingCenterNoticeCsv);
  }



  private void loadData(String trainingCenterCsv, String trainingCenterEmployeeCsv,
      String trainingCenterBoardCsv, String trainingCenterNoticeCsv) {
    loadCsv(trainingCenterCsv, trainingCenterList, TrainingCenter.class);
    loadCsv(trainingCenterEmployeeCsv, trainingCenterEmployeeList, TrainingCenterEmployee.class);
    loadCsv(trainingCenterBoardCsv, trainingCenterboardList, TrainingCenterBoard.class);
    loadCsv(trainingCenterNoticeCsv, trainingCenternoticeList, TrainingCenterBoard.class);


  }

  private void saveData(String trainingCenterCsv, String trainingCenterEmployeeCsv,
      String trainingCenterBoardCsv, String trainingCenterNoticeCsv) {
    saveCsv(trainingCenterCsv, trainingCenterList);
    saveCsv(trainingCenterEmployeeCsv, trainingCenterEmployeeList);
    saveCsv(trainingCenterBoardCsv, trainingCenterboardList);
    saveCsv(trainingCenterNoticeCsv, trainingCenternoticeList);
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

    // ...
  }

  @SuppressWarnings("unchecked")
  private <T extends CsvObject> void loadCsv(String filename, List<T> list, Class<T> clazz) {
    try {
      Method factoryMethod = clazz.getDeclaredMethod("fromCsv", String.class);
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T) factoryMethod.invoke(null, line)); // Reflection API를 사용하여 스태틱 메서드 호출
      }

      in.close();

    } catch (Exception e) {
      if (list.size() > 0) {
        System.out.println(filename + " 파일을 읽는 중 오류 발생!");
      }
    }
  }

  private void saveCsv(String filename, List<? extends CsvObject> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <== Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1); // <== Decorator(장식품) 역할 수행!

      for (CsvObject obj : list) {
        out.println(obj.toCsvString());
      }
      System.out.println(filename + " 파일을 성공적으로 저장했습니다.");
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }
}
