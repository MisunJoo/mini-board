<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <form method="post" action="/miniboard/login">
        아이디 : <input type="text" name="userName" required><br>
        암호 : <input type="password" name="password" required><br>

        <input type="submit" value="로그인">
    </form>

    <c:if test="${isIdNull == true}">
        <p style="color: red">존재하지 않는 아이디입니다.</p>
    </c:if>

    <c:if test="${wrongPw == true}">
        <p style="color: red">비밀번호를 확인하세요.</p>
    </c:if>
</body>
</html>
