<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>성수동 맛집 아카이브</title>
</head>
<body>
    분류 : ${requestScope.article.country}<br>
    글종류 : ${requestScope.article.category}<br>
    글번호 : ${requestScope.article.id}<br>
    글쓴이 : ${requestScope.article.userId}<br>
    이름 : ${requestScope.article.title}<br>
    등록일 : ${requestScope.article.regDate} <br><br>
</body>
</html>
