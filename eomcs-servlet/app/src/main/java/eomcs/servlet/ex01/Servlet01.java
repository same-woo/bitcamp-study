package eomcs.servlet.ex01;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex01/first")
public class Servlet01 implements Servlet {

  ServletConfig config;

  public Servlet01() {
    System.out.println("호출!");
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    this.config = config;
    System.out.println("init()!");

  }

  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }

}
