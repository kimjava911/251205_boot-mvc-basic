<%@ page import="kr.java.bootmvcbasic.model.entity.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물 등록</title>
</head>
<body>
<h1>게시물 등록</h1>
    <form action="/posts" method="post">
        <div>
            <label>작성자:</label>
            <select name="memberId" required>
                <%
                    List<Member> members = (List<Member>) request.getAttribute("members");
                    for (Member member : members) {
                %>
                    <option value="<%= member.getId() %>"><%= member.getUsername() %></option>
                <%  } %>
            </select>
        </div>
        <div>
            <label>제목:</label>
            <input name="title" required>
        </div>
        <div>
            <label>내용:</label>
            <input name="content" required>
        </div>
        <button>작성</button>
        <a href="/posts">취소</a>
    </form>
</body>
</html>