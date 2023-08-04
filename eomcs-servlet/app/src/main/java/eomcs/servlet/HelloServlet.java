package eomcs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/hello")
public class HelloServlet implements Servlet {

  ServletConfig config;

  @Override
  public void init(ServletConfig config) throws ServletException {
    // 서블릿 컨테이너(톰캣)가 인스턴스를 생성한 후 즉시 호출 함.
    System.out.println("HelloServlet.init() 호출됨");
    this.config = config;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    // 클라이언트가 요청할 때 마다 서블릿 컨테이너가 호출함.
    System.out.println("Hello! 호출");

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>환영!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Hello, world!</h1>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void destroy() {
    // 서블릿 컨테이너가 종료되기 직전에 호출함.

  }

  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return null;
  }



}
