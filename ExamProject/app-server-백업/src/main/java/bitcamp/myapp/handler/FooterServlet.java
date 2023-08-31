package bitcamp.myapp.handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/footer")
public class FooterServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<div style='text-align:center;background-color:orange;color:white;padding:5px;'>");
    out.println("<p style='font-size:90%;margin:0;'>비트캠프 + 매직에꼴 + 네이버클라우드@2023</p>");
    out.println("<address style='font-size: x-small;font-style:italic'>서울시 강남구 강남대로 94길 20, 삼오빌딩 6층</address>");
    out.println("</div>");
  }

}











