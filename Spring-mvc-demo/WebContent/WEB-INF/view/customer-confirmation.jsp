<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<title>Customer Confirmation </title>
</head>
<body><center>
Hello World of Spring!

<br><br>

The Customer is confirmed : ${customer.firstName} ${customer.lastName} 
<br>
<br>

Free Passes : ${customer.freePasses}
<br>
<br>
Postal Code : ${customer.postalcode}
<br>
<br>
CourseCode : ${customer.courseCode}
<br>
<br>
</center>

</body>

</html>



