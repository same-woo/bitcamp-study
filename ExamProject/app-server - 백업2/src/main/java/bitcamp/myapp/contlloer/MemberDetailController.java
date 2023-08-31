package bitcamp.myapp.contlloer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import org.apache.ibatis.javassist.bytecode.ExceptionTable;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/member/detail")
public class MemberDetailController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
    SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");

    try {
      request.setAttribute("member", memberDao.findBy(Integer.parseInt(request.getParameter("no"))));
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/WEB-INF/jsp/member/detail.jsp").include(request, response);

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      request.setAttribute("refresh", "2;url=/member/list?" + request.getParameter("no"));
      throw new ServletException(e);
    }

  }
}