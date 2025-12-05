<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
    <h1>메인 페이지</h1>
    <p><%= request.getAttribute("message") %></p>
    <ul>
        <li><a href="/members">멤버 목록</a></li>
        <li><a href="/posts">게시글 목록</a></li>
        <li><a href="/auth/login">로그인</a></li>
    </ul>
    <ul>
        <li><a href="/search">키워드 없이</a></li>
        <li><a href="/search?keyword=spring">Spring Keyword</a></li>
        <li><a href="/search/posts">게시글 검색</a></li>
        <li><a href="/filter">필터 (다중선택)</a></li>
    </ul>
</body>
</html>