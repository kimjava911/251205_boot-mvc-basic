<%@ page import="kr.java.bootmvcbasic.model.entity.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 수정</title>
</head>
<body>
<h1>게시물 수정</h1>
    <% Post post = (Post) request.getAttribute("post"); %>
    <form action="/posts/<%= post.getId() %>" method="post">
        <div>
            <label>제목:</label>
            <input name="title" required value="<%= post.getTitle() %>">
        </div>
        <div>
            <label>내용:</label>
            <input name="content" required value="<%= post.getContent() %>">
        </div>
        <button>작성</button>
        <a href="/posts">취소</a>
    </form>
</body>
</html>