package bitcamp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {

  Connection con;
  int category;

  public MySQLBoardDao(Connection con, int categoryNumber) {
    this.con = con;
    this.category = categoryNumber;
  }

  public void setinit(Board board) {
    board.setCategory(category);
  }

  @Override
  public void insert(Board board) {
    try (Statement stmt = con.createStatement()) {

      stmt.executeUpdate(String.format(
          "INSERT INTO myapp_board(title, content, writer, password, category) VALUES ('%s', '%s', '%s', '%s', '%d')",
          board.getTitle(), board.getContent(), board.getWriter(), board.getPassword(),
          board.getCategory()));

    } catch (Exception e) {
      // e.printStackTrace();

      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Board> list() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, content, writer, password, view_count, created_date, category from myapp_board order by title asc")) {

      List<Board> list = new LinkedList<>();


      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setPassword(rs.getString("password"));
        board.setViewCount(rs.getInt("view_count"));
        board.setCreatedDate(rs.getDate("created_date"));
        board.setCategory(rs.getInt("category"));

        list.add(board);
      }
      return list;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Board findBy(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_no, title, content, writer, view_count, created_date,category from myapp_board where board_no="
                + no)) {

      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setViewCount(rs.getInt("view_count"));
        board.setCreatedDate(rs.getDate("created_date"));
        board.setCategory(rs.getInt("category"));
        return board;
      }

      return null;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public int update(Board board) {
    try (Statement stmt = con.createStatement()) {
      return stmt.executeUpdate(String.format(
          "update myapp_board set" + " title='%s'," + " content='%s'," + " writer='%s',"
              + " view_count=%d" + ", category=%d" + " where board_no=%d",
          board.getTitle(), board.getContent(), board.getWriter(), board.getViewCount(),
          board.getCategory(), board.getNo()));


    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (Statement stmt = con.createStatement()) {

      return stmt.executeUpdate(String.format("delete from myapp_board where board_no=%d", no));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
