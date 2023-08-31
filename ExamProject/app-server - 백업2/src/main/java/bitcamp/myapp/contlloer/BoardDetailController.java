package bitcamp.myapp.contlloer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
    SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");

    try {
      Board board = boardDao.findBy(Integer.parseInt(request.getParameter("category")), Integer.parseInt(request.getParameter("no")));

      if (board != null) {
        // 정상적으로 조회수 증가
        board.setViewCount(board.getViewCount() + 1);
        boardDao.updateCount(board);
        sqlSessionFactory.openSession(false).commit();
      request.setAttribute("board", board);
      }
      // 게시글이 없어도 detail.jsp 로 보낸다.
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/WEB-INF/jsp/board/detail.jsp").include(request, response);

    } catch (Exception e) {
      // 에러 출력
      sqlSessionFactory.openSession(false).rollback();
      request.setAttribute("refresh", "2;url=/board/list?category=" + request.getParameter("category"));
      throw new ServletException(e);
    }
  }
}











