<%@ page import="kr.java.bootmvcbasic.model.entity.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 목록</title>
</head>
<body>
    <h1>회원 목록</h1>

    <table border="1">
        <%-- table row --%>
        <tr>
            <%-- table header --%>
            <th>ID</th>
            <th>이름</th>
            <th>이메일</th>
            <th>상세보기</th>
        </tr>
        <%
            List<Member> members = (List<Member>) request.getAttribute("members");
            for (Member member : members) {
        %>
        <tr>
            <td><%= member.getId() %></td>
            <td><%= member.getUsername() %></td>
            <td><%= member.getEmail() %></td>
            <td><a href="/members/<%= member.getId() %>">보기</a></td>
        </tr>
        <%
            }
        %>
    </table>

    <a href="/members/new">새 회원 등록</a>
</body>
</html>