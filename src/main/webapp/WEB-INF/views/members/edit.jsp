<%@ page import="kr.java.bootmvcbasic.model.entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 수정</title>
</head>
<body>
    <% Member member = (Member) request.getAttribute("member"); %>
    <h1>회원 정보 수정</h1>
    <form action="/members/<%= member.getId() %>" method="post" >
        <div>
            <label>이름:</label>
            <input name="username" value="<%= member.getUsername() %>" required>
        </div>
        <div>
            <label>이메일:</label>
            <input name="email" value="<%= member.getEmail() %>" required>
        </div>
        <button>수정</button>
        <a href="/members/<%= member.getId() %>">취소</a>
    </form>
</body>
</html>