<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>검색 결과보기</title>
</head>
<body>
<h1>검색 결과보기</h1>

<p><%= request.getAttribute("keyword") %></p>
<p><%= request.getAttribute("message") %></p>
<a href="/">홈으로</a>
</body>
</html>