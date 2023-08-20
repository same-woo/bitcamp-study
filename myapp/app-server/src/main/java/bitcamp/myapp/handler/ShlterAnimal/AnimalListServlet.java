package bitcamp.myapp.handler.ShlterAnimal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.myapp.handler.Init.InitServlet;
import bitcamp.myapp.vo.ShelterAnimal;

@WebServlet("/animal/list")
public class AnimalListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // HTML 응답의 문자셋을 UTF-8로 설정
	  response.setContentType("text/html;charset=UTF-8");
	  PrintWriter out = response.getWriter();
	  
	  // HTML 시작
	  out.println("<!DOCTYPE html>");
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<meta charset='UTF-8'>");
	  out.println("<title>보호동물 리스트</title>");
	  
	  // CSS 스타일링 파일 추가
	  out.println("<link rel='stylesheet' type='text/css' href='dog-styles.css'>");
	  out.println("</head>");
	  out.println("<body>");
	  
	  // 제목과 버튼 등 추가
	  out.println("<h1 class='form-title' style='text-align:center;'>보호동물 목록</h1>");
	  out.println("<div class='container'>");
	  out.println("<a href='/dog/form.html' class='button'>새 동물 등록</a>");
	  out.println("<a href='/' class='button'>메인</a>");
	  
	  // 동물 목록을 표시하는 테이블 시작
	  out.println("<table class='table'>");
	  out.println("<thead>");
	  out.println("  <tr><th>번호</th> <th>품종</th> <th>나이</th> <th>성별</th> <th>체중</th> <th>보호여부</th></tr>");
	  out.println("</thead>");
	  out.println("<tbody>");

      // InitServlet에서 가져온 동물 목록을 반복하면서 테이블 행 추가
      List<ShelterAnimal> list = InitServlet.AnimalDao.findAll();
      for (ShelterAnimal animal : list) {
          out.printf("<tr>"
                  + "<td><a href='/dog/detail?no=%d'>%d</a></td>"
                  + "<td>%s</td>"
                  + "<td>%d</td>"
                  + "<td>%s</td>"
                  + "<td>%.1f</td>"
                  + "<td>%s</td>"
                  + "</tr>\n",
                  animal.getShelterAnimalNo(), // 변경된 동물 번호
                  animal.getShelterAnimalNo(), // 변경된 동물 번호
                  animal.getAnimalKindNo(),    // 변경된 동물 종류 번호
                  animal.getAge(),
                  animal.getGender(),
                  animal.getWeight(),
                  animal.getProtection());
        }
      
      // HTML 마무리
      out.println("</tbody>");
      out.println("</table>");
      out.println("</div>");
      out.println("</body>");
      out.println("</html>");
  }
}
