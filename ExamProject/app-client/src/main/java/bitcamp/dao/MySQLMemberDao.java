package bitcamp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;

public class MySQLMemberDao implements MemberDao {

  Connection con;

  public MySQLMemberDao(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Member member) {
    try (Statement stmt = con.createStatement()) {
      stmt.executeUpdate(String.format(
          "INSERT INTO myapp_member (name, email, password, gender) VALUES ('%s', '%s', '%s', '%s')",
          member.getName(), member.getEmail(), member.getPassword(), member.getGender()));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Member> list() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT member_no, name, email, gender FROM myapp_member ORDER BY name ASC")) {

      List<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member m = new Member();
        m.setNo(rs.getInt("member_no"));
        m.setName(rs.getString("name"));
        m.setEmail(rs.getString("email"));
        m.setGender(rs.getString("gender").charAt(0));

        list.add(m);
      }

      return list;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Member findBy(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT member_no, name, email, gender FROM myapp_member WHERE member_no = " + no)) {

      if (rs.next()) {
        Member m = new Member();
        m.setNo(rs.getInt("member_no"));
        m.setName(rs.getString("name"));
        m.setEmail(rs.getString("email"));
        m.setGender(rs.getString("gender").charAt(0));

        return m;
      } else {
        return null; // No member found with the given no
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  @Override
  public int update(Member member) {
    try (Statement stmt = con.createStatement()) {

      return stmt.executeUpdate(String.format(
          "UPDATE myapp_member set name ='%s', email=, password='%s', gender='%c' where member_no = %d",
          member.getName(), member.getEmail(), member.getPassword(), member.getGender(),
          member.getNo()));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (Statement stmt = con.createStatement()) {

      return stmt.executeUpdate(String.format("DELETE from myapp_member where member_no = %d", no));

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
