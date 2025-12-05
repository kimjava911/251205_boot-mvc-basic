<%@ page import="kr.java.bootmvcbasic.model.entity.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 상세보기</title>
</head>
<body>
<h1>회원 상세보기</h1>

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
//        List<Member> members = (List<Member>) request.getAttribute("members");
//        for (Member member : members) {
        Member member = (Member) request.getAttribute("member");
    %>
    <tr>
        <td><%= member.getId() %></td>
        <td><%= member.getUsername() %></td>
        <td><%= member.getEmail() %></td>
        <td><%= member.getCreatedAt() %></td>
    </tr>
    <a href="/members/<%= member.getId() %>/edit">수정하기</a>
</table>

<a href="/members">멤버 목록</a>
</body>
</html>