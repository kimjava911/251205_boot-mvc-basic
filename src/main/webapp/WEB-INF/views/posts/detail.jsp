<%@ page import="kr.java.bootmvcbasic.model.entity.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 상세</title>
</head>
<body>
    <h1>게시물 상세</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        <% Post post = (Post) request.getAttribute("post"); %>
        <tr>
            <td><%= post.getId() %></td>
            <td><%= post.getTitle() %></td>
            <td><%= post.getContent() %></td>
            <td><%= post.getMember().getUsername() %></td>
            <td><%= post.getCreatedAt() %></td>
            <td><a href="/posts/<%= post.getId() %>/edit">수정</a></td>
            <td><form method="post" action="/posts/<%= post.getId()%>/delete"><button>삭제</button></form></td>
        </tr>
    </table>

    <a href="/posts/new">새 글 쓰기</a>
    <a href="/posts">글 목록</a>
</body>
</html>