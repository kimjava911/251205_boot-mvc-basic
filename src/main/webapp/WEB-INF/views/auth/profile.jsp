<%@ page import="kr.java.bootmvcbasic.model.entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>내 정보</title>
</head>
<body>
<table border="1">
    <%-- table row --%>
    <tr>
        <%-- table header --%>
        <th>ID</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일</th>
    </tr>
    <%
        Member member = (Member) request.getAttribute("member");
    %>
    <tr>
        <td><%= member.getId() %></td>
        <td><%= member.getUsername() %></td>
        <td><%= member.getEmail() %></td>
        <td><%= member.getCreatedAt() %></td>
    </tr>
</table>
<a href="/auth/logout">로그아웃</a>
</body>
</html>
