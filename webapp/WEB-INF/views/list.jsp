<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

게시글 수 : ${requestScope.articleListSize}<br>


<!-- 게시글 목록을 출력한다. -->
<c:forEach items="${requestScope.articleList}" var="article">
    글종류 : ${article.category}<br>
    글번호 : ${article.id}<br>
    제목 : ${article.title} <br>
    글쓴이 : ${article.userId} <br>
    등록일 : ${article.reg} <br>
</c:forEach>


</body>
</html>
