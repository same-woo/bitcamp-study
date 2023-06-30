package bitcamp.myapp.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
import bitcamp.myapp.project.vo.Board;
import bitcamp.myapp.project.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  ArrayList<Member> memberList = new ArrayList<>();
  LinkedList<Board> boardList = new LinkedList<>();
  LinkedList<Board> readingList = new LinkedList<>();

  BreadcrumbPrompt prompt = new BreadcrumbPrompt();

  MenuGroup mainMenu;



  public App() {
    prepareMenu();
    loadData();
  }

  public static void main(String[] args) {
    new App().execute();
  }

  static void printTitle() {
    System.out.println("");
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }

  public void execute() {
    printTitle();

    mainMenu.execute(prompt);
    saveData();

    prompt.close();

  }

  private void loadData() {
    loadMember("member.csv", memberList);
    loadBoard("board.csv", boardList);
    loadBoard("reading.csv", readingList);
  }

  private void saveData() {
    saveMember("member.csv", memberList);
    saveBoard("board.csv", boardList);
    saveBoard("reading.csv", readingList);
  }



  private void prepareMenu() {
    this.mainMenu = new MenuGroup("메인");

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberList)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberList)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberList)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberList)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberList)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardList)));
    boardMenu.add(new Menu("목록", new BoardListListener(boardList)));
    boardMenu.add(new Menu("조회", new BoardDetailListener(boardList)));
    boardMenu.add(new Menu("변경", new BoardUpdateListener(boardList)));
    boardMenu.add(new Menu("삭제", new BoardDeleteListener(boardList)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(readingList)));
    readingMenu.add(new Menu("목록", new BoardListListener(readingList)));
    readingMenu.add(new Menu("조회", new BoardDetailListener(readingList)));
    readingMenu.add(new Menu("변경", new BoardUpdateListener(readingList)));
    readingMenu.add(new Menu("삭제", new BoardDeleteListener(readingList)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕!");
    helloMenu.addActionListener(new HeaderListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);
  }

  private void loadMember(String filename, List<Member> list) {
    try {
      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <= Decorator(장식품) 역할 수행!
      System.out.println(filename + "파일 정보 읽기 성공 !");

      String line = null;

      while ((line = in.readLine()) != null) {
        String[] values = line.split(",");
        Member member = new Member();
        member.setNo(Integer.parseInt(values[0]));
        member.setName(values[1]);
        member.setEmail(values[2]);
        member.setPassword(values[3]);
        member.setGender(values[4].charAt(0));
        list.add(member);

      }

      if (list.size() > 0) {
        Member.userId = list.get(list.size() - 1).getNo() + 1;
      }
      in.close();
    } catch (Exception e) {
      System.out.println("member.data 파일 정보를 읽는 중 오류 발생 !");
    }
  }

  private void loadBoard(String filename, List<Board> list) {
    try {

      FileReader in0 = new FileReader(filename);
      BufferedReader in = new BufferedReader(in0); // <= Decorator(장식품) 역할 수행!
      System.out.println(filename + " 파일 정보 읽기 성공 !");

      String line = null;


      while ((line = in.readLine()) != null) {
        String[] values = line.split(",");

        Board board = new Board();
        board.setNo(Integer.parseInt(values[0]));
        board.setTitle(values[1]);
        board.setContent(values[2]);
        board.setWriter(values[3]);
        board.setPassword(values[4]);
        board.setViewCount(Integer.parseInt(values[5]));
        board.setCreatedDate(Long.parseLong(values[6]));

        list.add(board);
      }

      if (list.size() > 0) {
        Board.boardNo = Math.max(Board.boardNo, list.get(list.size() - 1).getNo() + 1);
      }

      in.close();
    } catch (

    Exception e) {
      System.out.println(filename + " 파일 정보를 읽는 중 오류 발생 !");
    }
  }


  private void saveMember(String filename, List<Member> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <= Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1);

      for (Member member : list) {
        out.printf("%d,%s,%s,%s,%c\n", member.getNo(), member.getName(), member.getEmail(),
            member.getPassword(), member.getGender());


      }
      System.out.println(filename + "파일 정보 저장 완료");
      out.close();

    } catch (Exception e) {
      System.out.println(filename + "파일 정보를 저장하는 중 오류 발생!");
    }
  }



  private void saveBoard(String filename, List<Board> list) {
    try {
      FileWriter out0 = new FileWriter(filename);
      BufferedWriter out1 = new BufferedWriter(out0); // <= Decorator(장식품) 역할 수행!
      PrintWriter out = new PrintWriter(out1); // <= Decorator(장식품) 역할 수행!

      for (Board board : list) {
        out.printf("%d,%s,%s,%s,%s,%d,%d\n", board.getNo(), board.getTitle(), board.getContent(),
            board.getWriter(), board.getPassword(), board.getViewCount(), board.getCreatedDate());


      }
      System.out.println(filename + " 파일 정보 저장 완료");
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일 정보를 저장하는 중 오류 발생!");
    }
  }



}
