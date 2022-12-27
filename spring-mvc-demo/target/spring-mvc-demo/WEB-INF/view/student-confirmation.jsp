<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Confirmation Page</title>
</head>
<body>

Student is confirmed: ${student.firstName} ${student.lastName}

<br><br>

Country: ${student.country}

<br><br>

Favorite language: ${student.favoriteLanguage}

<br><br>

Operating systems:
<ul>
    <c:forEach var="item" items="${student.operatingSystems}">
        <li> ${item} </li>
    </c:forEach>
</ul>

</body>
</html>
