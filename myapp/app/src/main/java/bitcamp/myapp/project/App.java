package bitcamp.myapp.project;

import java.util.ArrayList;
import java.util.LinkedList;
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

  public static void main(String[] args) {

    ArrayList<Member> memberList = new ArrayList<>();
    LinkedList<Board> boardList = new LinkedList<>();
    LinkedList<Board> readingList = new LinkedList<>();

    BreadcrumbPrompt prompt = new BreadcrumbPrompt();

    MenuGroup mainMenu = new MenuGroup("메인");

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

    printTitle();

    mainMenu.execute(prompt);

    prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("----------------------------------");
  }
}
