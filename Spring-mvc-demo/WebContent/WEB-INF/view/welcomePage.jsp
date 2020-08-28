<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link rel="stylesheet" type="text/css"           

            href="${pageContext.request.contextPath}/resources/css/my-test.css">

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>

</head>
<body>
<center>
<h3>Hi this is your home Page</h3>
<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" />
<hr>

<input type="button" onclick="doSomeWork()" value="Click Me"/>
<hr>
<hr>
<a href="hello/showForm">Hello World form</a>
<br>
<br>
<a href="student/showForm">Student form</a>
<br>
<br>
<a href="customer/showForm">Customer form</a>
</center>
</body>
</html>