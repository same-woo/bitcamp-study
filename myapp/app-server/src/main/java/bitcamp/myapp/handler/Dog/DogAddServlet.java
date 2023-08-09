package bitcamp.myapp.handler.Dog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.Member;
import bitcamp.myapp.vo.MyDog;

@WebServlet("/dog/add")
public class DogAddServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
	

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.html");
      return;
    }
	  
    MyDog myDog = new MyDog();
    myDog.setKind(request.getParameter("kind"));
    myDog.setAge(Integer.parseInt(request.getParameter("age")));
    myDog.setWeight(Double.parseDouble(request.getParameter("weight")));
    myDog.setGender(request.getParameter("gender").charAt(0));
    myDog.setLocation(request.getParameter("location"));
    myDog.setId(Double.parseDouble(request.getParameter("id")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/dog/list'>");
    out.println("<title>보호동물</title>");
    out.println("<link rel='icon' href='/favicon.ico' type='image/x-icon'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호동물 등록</h1>");

    try {
    	InitServlet.dogDao.insert(myDog);
    	InitServlet.sqlSessionFactory.openSession(false).commit();
      out.println("<p>등록 성공입니다!</p>");
    } catch (Exception e) {
    	InitServlet.sqlSessionFactory.openSession(false).rollback();
      out.println("<p>등록 실패입니다!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
