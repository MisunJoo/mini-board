<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>성수동 맛집 아카이브</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./css/main.css" />
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Song+Myung|Yeon+Sung" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body class="bg">
    <div class="top-header">
        <p class="logo">성수동 맛집 아카이브</p>
        <%-- 로그인 되어 있으면 로그아웃 버튼 보이게 --%>
        <c:if test="${sessionScope.authUser != null}">
            <a href="/miniboard/logout"><button>로그아웃</button></a>
        </c:if>
    </div>

    <%--<c:if test="${sessionScope.authUser != null}">--%>
        <%--<a href="/miniboard/logout"><button>Log Out</button></a><br>--%>
    <%--</c:if>--%>

    <%--Main Page 입니다.--%>
    <%--성수 맛집 아카이브<br>--%>

    <%--<c:if test="${sessionScope.authUser == null}">--%>
        <%--<a href="/miniboard/signup"><button>Sign Up</button></a>--%>
        <%--<a href="/miniboard/login"><button>Log In</button></a>--%>
    <%--</c:if>--%>

    <%--<c:if test="${sessionScope.authUser != null}">--%>
        <%--<a href="/miniboard/list"><button>한식</button></a>--%>
        <%--<a href="/miniboard/list"><button>중식</button></a>--%>
        <%--<a href="/miniboard/list"><button>양식</button></a>--%>
        <%--<a href="/miniboard/list"><button>일식</button></a>--%>
    <%--</c:if>--%>

    <%-- 로그인 되어 있지 않으면 회원가입 페이지로 이동 --%>
    <c:if test="${sessionScope.authUser == null}">
        <a href="/miniboard/signup" class="enter"><p>웰컴 투 성수</p></a>
    </c:if>
    <%-- 로그인 되어 있으면 리스트로 이동 --%>
    <c:if test="${sessionScope.authUser != null}">
        <a href="/miniboard/list" class="enter"><p>웰컴 투 성수</p></a>
    </c:if>

    <a href="https://github.com/MisunJoo/mini-board" target="_blank" class="github-link">
        <i class="fab fa-github"></i>
    </a>
</body>
</html>
