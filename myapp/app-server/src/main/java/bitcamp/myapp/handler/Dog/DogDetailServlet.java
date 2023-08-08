package bitcamp.myapp.handler.Dog;

import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.myapp.dao.DogDao;
import bitcamp.util.Component;
import bitcamp.util.HttpServletRequest;
import bitcamp.util.HttpServletResponse;
import bitcamp.util.Servlet;

@Component("/dog/delete")
public class DogDetailServlet implements Servlet {

  DogDao dogDao;
  SqlSessionFactory sqlSessionFactory;
  
  public DogDetailServlet(DogDao dogDao, SqlSessionFactory sqlSessionFactory) {
    this.dogDao = dogDao;
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception {
    try {
      if (dogDao.delete(Integer.parseInt(request.getParameter("no"))) == 0) {
        throw new Exception("해당 번호의 보호동물이 없습니다.");
      } else {
        response.sendRedirect("/member/list");
      }
      sqlSessionFactory.openSession(false).commit();

    } catch (Exception e) {
      sqlSessionFactory.openSession(false).rollback();
      throw new RuntimeException(e);
    }
  }

}