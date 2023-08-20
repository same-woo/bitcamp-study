package bitcamp.myapp.handler.ShlterAnimal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.ShelterAnimal;

@WebServlet("/animal/detail")
public class AnimalDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ShelterAnimal a = InitServlet.AnimalDao.findBy(Integer.parseInt(request.getParameter("no")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>보호동물</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호동물</h1>");

    if (a == null) {
      out.println("<p>해당 번호의 동물이 없습니다!</p>");

    } else {

    out.println("<form action='/animal/update' method='post'>");
    out.println("<table border='1'>");
    out.printf("<tr><th style='width:120px;'>번호</th>"
        + " <td style='width:300px;'><input type='text' name='shelterAnimalNo' value='%d' readonly></td></tr>\n", a.getShelterAnimalNo());
    out.printf("<tr><th>종류</th>"
        + " <td><input type='text' name='animalKindNo' value='%d'></td></tr>\n", a.getAnimalKindNo());
    out.printf("<tr><th>나이</th>"
        + " <td><input type='number' name='age' value='%d'></td></tr>\n", a.getAge());
    out.println("<tr><th>성별</th>"
        + " <td><select name='gender'>"
        + " <option value='M' " + (a.getGender() == ShelterAnimal.MALE ? "selected" : "") + ">수컷</option>"
        + " <option value='F' " + (a.getGender() == ShelterAnimal.FEMALE ? "selected" : "") + ">암컷</option></select></td></tr>");
    out.printf("<tr><th>무게</th>"
        + " < td><input type='number' step='0.1' name='weight' value='%.1f'></td></tr>\n", a.getWeight());
    out.printf("<tr><th>보호 여부</th>"
        + " <td><input type='checkbox' name='protection' %s></td></tr>\n", a.getProtection() == ShelterAnimal.PROTECTION_YES ? "checked" : "");
    out.println("</table>");

    out.println("<div>");
    out.println("<button>변경</button>");
    out.println("<button type='reset'>초기화</button>");
    out.printf("<a href='/animal/delete?no=%d'>삭제</a>\n", a.getShelterAnimalNo());
    out.println("<a href='/animal/list'>목록</a>\n");
    out.println("</div>");
    out.println("</form>");
  }
    out.println("</body>");
    out.println("</html>");

  } 
}
