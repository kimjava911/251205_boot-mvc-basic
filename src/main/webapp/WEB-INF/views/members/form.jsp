<%@ page import="kr.java.bootmvcbasic.model.entity.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 등록</title>
</head>
<body>
<h1>회원 등록</h1>
    <form action="/members" method="post">
        <div>
            <label>이름:</label>
            <input name="username" required>
        </div>
        <div>
            <label>이메일:</label>
            <input name="email" required>
        </div>
        <button>등록</button>
        <a href="/members">취소</a>
    </form>
</body>
</html>