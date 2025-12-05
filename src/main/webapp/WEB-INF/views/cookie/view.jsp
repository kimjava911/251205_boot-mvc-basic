<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 테스트</title>
</head>
<body>
    <h1>현재 테마 : <%= request.getAttribute("theme") %></h1>

    <h2>테마 변경</h2>
    <a href="/cookie/set?theme=light">라이트 모드</a>
    <a href="/cookie/set?theme=dark">다크 모드</a>

    <h2>쿠키 삭제</h2>
    <a href="/cookie/delete">테마 초기화</a>
</body>
</html>
