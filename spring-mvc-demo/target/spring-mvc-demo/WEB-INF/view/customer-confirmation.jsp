<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer confirmation page</title>
</head>
<body>
The customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes: ${customer.freePasses}

<br><br>

Postal code: ${customer.postalCode}

<br><br>

Course code: ${customer.courseCode}
</body>
</html>
