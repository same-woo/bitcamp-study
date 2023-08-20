package bitcamp.myapp.handler.ShlterAnimal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.Member;
import bitcamp.myapp.vo.ShelterAnimal;

@WebServlet("/animal/update")
public class AnimalUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      response.sendRedirect("/auth/form.html");
      return;
    }
    
    ShelterAnimal animal = new ShelterAnimal();
    animal.setShelterAnimalNo(Integer.parseInt(request.getParameter("dog_no"))); // Assuming "dog_no" is the parameter for the animal's number
    animal.setAnimalKindNo(Integer.parseInt(request.getParameter("kind")));
    animal.setAge(Integer.parseInt(request.getParameter("age")));
    animal.setWeight(Double.parseDouble(request.getParameter("weight")));
    animal.setGender(request.getParameter("gender").charAt(0));
    animal.setShelterNo(Integer.parseInt(request.getParameter("location")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/animal/list'>"); // Assuming you have an "/animal/list" URL for the animal list
    out.println("<title>보호동물</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호동물 변경</h1>");

    try {
      if (InitServlet.AnimalDao.update(animal) == 0) {
        out.println("<p>보호동물이 없습니다.</p>");
      } else {
        out.println("<p>변경했습니다!</p>");
      }
    } catch (Exception e) {
      out.println("<p>변경 실패입니다!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }

}
