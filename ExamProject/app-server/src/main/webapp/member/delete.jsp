<%@ page
        language="java"
        pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8"
        trimDirectiveWhitespaces="true"
        errorPage="/error.jsp" %>

<%@ page import="bitcamp.myapp.dao.MemberDao" %>
<%@ page import="bitcamp.myapp.vo.Board" %>
<%@ page import="bitcamp.myapp.vo.Member" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>


<%
    request.setAttribute("refresh", "2;url=list.jsp?category=" + request.getParameter("category"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
        response.sendRedirect("/auth/form.jsp");
        return;
    }

    MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
    SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");


    if (memberDao.delete(Integer.parseInt(request.getParameter("no"))) == 0) {
        throw new Exception("해당 번호의 회원이 없습니다.");
    } else {
        sqlSessionFactory.openSession(false).commit();
        response.sendRedirect("/member/list.jsp");
    }
%>


