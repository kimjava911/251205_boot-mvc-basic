<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>필터 결과</title>
</head>
<body>
<h1>필터 결과</h1>

<form method="get">
    <label><input type="checkbox" name="tags" value="java"> Java</label>
    <label><input type="checkbox" name="tags" value="spring"> Spring</label>
    <label><input type="checkbox" name="tags" value="boot"> Boot</label>
    <label><input type="checkbox" name="tags" value="jpa"> JPA</label>
    <button>필터 적용</button>
</form>

<%
    List<String> tags = (List<String>) request.getAttribute("tags");
    if (tags != null && !tags.isEmpty()) {
%>
    <h2>선택된 태그</h2>
    <ul>
        <%
            for (String tag : tags) {
        %>
        <li><%= tag %></li>
        <%
            }
        %>
    </ul>
<% } %>

<a href="/">홈으로</a>
</body>
</html>