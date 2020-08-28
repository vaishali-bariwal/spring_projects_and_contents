<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Student Confirmation </title>
</head>
<body><center>
Hello World of Spring!

<br><br>

The Student is confirmed : ${student.firstName} ${student.lastName}
<br>
Country : ${student.country}
<br><br>
Favorite  Languages:  ${student.favoriteLanguage}
<br><br>
Operating Systems :
<ul>
	<c:forEach var="temp" items ="${student.operatingSystems}">
	<li>${temp}</li>
	</c:forEach>
</ul>
</center>

</body>

</html>



