<%--
  Created by IntelliJ IDEA.
  User: misun
  Date: 2018. 10. 9.
  Time: PM 3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
<h1>Sign Up</h1>

<form method="post" action="/miniboard/signup">
    아이디 : <input type="text" name="name"><br>
    암호 : <input type="text" name="password"><br>

    <input type="submit">
</form>

</body>
</html>
