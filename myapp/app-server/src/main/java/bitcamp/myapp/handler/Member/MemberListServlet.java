package bitcamp.myapp.handler.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.Member;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>회원목록</title>");
    
    // CSS 파일 추가
    out.println("<link rel='stylesheet' type='text/css' href='member-styles.css'>");
    
    out.println("</head>");
    out.println("<body>");
    out.println("<h1 class='form-title' style='text-align:center;'>회원정보</h1>");
    out.println("<div class='container'>"); // 스타일 적용을 위해 클래스 추가
    
    out.println("<a href='/member/form.html' class='button'>새 회원</a>");
    out.println("<a href='/' class='button'>메인</a>");
    out.println("<table class='table'>");
    
    out.println("<thead>");
    out.println("  <tr><th>번호</th> <th>이름</th> <th>이메일</th></tr>");
    out.println("</thead>");

    List<Member> list = InitServlet.memberDao.findAll();
    for (Member m : list) {
      out.printf("<tr>"
          + " <td>%d</td>"
          + " <td><a href='/member/detail?no=%d'>%s</a></td>"
          + " <td>%s</td></tr>\n",
          m.getNo(), m.getNo(), m.getName(), m.getEmail());
    }

    out.println("</tbody>");
    out.println("</table>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }

}
