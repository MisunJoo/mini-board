<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성하기</title>
</head>
<body>
    <form method="POST" action="/miniboard/write">
        <%-- userId는 sessionScope로 가져온다. --%>
        <%-- country, category, title, content --%>
        <select name="country" required>
            <option value="" selected disabled hidden>음식 종류</option>
            <option value="korean">한식</option>
            <option value="chinese">중식</option>
            <option value="western">양식</option>
            <option value="japanese">일식</option>
        </select>
        <select name="category" required>
            <option value="" selected disabled hidden>글 종류</option>
            <option value="promotion">홍보</option>
            <option value="review">후기</option>
        </select>
        제목: <input type="text" name="title" required><br>
        <textarea name="content" id="content" cols="50" rows="30" required></textarea>
        <br>
        <input type="submit">
    </form>
</body>
</html>