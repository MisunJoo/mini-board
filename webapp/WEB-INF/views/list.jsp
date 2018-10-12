<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="./list.jsp">
    <select name="country">
        <!--<option value="" selected disabled hidden>음식 종류</option>-->
        <option value="korean">한식</option>
        <option value="chinese">중식</option>
        <option value="korean">양식</option>
        <option value="western">일식</option>
    </select>
    <select name="category">
        <!--<option value="" selected disabled hidden>글 종류</option>-->
        <option value="promotion">홍보</option>
        <option value="review">후기</option>
    </select>
</form>
글번호 제목 작성자 등록일
<br>


<!-- 게시글 목록을 출력한다. -->
<c:forEach items="${requestScope.articleList}" var="article">

    ${article.country} &nbsp;
    ${article.category} &nbsp;
    ${article.id} &nbsp;
    ${article.title} &nbsp;
    ${article.userId} &nbsp;
    ${article.regDate} &nbsp;

</c:forEach>

<br>
게시글 수 : ${requestScope.articleListSize}<br>

</body>
</html>
