package bitcamp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;

public class MySQLBoardDao implements BoardDao {

  Connection con;

  public MySQLBoardDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Board board) {
    String sql =
        "INSERT INTO myapp_board(title, content, writer, password, category) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setString(3, board.getWriter());
      pstmt.setString(4, board.getPassword());
      pstmt.setInt(5, board.getCategory());

      pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Board> list() {
    List<Board> list = new ArrayList<>();
    String sql = "SELECT * FROM myapp_board";
    try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setPassword(rs.getString("password"));
        board.setViewCount(rs.getInt("view_count"));
        board.setCreatedDate(rs.getLong("created_date"));
        board.setCategory(rs.getInt("category"));

        list.add(board);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  @Override
  public Board findBy(int no) {
    String sql = "SELECT * FROM myapp_board WHERE no=?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setInt(1, no);
      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("no"));
          board.setTitle(rs.getString("title"));
          board.setContent(rs.getString("content"));
          board.setWriter(rs.getString("writer"));
          board.setPassword(rs.getString("password"));
          board.setViewCount(rs.getInt("view_count"));
          board.setCreatedDate(rs.getLong("created_date"));
          board.setCategory(rs.getInt("category"));
          return board;
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public int update(Board board) {
    String sql =
        "UPDATE myapp_board SET title=?, content=?, writer=?, password=?, category=? WHERE no=?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setString(3, board.getWriter());
      pstmt.setString(4, board.getPassword());
      pstmt.setInt(5, board.getCategory());
      pstmt.setInt(6, board.getNo());

      return pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    String sql = "DELETE FROM myapp_board WHERE no=?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
