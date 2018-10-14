<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <%-- 댓글 목록 --%>
    <c:forEach items="${requestScope.commentList}" var="comment">
        댓글 id: ${comment.id}
        article_id: ${comment.articleId}
        user_id: ${comment.userId}
        댓글 내용: ${comment.content}
        등록일: ${comment.regDate}

        <%--자신이 입력한 댓글일 경우 삭제버튼 보임 --%>
        <c:if test="${comment.userId == sessionScope.authUser.id}">
            <a href="/miniboard/delete?articleId=${requestScope.article.id}&commentId=${comment.id}"><button>삭제</button></a>
        </c:if>

        <br>

    </c:forEach>

    <%-- 댓글 입력창 --%>
    <c:if test="${sessionScope.authUser != null}">
        <form method="POST" action="/miniboard/list/detail">
            <input type="hidden" name="articleId" value="${requestScope.article.id}">
            <input type="hidden" name="userId" value="${requestScope.article.userId}">
            <div>${requestScope.article.userId}</div>
            <textarea id="content" name="content" rows="4" cols="50"></textarea>
            <div><input type="submit" value="댓글 등록"/></div>
        </form>
    </c:if>


    <a href="/miniboard/list"><button>목록</button></a>
</body>
</html>
