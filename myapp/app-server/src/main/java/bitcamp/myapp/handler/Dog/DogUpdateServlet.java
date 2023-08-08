package bitcamp.myapp.handler.Dog;

import java.io.PrintWriter;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.DogDao;
import bitcamp.myapp.vo.MyDog;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/dog/update")
public class DogUpdateServlet implements Servlet {

  DogDao dogDao;
  SqlSessionFactory sqlSessionFactory;

  public DogUpdateServlet(DogDao dogDao, SqlSessionFactory sqlSessionFactory) {
    this.dogDao = dogDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {

    MyDog dog = new MyDog();
    dog.setDog_no(Integer.parseInt(request.getParameter("dog_no")));
    dog.setKind(request.getParameter("kind"));
    dog.setAge(Integer.parseInt(request.getParameter("age")));
    dog.setWeight(Double.parseDouble(request.getParameter("weight")));
    dog.setGender(request.getParameter("gender").charAt(0));
    dog.setLocation(request.getParameter("location"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='1;url=/dog/list'>");
    out.println("<title>보호동물</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호동물 변경</h1>");

    try {
      if (dogDao.update(dog) == 0) {
        out.println("<p>해당 번호의 보호동물이 없습니다.</p>");
      } else {
        sqlSessionFactory.openSession(false).commit();
        out.println("<p>변경했습니다!</p>");
      }
    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      out.println("<p>변경 실패입니다!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }

}
