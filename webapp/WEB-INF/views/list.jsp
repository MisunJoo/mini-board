<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>성수동 맛집 아카이브</title>
</head>
<body>

    <form>
    <select id="country" name="country">
        <option value="" selected disabled>음식 종류</option>
        <option value="korean">한식</option>
        <option value="chinese">중식</option>
        <option value="western">양식</option>
        <option value="japanese">일식</option>
    </select>

    <select id="category" name="category">
        <option value="" selected disabled>글 종류</option>
        <option value="promotion">홍보</option>
        <option value="review">후기</option>
    </select>

        <input type="submit" value="선택조건으로 검색"/>
    </form>
    <br>

    분류 글종류 글번호 작성자 제목 등록일<br>

    <!-- 게시글 목록을 출력한다. -->

    <c:forEach items="${requestScope.articleList}" var="article">

        분류 : ${article.country}
        글종류 : ${article.category}
        글번호 : ${article.id}
        글쓴이 : ${article.userId}
        <a href="/miniboard/list/detail?id=${article.id}">이름 : ${article.title}</a>
        등록일 : ${article.regDate} <br><br>

    </c:forEach>
    <br>

    게시글 수 : ${requestScope.articleListSize}<br>
    <a href="/miniboard/write"><button>글쓰기</button></a>

</body>
</html>
