<%@ page import="java.util.List" %>
<%@ page import="kr.java.bootmvcbasic.model.entity.Post" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 목록</title>
</head>
<body>
    <h1>게시물 목록</h1>

    <table border="1">
        <%-- table row --%>
        <tr>
            <%-- table header --%>
            <th>ID</th>
            <th>제목</th>
<%--            <th>내용</th>--%>
            <th>작성자</th>
            <th>작성일</th>
            <th>상세보기</th>
        </tr>
        <%
            List<Post> posts = (List<Post>) request.getAttribute("posts");
            for (Post post : posts) {
        %>
        <tr>
            <td><%= post.getId() %></td>
            <td><%= post.getTitle() %></td>
<%--            <td><%= post.getContent() %></td>--%>
            <td><%= post.getMember().getUsername() %></td>
            <td><%= post.getMember().getCreatedAt() %></td>
            <td><a href="/posts/<%= post.getId() %>">보기</a></td>
        </tr>
        <%
            }
        %>
    </table>

    <a href="/posts/new">새 글 쓰기</a>
</body>
</html>