package bitcamp.myapp.project;

import bitcamp.myapp.project.dao.BoardDao;
import bitcamp.myapp.project.dao.BoardListDao;
import bitcamp.myapp.project.dao.MemberDao;
import bitcamp.myapp.project.dao.MemberListDao;
import bitcamp.myapp.project.handler.BoardAddListener;
import bitcamp.myapp.project.handler.BoardDeleteListener;
import bitcamp.myapp.project.handler.BoardDetailListener;
import bitcamp.myapp.project.handler.BoardListListener;
import bitcamp.myapp.project.handler.BoardUpdateListener;
import bitcamp.myapp.project.handler.FooterListener;
import bitcamp.myapp.project.handler.HeaderListener;
import bitcamp.myapp.project.handler.HelloListener;
import bitcamp.myapp.project.handler.MemberAddListener;
import bitcamp.myapp.project.handler.MemberDeleteListener;
import bitcamp.myapp.project.handler.MemberDetailListener;
import bitcamp.myapp.project.handler.MemberListListener;
import bitcamp.myapp.project.handler.MemberUpdateListener;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  MemberDao memberDao = new MemberListDao("member.json");
  BoardDao boardDao = new BoardListDao("board.json");

  // LinkedList<Board> boardList = new LinkedList<>();
  // LinkedList<Board> readingList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu = new MenuGroup("메인");

  public App() {
    prepareMenu();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    // loadData();
    mainMenu.execute(prompt);
    // saveData();

    prompt.close();
  }

  // private void loadData() {
  // loadJson("board.json", boardList, Board.class);
  // loadJson("reading.json", readingList, Board.class);
  // }
  //
  // private void saveData() {
  // saveJson("board.json", boardList);
  // saveJson("reading.json", readingList);
  // }

  private void prepareMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberDao)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberDao)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberDao)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberDao)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberDao)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(boardDao)));
    readingMenu.add(new Menu("목록", new BoardListListener(boardDao)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(boardDao)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(boardDao)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(boardDao)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);
  }

  // private <T> void loadJson(String filename, List<T> list, Class<T> clazz) {
  // try {
  // FileReader in0 = new FileReader(filename);
  // BufferedReader in = new BufferedReader(in0); // <== Decorator 역할을 수행!
  //
  // StringBuilder strBuilder = new StringBuilder();
  // String line = null;
  //
  // while ((line = in.readLine()) != null) {
  // strBuilder.append(line);
  // }
  //
  // in.close();
  //
  // Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  // Collection<T> objects = gson.fromJson(strBuilder.toString(),
  // TypeToken.getParameterized(Collection.class, clazz).getType());
  //
  // list.addAll(objects);
  //
  // Class<?>[] interfaces = clazz.getInterfaces();
  // for (Class<?> info : interfaces) {
  // if (info == AutoIncrement.class) {
  // AutoIncrement autoIncrement = (AutoIncrement) list.get(list.size() - 1);
  // autoIncrement.updateKey();
  // break;
  // }
  // }
  //
  // } catch (Exception e) {
  // System.out.println(filename + " 파일을 읽는 중 오류 발생!");
  // }
  // }
  //
  // private void saveJson(String filename, List<?> list) {
  // try {
  // FileWriter out0 = new FileWriter(filename);
  // BufferedWriter out = new BufferedWriter(out0);
  //
  // Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").setPrettyPrinting().create();
  // out.write(gson.toJson(list));
  //
  // out.close();
  //
  // } catch (Exception e) {
  // System.out.println(filename + " 파일을 저장하는 중 오류 발생!");
  // }
  // }
}
