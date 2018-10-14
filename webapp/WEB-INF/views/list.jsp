<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>성수동 맛집 아카이브</title>
</head>
<body>

    <form method="get" action="/miniboard/list">
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

    <c:forEach items="${articleList}" var="article">

        분류 : ${article.country}
        글종류 : ${article.category}
        글번호 : ${article.id}
        글쓴이 : ${article.userId}
        <a href="/miniboard/list/detail?id=${article.id}">이름 : ${article.title}</a>
        등록일 : ${article.regDate} <br><br>

    </c:forEach>
    <br>


    <c:if test="${currentPage != 1}">
        <td><a href="/miniboard/list?page=${currentPage - 1}">Previous</a></td>
    </c:if>

    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/miniboard/list?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

    <c:if test="${currentPage lt noOfPages}">
        <td><a href="/miniboard/list?page=${currentPage + 1}">Next</a></td>
    </c:if>

    게시글 수 : ${requestScope.articleListSize}<br>
    <a href="/miniboard/write"><button>글쓰기</button></a>

</body>
</html>
