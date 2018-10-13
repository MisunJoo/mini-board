<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
<h1>Sign Up</h1>

<form method="post" action="/miniboard/signup">
    아이디 : <input type="text" name="name" required><br>
    암호 : <input type="password" name="password" required minlength="3" maxlength="20"><br>

    <input type="submit">
</form>

<c:if test="${sessionScope.isExistingUser == true}">
    <p style="color: red">이미 가입된 아이디입니다.</p>
</c:if>

</body>
</html>
