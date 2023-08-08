package bitcamp.myapp.handler.Dog;

import java.io.PrintWriter;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.DogDao;
import bitcamp.myapp.vo.MyDog;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/dog/add")
public class DogAddServlet implements Servlet {

  DogDao dogDao;
  SqlSessionFactory sqlSessionFactory;

  public DogAddServlet(DogDao dogDao, SqlSessionFactory sqlSessionFactory) {
    this.dogDao = dogDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>보호동물 등록</h1>");

    try {
      dogDao.insert(myDog);
      sqlSessionFactory.openSession(false).commit();
      out.println("<p>등록 성공입니다!</p>");
    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      out.println("<p>등록 실패입니다!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
