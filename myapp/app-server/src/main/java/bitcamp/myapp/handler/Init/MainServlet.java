package bitcamp.myapp.handler.Init;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class MainServlet extends HttpServlet {
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
        out.println("<title>전국 동물보호소 보호동물 정보시스템</title>");
        out.println("<link rel='stylesheet' type='text/css' href='styles.css'>");
        // 이곳에 스타일과 스크립트 코드 등 추가 가능
        out.println("<style>");
        out.println(".notice-container {");
        out.println("  background-color: rgba(255, 255, 255, 0.7);");
        out.println("  padding: 20px;");
        out.println("  border-radius: 5px;");
        out.println("  margin: 20px auto;");
        out.println("  width: 80%;");
        out.println("  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);");
        out.println("  text-align: left;"); // 가운데 정렬 추가
        out.println("  position: relative;");
        out.println("}");
        out.println(".close-button {");
        out.println("  position: absolute;");
        out.println("  top: 10px;");
        out.println("  right: 10px;");
        out.println("  cursor: pointer;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='main-container'>");
        out.println("<h1 class='main-title'>🐾 전국 동물보호소 정보시스템</h1>");
        out.println("<ul class='main-menu'>");
        out.println("<li><a href='/member/list'>👤회원정보</a></li>");
        out.println("<li><a href='/dog/list'>🐶보호동물</a></li>");
        out.println("<li><a href='/board/list?category=1'>😻입양신청</a></li>");
        out.println("<li><a href='/board/list?category=2'>✍게시판</a></li>");
        // 로그인/로그아웃 링크 추가
        if (request.getSession().getAttribute("loginUser") == null) {
            out.println("<li><a href='/auth/form.html'>🔒로그인</a></li>");
        } else {
            out.println("<li><a href='/auth/logout'>🔒로그아웃</a></li>");
        }
        out.println("</ul>");
        out.println("</div>");
        // 공지사항 코드 추가
        out.println("<div class='notice-container'>");
        out.println("<span class='close-button' onclick='closeNotice()'>X</span>");
        out.println("<h2 class='notice-title'>📣 공지사항</h2>");
        out.println("<p>본 시스템은 동물보호와 관련된 정보를 제공하는 시스템입니다. 최신 소식과 보호동물 정보를 확인하세요!</p>");
        out.println("<p>보호 중인 동물을 확인하고, 미리 입양 사전신청을 통해서 보호기간이 종료된 동물에 대해 입양기회를 얻을 수 있습니다.</p>");
        // 스크립트 코드 추가
        out.println("<script>");
        out.println("function closeNotice() {");
        out.println("const noticeContainer = document.querySelector('.notice-container');");
        out.println("noticeContainer.style.display = 'none';");
        out.println("}");
        out.println("</script>");
        out.println("</div>"); // 공지사항 닫는 div 태그 추가
        out.println("</body>");
        out.println("</html>");
    }
}
