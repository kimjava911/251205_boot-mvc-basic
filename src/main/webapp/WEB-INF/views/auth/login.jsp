<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>

    <%-- action="/auth/login" --%>
    <form method="post">
        <input name="username" placeholder="사용자명" required><button>로그인</button>
    </form>

    <a href="/">홈</a>
</body>
</html>
