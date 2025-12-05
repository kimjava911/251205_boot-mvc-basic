<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 검색</title>
</head>
<body>
<h1>게시글 검색</h1>

<form method="get">
    <input name="keyword" placeholder="검색어"
            value="<%= request.getAttribute("keyword") != null ? request.getAttribute("keyword") : "" %>">
    <label>
        페이지 : <input
                    type="number" name="page"
                    value="<%= request.getAttribute("page") %>"
                    min="1">
    </label>
    <label>
        페이지당 개수 : <select name="size">
            <option value="10">10개</option>
            <option value="20">20개</option>
            <option value="50">50개</option>
        </select>
    </label>
    <button>검색</button>
</form>

<%
    String keyword = (String) request.getAttribute("keyword");
    if (keyword != null && !keyword.isEmpty()) {
%>
    <p>"<%= keyword %>" 검색 결과 - 페이지 <%= request.getAttribute("page") %></p>
<%
    }
%>

<a href="/">홈으로</a>
</body>
</html>