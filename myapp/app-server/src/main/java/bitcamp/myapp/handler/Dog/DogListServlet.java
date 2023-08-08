package bitcamp.myapp.handler.Dog;

import java.io.PrintWriter;
import java.util.List;

import bitcamp.myapp.dao.DogDao;
import bitcamp.myapp.vo.MyDog;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/dog/list") // Assuming you want to map this to a URL like /dog/list
public class DogListServlet implements Servlet {

  DogDao dogDao;

  public DogListServlet(DogDao dogDao) {
    this.dogDao = dogDao;
  }
  
  
@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>보호동물 리스트</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호동물 리스트</h1>");
    out.println("<table>");
    out.println("<tr>");
    out.println("<th>번호</th>");
    out.println("<th>품종</th>");
    out.println("<th>나이</th>");
    out.println("<th>성별</th>");
    out.println("<th>체중</th>");
    out.println("<th>보호여부</th>");
    out.println("</tr>");

    try {
      List<MyDog> list = dogDao.findAll();
      for (MyDog dog : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>", dog.getDog_no());
        out.printf("<td>%s</td>", dog.getKind());
        out.printf("<td>%d</td>", dog.getAge());
        out.printf("<td>%c</td>", dog.getGender());
        out.printf("<td>%.0f</td>", dog.getWeight());
        out.printf("<td>%b</td>", dog.isCreated());
        out.println("</tr>");
      }
    } catch (Exception e) {
      out.println("<tr>");
      out.println("<td colspan='6'>목록을 불러오는 중 오류가 발생했습니다.</td>");
      out.println("</tr>");
      e.printStackTrace(out);
    }

    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }
}
