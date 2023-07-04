package bitcamp.myapp.myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.myapp.myproject.vo.TrainingCenterBoard;
import bitcamp.myapp.myproject.vo.TrainingCenterEmployee;
import bitcamp.myapp.project.vo.AutoIncrement;
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
    System.out.println("🏢국비학원 인사 관리 시스템 v1.1.1🏢");
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
    String trainingCenterJson = adminName + "_TrainingCenter.json";
    String trainingCenterEmployeeJson = adminName + "_TrainingCenterEmployee.json";
    String trainingCenterBoardJson = adminName + "_TrainingCenterBoard.json";
    String trainingCenterNoticeJson = adminName + "_TrainingCenterNotice.json";

    AdminManager adminManager = new AdminManager(adminName);
    loadData(trainingCenterJson, trainingCenterEmployeeJson, trainingCenterBoardJson,
        trainingCenterNoticeJson);
  }

  private void saveAdmin() {
    String trainingCenterCsv = adminName + "_TrainingCenter.json";
    String trainingCenterEmployeeCsv = adminName + "_TrainingCenterEmployee.json";
    String trainingCenterBoardCsv = adminName + "_TrainingCenterBoard.json";
    String trainingCenterNoticeCsv = adminName + "_TrainingCenterNotice.json";

    saveData(trainingCenterCsv, trainingCenterEmployeeCsv, trainingCenterBoardCsv,
        trainingCenterNoticeCsv);
  }

  protected void setAdminName() {
    System.out.print("학원명을 입력하세요: ");
    adminName = prompt.inputString("");
  }

  private void loadData(String trainingCenterJson, String trainingCenterEmployeeJson,
      String trainingCenterBoardJson, String trainingCenterNoticeJson) {

    loadJson(trainingCenterJson, trainingCenterList, TrainingCenter.class);
    loadJson(trainingCenterEmployeeJson, trainingCenterEmployeeList, TrainingCenterEmployee.class);
    loadJson(trainingCenterBoardJson, trainingCenterboardList, TrainingCenterBoard.class);
    loadJson(trainingCenterNoticeJson, trainingCenternoticeList, TrainingCenterBoard.class);
  }

  private void saveData(String trainingCenterJson, String trainingCenterEmployeeJson,
      String trainingCenterBoardJson, String trainingCenterNoticeJson) {
    saveJson(trainingCenterJson, trainingCenterList);
    saveJson(trainingCenterEmployeeJson, trainingCenterEmployeeList);
    saveJson(trainingCenterBoardJson, trainingCenterboardList);
    saveJson(trainingCenterNoticeJson, trainingCenternoticeList);
  }

  private void prepareMenu() {
    this.mainMenu = new MenuGroup("메인");
    MenuGroup trainingCenterMenu = new MenuGroup("🧑‍💻수강생 관리");
    trainingCenterMenu.add(new Menu("등록", new TrainingCenterAddListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("목록", new TrainingCenterListListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("조회", new TrainingCenterDetailListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("변경", new TrainingCenterUpdateListener(trainingCenterList))); // Add
    trainingCenterMenu.add(new Menu("삭제", new TrainingCenterDeleteListener(trainingCenterList))); // Add
    mainMenu.add(trainingCenterMenu); // Add this line

    MenuGroup trainingCenterMenuEmployee = new MenuGroup("🧑‍💼직원 관리");
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

    MenuGroup trainingCenterboardMenu = new MenuGroup("📅게시판 관리");
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

    MenuGroup trainingCenternoticeMenu = new MenuGroup("📑공지사항");
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


  private <T> void loadJson(String filename, List<T> list, Class<T> clazz) {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0);

      StringBuilder strBuilder = new StringBuilder();
      String line = null;

      while ((line = in.readLine()) != null) {
        strBuilder.append(line);
      }

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
      Collection<T> objects = gson.fromJson(strBuilder.toString(),
          TypeToken.getParameterized(Collection.class, clazz).getType());

      list.addAll(objects);
      Class<?>[] interfaces = clazz.getInterfaces();
      for (Class<?> info : interfaces) {
        if (info == AutoIncrement.class) {
          AutoIncrement autoIncrement = (AutoIncrement) list.get(list.size() - 1);
          autoIncrement.updateKey();
          break;
        }
      }
      in.close();
    } catch (Exception e) {
      if (list.size() > 0) {
        System.out.println(filename + " 파일을 읽는 중 오류 발생!");
      }
    }
  }



  private void saveJson(String filename, List<?> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out = new BufferedWriter(out0);

      Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
      out.write(gson.toJson(list));

      out.close();

    } catch (

    Exception e) {
      System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
    }
  }



}
