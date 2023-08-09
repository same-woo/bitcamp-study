package bitcamp.myapp.handler.Dog;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.MyDog;

@WebServlet("/dog/detail")
public class DogDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyDog myDog = InitServlet.dogDao.findBy(Integer.parseInt(request.getParameter("no"))); // Assuming "no" is the parameter for the dog's number

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

    if (myDog == null) {
      out.println("<p>해당 번호의 동물이 없습니다!</p>");

    } else {
    
    
    out.println("<form action='/dog/update' method='post'>");
    out.println("<table border='1'>");
    out.printf("<tr><th style='width:120px;'>번호</th>"
        + " <td style='width:300px;'><input type='text' name='dog_no' value='%d' readonly></td></tr>\n", myDog.getDog_no());
    out.printf("<tr><th>종류</th>"
        + " <td><input type='text' name='kind' value='%s'></td></tr>\n", myDog.getKind());
    out.printf("<tr><th>나이</th>"
        + " <td><input type='number' name='age' value='%d'></td></tr>\n", myDog.getAge());
    out.println("<tr><th>성별</th>"
        + " <td><select name='gender'>"
        + " <option value='M' " + (myDog.getGender() == 'M' ? "selected" : "") + ">수컷</option>"
        + " <option value='F' " + (myDog.getGender() == 'F' ? "selected" : "") + ">암컷</option></select></td></tr>");
    out.printf("<tr><th>무게</th>"
        + " <td><input type='number' step='0.1' name='weight' value='%.1f'></td></tr>\n", myDog.getWeight());
    out.printf("<tr><th>보호 여부</th>"
        + " <td><input type='checkbox' name='created' %s></td></tr>\n", myDog.isCreated() ? "checked" : "");
    out.println("</table>");

    out.println("<div>");
    out.println("<button>변경</button>");
    out.println("<button type='reset'>초기화</button>");
    out.printf("<a href='/dog/delete?no=%d'>삭제</a>\n", myDog.getDog_no());
    out.println("<a href='/dog/list'>목록</a>\n");
    out.println("</div>");
    out.println("</form>");
  }
    out.println("</body>");
    out.println("</html>");

  } 
}
