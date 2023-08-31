<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시글</title>
</head>
<body>
<div style='height: 80px;background-color:orange;'>
    <img src='https://www.ncloud.com/public/img/logo-m.png' style='height:50px'>'
    <a href='/member/list'>회원</a>
    <a href='/board/list?category=1'>게시글</a>
    <a href='/board/list?category=2'>독서록</a>
    <a href='/auth/form'>로그인</a>
</div>
<h1>게시글 목록</h1>
<div style='margin:5px;'>
<a href='/board/form?category=1'>새 글</a>
</div>
<table border='1'>
<thead>
  <tr><th>번호</th> <th>제목</th> <th>작성자</th> <th>조회수</th> <th>등록일</th></tr>
</thead>
