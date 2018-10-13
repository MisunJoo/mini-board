<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form method="get" action="/miniboard/list">--%>
    <select id="country" name="country">
        <option value="" selected disabled hidden>음식 종류</option>
        <option value="korean">한식</option>
        <option value="chinese">중식</option>
        <option value="korean">양식</option>
        <option value="western">일식</option>
    </select>

    <select id="category" name="category">
        <option value="" selected disabled hidden>글 종류</option>
        <option value="promotion">홍보</option>
        <option value="review">후기</option>
    </select>
<%--</form>--%>
글번호 제목 작성자 등록일
<br>
<a href="/miniboard/write"><button>글쓰기</button></a>


<!-- 게시글 목록을 출력한다. -->

<a href="/miniboard/list?country=${country}"></a>
<c:forEach items="${requestScope.articleList}" var="article">
<<<<<<< HEAD
    글종류 : ${article.category}<br>
    글번호 : ${article.id}<br>
    제목 : ${article.title} <br>
    글쓴이 : ${article.userId} <br>
    등록일 : ${article.reg} <br>
||||||| merged common ancestors
    이름 : ${article.title} <br>
    내용 : ${article.content} <br>
=======

    ${article.country} &nbsp;
    ${article.category} &nbsp;
    ${article.id} &nbsp;
    ${article.title} &nbsp;
    ${article.userId} &nbsp;
    ${article.regDate} &nbsp;

>>>>>>> origin/develop
</c:forEach>

<br>
게시글 수 : ${requestScope.articleListSize}<br>
    <script src="/js/main.js"></script>
</body>
</html>
