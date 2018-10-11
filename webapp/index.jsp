<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>성수동 맛집 아카이브</title>
</head>
<body>

    <c:if test="${sessionScope.authUser == null}">
        <a href="/miniboard/login"><button>Log In</button></a><br>
    </c:if>
    <c:if test="${sessionScope.authUser != null}">
        <a href="/miniboard/logout"><button>Log Out</button></a><br>
    </c:if>

    Main Page 입니다.
    성수 맛집 아카이브<br>

    <c:if test="${sessionScope.authUser == null}">
        <a href="/miniboard/signup"><button>Sign Up</button></a>
        <a href="/miniboard/login"><button>Log In</button></a>
    </c:if>

    <c:if test="${sessionScope.authUser != null}">
        <a href="/miniboard/list"><button>한식</button></a>
        <a href="/miniboard/list"><button>중식</button></a>
        <a href="/miniboard/list"><button>양식</button></a>
        <a href="/miniboard/list"><button>일식</button></a>
    </c:if>

</body>
</html>
