package bitcamp.myapp.myproject;

import bitcamp.myapp.myproject.dao.BoardDao;
import bitcamp.myapp.myproject.dao.BoardListDao;
import bitcamp.myapp.myproject.dao.CenterDao;
import bitcamp.myapp.myproject.dao.CenterListDao;
import bitcamp.myapp.myproject.dao.EmployeeDao;
import bitcamp.myapp.myproject.dao.EmployeeListDao;
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
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  CenterDao centerDao;
  EmployeeDao employeeDao;
  BoardDao boardDao;
  BoardDao noticeDao;

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();
  MenuGroup mainMenu = new MenuGroup("메인");

  public static void main(String[] args) {
    new App().execute();
  }

  public App() {
    initializeData(prompt);
    prepareMenu();
  }

  static void printTitle() {
    System.out.println("");
    System.out.println("🏢국비학원 인사 관리 시스템 v1.1.1🏢");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();
    mainMenu.execute(prompt);
    prompt.close();
  }

  private void prepareMenu() {
    this.mainMenu = new MenuGroup("메인");
    MenuGroup trainingCenterMenu = new MenuGroup("🧑‍💻수강생 관리");
    trainingCenterMenu.add(new Menu("등록", new TrainingCenterAddListener(centerDao))); // Add
    trainingCenterMenu.add(new Menu("목록", new TrainingCenterListListener(centerDao))); // Add
    trainingCenterMenu.add(new Menu("조회", new TrainingCenterDetailListener(centerDao))); // Add
    trainingCenterMenu.add(new Menu("변경", new TrainingCenterUpdateListener(centerDao))); // Add
    trainingCenterMenu.add(new Menu("삭제", new TrainingCenterDeleteListener(centerDao))); // Add
    mainMenu.add(trainingCenterMenu); // Add this line

    MenuGroup trainingCenterMenuEmployee = new MenuGroup("🧑‍💼직원 관리");
    trainingCenterMenuEmployee
        .add(new Menu("등록", new TrainingCenterEmployeeAddListener(employeeDao)));
    trainingCenterMenuEmployee
        .add(new Menu("목록", new TrainingCenterEmployeeListListener(employeeDao)));
    trainingCenterMenuEmployee
        .add(new Menu("조회", new TrainingCenterEmployeeDetailListener(employeeDao)));
    trainingCenterMenuEmployee
        .add(new Menu("변경", new TrainingCenterEmployeeUpdateListener(employeeDao)));
    trainingCenterMenuEmployee
        .add(new Menu("삭제", new TrainingCenterEmployeeDeleteListener(employeeDao)));
    mainMenu.add(trainingCenterMenuEmployee); // Add this line

    MenuGroup trainingCenterboardMenu = new MenuGroup("📅게시판 관리");
    trainingCenterboardMenu.add(new Menu("등록", new TrainingCenterBoardAddListener(boardDao)));
    trainingCenterboardMenu.add(new Menu("목록", new TrainingCenterBoardListListener(boardDao)));
    trainingCenterboardMenu.add(new Menu("조회", new TrainingCenterBoardDetailListener(boardDao)));
    trainingCenterboardMenu.add(new Menu("변경", new TrainingCenterBoardUpdateListener(boardDao)));
    trainingCenterboardMenu.add(new Menu("삭제", new TrainingCenterBoardDeleteListener(boardDao)));
    mainMenu.add(trainingCenterboardMenu);

    MenuGroup trainingCenternoticeMenu = new MenuGroup("📑공지사항");
    trainingCenternoticeMenu.add(new Menu("등록", new TrainingCenterBoardAddListener(noticeDao)));
    trainingCenternoticeMenu.add(new Menu("목록", new TrainingCenterBoardListListener(noticeDao)));
    trainingCenternoticeMenu.add(new Menu("조회", new TrainingCenterBoardDetailListener(noticeDao)));
    trainingCenternoticeMenu.add(new Menu("변경", new TrainingCenterBoardUpdateListener(noticeDao)));
    trainingCenternoticeMenu.add(new Menu("삭제", new TrainingCenterBoardDeleteListener(noticeDao)));
    mainMenu.add(trainingCenternoticeMenu);
  }

  private void initializeData(BreadcrumbPrompt prompt) {
    String adminName = prompt.inputString("학원명을 입력하세요: ");
    // prompt.close();
    centerDao = new CenterListDao(adminName + "_center.json");
    employeeDao = new EmployeeListDao(adminName + "_employee.json");
    boardDao = new BoardListDao(adminName + "_board.json");
    noticeDao = new BoardListDao(adminName + "_notice.json");
  }
}
