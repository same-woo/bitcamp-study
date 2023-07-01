package bitcamp.myapp.myproject;

import java.util.ArrayList;
import java.util.LinkedList;
import bitcamp.myapp.myproject.handler.TrainingCenterAddListener;
/*
 * import bitcamp.myapp.myproject.handler.TrainingCenterDeleteListener; import
 * bitcamp.myapp.myproject.handler.TrainingCenterDetailListener; import
 * bitcamp.myapp.myproject.handler.TrainingCenterListListener; import
 * bitcamp.myapp.myproject.handler.TrainingCenterUpdateListener;
 */
import bitcamp.myapp.myproject.vo.TrainingCenter;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> readingList = new LinkedList<>();
  ArrayList<TrainingCenter> trainingCenterList = new ArrayList<>(); // Add this line

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu;

  public App() {
    prepareMenu();
    loadData();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  // ...

  private void loadData() {
    loadMember("my_member.csv", memberList);
    loadBoard("my_board.csv", boardList);
    loadBoard("my_reading.csv", readingList);
    loadTrainingCenter("my_trainingcenter.csv", trainingCenterList); // Add this line
  }

  private void saveData() {
    saveMember("my_member.csv", memberList);
    saveBoard("my_board.csv", boardList);
    saveBoard("my_reading.csv", readingList);
    saveTrainingCenter("my_trainingcenter.csv", trainingCenterList); // Add this line
  }

  // ...

  private void prepareMenu() {
    this.mainMenu = new MenuGroup("메인");

    MenuGroup memberMenu = new MenuGroup("회원");
    // ...

    MenuGroup boardMenu = new MenuGroup("게시글");
    // ...

    MenuGroup readingMenu = new MenuGroup("독서록");
    // ...

    MenuGroup trainingCenterMenu = new MenuGroup("국비학원");
    trainingCenterMenu.add(new Menu("등록", new TrainingCenterAddListener(trainingCenterList))); // Add
                                                                                               // this
                                                                                               // line
    trainingCenterMenu.add(new Menu("목록", new TrainingCenterListListener(trainingCenterList))); // Add
                                                                                                // this
                                                                                                // line
    trainingCenterMenu.add(new Menu("조회", new TrainingCenterDetailListener(trainingCenterList))); // Add
                                                                                                  // this
                                                                                                  // line
    trainingCenterMenu.add(new Menu("변경", new TrainingCenterUpdateListener(trainingCenterList))); // Add
                                                                                                  // this
                                                                                                  // line
    trainingCenterMenu.add(new Menu("삭제", new TrainingCenterDeleteListener(trainingCenterList))); // Add
                                                                                                  // this
                                                                                                  // line
    mainMenu.add(trainingCenterMenu); // Add this line

    // ...
  }

  // ...

  private void loadTrainingCenter(String filename, List<TrainingCenter> list) {
    // Implement the logic to load training center data from file
  }

  private void saveTrainingCenter(String filename, List<TrainingCenter> list) {
    // Implement the logic to save training center data to file
  }

  // ...
}
