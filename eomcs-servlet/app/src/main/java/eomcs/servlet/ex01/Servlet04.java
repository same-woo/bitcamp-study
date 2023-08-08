// 필터나 리스너를 테스트하기 위한 서블릿
package eomcs.servlet.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01/s4")
public class Servlet04 extends HttpServlet {
  private static final long serialVersionUID = 1L;


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("get");

    resp.setContentType("text/plane;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    System.out.println("get요청받았다!");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("post");

    resp.setContentType("text/plane;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    System.out.println("post요청받았다!");
  }

}
