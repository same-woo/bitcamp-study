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

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println("");
    System.out.println("국비학원 인사 관리 시스템 v1.1.1");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    loadData();
    mainMenu.execute(prompt);
    saveData();

    prompt.close();

  }

  private void loadData() {
    loadCsv("TrainingCenter.csv", trainingCenterList, TrainingCenter.class); // Add this line
    loadCsv("TrainingCenterEmployee.csv", trainingCenterEmployeeList, TrainingCenterEmployee.class); // Add
    loadCsv("TrainingCenterBoard.csv", trainingCenterboardList, TrainingCenterBoard.class);
    loadCsv("TrainingCenterNotice.csv", trainingCenternoticeList, TrainingCenterBoard.class);
  }

  private void saveData() {
    saveCsv("TrainingCenter.csv", trainingCenterList);
    saveCsv("TrainingCenterEmployee.csv", trainingCenterEmployeeList);
    saveCsv("TrainingCenterBoard.csv", trainingCenterboardList);
    saveCsv("TrainingCenterNotice.csv", trainingCenternoticeList);
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
      System.out.println(filename + " 파일을 성공적으로 로딩했습니다.");
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!

      String line = null;

      while ((line = in.readLine()) != null) {
        list.add((T) factoryMethod.invoke(null, line)); // Reflection API를 사용하여 스태틱 메서드 호출
      }

      in.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일을 읽는 중 오류 발생!");
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
