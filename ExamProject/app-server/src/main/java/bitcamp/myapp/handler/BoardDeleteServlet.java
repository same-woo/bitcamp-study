package bitcamp.myapp.handler;

import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/board/delete")
public class BoardDeleteServlet implements Servlet {

  BoardDao boardDao;
  SqlSessionFactory sqlSessionFactory;

  public BoardDeleteServlet(BoardDao boardDao, SqlSessionFactory sqlSessionFactory) {
    this.boardDao = boardDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int category = Integer.parseInt(request.getParameter("category"));

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setWriter((Member) request.getAttribute("loginUser"));
    board.setCategory(Integer.parseInt((String) request.getAttribute("category")));
    board.setCategory(category);

    // response.setContentType("text/html;charset=UTF-8");
    // PrintWriter out = response.getWriter();
    // out.println("<!DOCTYPE html>");
    // out.println("<html>");
    // out.println("<head>");
    // out.println("<meta charset='UTF-8'>");
    // out.println("<title>게시글</title>");
    // out.println("</head>");
    // out.println("<body>");
    // out.println("<h1>게시글</h1>");


    try {
      if (boardDao.delete(board) == 0) {
        throw new Exception("해당 번호의 게시글이 없거나 삭제 권한이 없습니다.");
      } else {
        response.sendRedirect("/board/list?category=" + category);
      }
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
    // out.println("</body>");
    // out.println("</html>");
  }
}


