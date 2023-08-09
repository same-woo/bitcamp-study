package bitcamp.myapp.handler.Dog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.MyDog;

@WebServlet("/dog/list")
public class DogListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  out.println("<!DOCTYPE html>");
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<meta charset='UTF-8'>");
	  out.println("<title>보호동물 리스트</title>");
	  
	  out.println("<link rel='stylesheet' type='text/css' href='dog-styles.css'>");
	  
	  out.println("</head>");
	  out.println("<body>");
	  out.println("<h1 class='form-title' style='text-align:center;'>보호동물 목록</h1>");
	  out.println("<div class='container'>");
	    
	  // 스타일이 적용된 버튼 추가
	  out.println("<a href='/dog/form.html' class='button'>새 동물 등록</a>");
	  out.println("<a href='/' class='button'>메인</a>");
	  out.println("<table class='table'>");
	  
	  out.println("<thead>");
	  out.println("  <tr><th>번호</th> <th>품종</th> <th>나이</th> <th>성별</th> <th>체중</th> <th>보호여부</th></tr>");
	  out.println("</thead>");



      List<MyDog> list = InitServlet.dogDao.findAll();
      for (MyDog dog : list) {
          out.printf("<tr>"
                  + "<td><a href='/dog/detail?no=%d'>%d</a></td>"
                  + "<td>%s</td>"
                  + "<td>%d</td>"
                  + "<td>%s</td>"
                  + "<td>%.1f</td>"
                  + "<td>%s</td>"
                  + "</tr>\n",
                  dog.getDog_no(),
                  dog.getDog_no(),
                  dog.getKind(),
                  dog.getAge(),
                  dog.getGender(),
                  dog.getWeight(),
                  dog.isCreated());
        }
        
      out.println("</tbody>");
      out.println("</table>");
      out.println("</div>");
      out.println("</body>");
      out.println("</html>");
  }
}
