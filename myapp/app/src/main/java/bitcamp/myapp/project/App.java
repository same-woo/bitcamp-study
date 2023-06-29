package bitcamp.myapp.project;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import bitcamp.io.DataInputStream;
import bitcamp.io.DataOutputStream;
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
    loadMember();
    loadBoard("board.data", boardList);
    loadBoard("reading.data", readingList);
  }

  private void saveData() {
    saveMember();
    saveBoard("board.data", boardList);
    saveBoard("reading.data", readingList);
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

  private void loadMember() {
    try {
      FileInputStream in0 = new FileInputStream("member.data");
      DataInputStream in = new DataInputStream(in0);
      System.out.println("member.data 파일 정보 읽기 성공 !");

      int size = in.readShort(); // 8비트 이동 후 number에 저장


      for (int i = 0; i < size; i++) {
        Member member = new Member();
        member.setNo(in.readInt());
        member.setName(in.readUTF());
        member.setEmail(in.readUTF());
        member.setPassword(in.readUTF());
        member.setGender(in.readChar());
        memberList.add(member);
      }
      // 데이터를 로딩한 이후에 추가 할 회원의 번호를 설정한다.
      Member.userId = memberList.get(memberList.size() - 1).getNo() + 1;

      in.close();
    } catch (Exception e) {
      System.out.println("member.data 파일 정보를 읽는 중 오류 발생 !");
    }
  }

  private void loadBoard(String filename, List<Board> list) {
    try {

      FileInputStream in0 = new FileInputStream(filename);
      DataInputStream in = new DataInputStream(in0);
      System.out.println(filename + " 파일 정보 읽기 성공 !");

      int size = in.readShort(); // 8비트 이동 후 number에 저장


      for (int i = 0; i < size; i++) {
        Board board = new Board();
        board.setNo(in.readInt());
        board.setTitle(in.readUTF());
        board.setContent(in.readUTF());
        board.setWriter(in.readUTF());
        board.setPassword(in.readUTF());
        board.setViewCount(in.readInt());
        board.setCreatedDate(in.readLong());
        list.add(board);
      }


      Board.boardNo = Math.max(Board.boardNo, list.get(list.size() - 1).getNo() + 1);



      in.close();
    } catch (

    Exception e) {
      System.out.println(filename + " 파일 정보를 읽는 중 오류 발생 !");
    }
  }


  private void saveMember() {
    try {

      FileOutputStream out0 = new FileOutputStream("member.data");
      DataOutputStream out = new DataOutputStream(out0);

      // 출력할 데이터의 개수를 먼저 출력한다.
      out.writeShort(memberList.size());

      for (Member member : memberList) {
        out.writeInt(member.getNo());
        out.writeUTF(member.getName());
        out.writeUTF(member.getEmail());
        out.writeUTF(member.getPassword());
        out.writeChar(member.getGender());

      }
      System.out.println("member.data 파일 정보 저장 완료");
      out.close();

    } catch (Exception e) {
      System.out.println("member.data 파일 정보를 저장하는 중 오류 발생!");
    }
  }



  private void saveBoard(String filename, List<Board> list) {
    try {
      FileOutputStream out0 = new FileOutputStream(filename);
      BufferedOutputStream out1 = new BufferedOutputStream(out0); // <= Decorator(장식품) 역할 수행!
      DataOutputStream out = new DataOutputStream(out1); // <= Decorator(장식품) 역할 수행!


      // 출력할 데이터의 개수를 먼저 출력한다.
      out.writeShort(list.size());

      for (Board board : list) {
        out.writeInt(board.getNo());
        out.writeUTF(board.getTitle());
        out.writeUTF(board.getContent());
        out.writeUTF(board.getWriter());
        out.writeUTF(board.getPassword());
        out.writeInt(board.getViewCount());
        out.writeLong(board.getCreatedDate());

      }
      System.out.println(filename + " 파일 정보 저장 완료");
      out.close();

    } catch (Exception e) {
      System.out.println(filename + " 파일 정보를 저장하는 중 오류 발생!");
    }
  }



}
