<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>

    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    Country:
    <form:select path="country">
        <form:options items="${mapCountryOptions.values()}"/>
    </form:select>

    <br><br>

    Favorite language:
    <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>

    <br><br>

    Operating systems:
    <form:checkbox path="operatingSystems" value="Linux" label="Linux"/>
    <form:checkbox path="operatingSystems" value="Mac OS" label="Mac OS"/>
    <form:checkbox path="operatingSystems" value="MS Windows" label="MS Windows"/>

    <br><br>

    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
