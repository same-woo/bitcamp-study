package bitcamp.myapp.handler.Board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.html");
      return;
    }

    int category = Integer.parseInt(request.getParameter("category"));

    Board b = new Board();
    b.setNo(Integer.parseInt(request.getParameter("no")));
    b.setWriter(loginUser);
    b.setCategory(category);

    try {
      if (InitServlet.boardDao.delete(b) == 0) {
        // 게시글 삭제 실패 시 오류 메시지 출력 및 로그인 화면으로 이동
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>게시글 삭제 오류</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>해당 번호의 게시글이 없거나 삭제 권한이 없습니다.</p>");
        out.println("<script>");
        out.println("setTimeout(function() { window.location.href = '/auth/form.html'; }, 1000);");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
      } else {
        response.sendRedirect("/board/list?category=" + category);
        InitServlet.sqlSessionFactory.openSession(false).commit();
      }

    } catch (Exception e) {
      InitServlet.sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }
}
