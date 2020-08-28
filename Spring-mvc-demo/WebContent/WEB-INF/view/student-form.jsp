<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<! DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>
</head>
<body>

	<form:form action ="processForm" modelAttribute="student">
		
	 	First Name : <form:input path="firstName"/>	
	 	
	 	<br><br>
	 	
	 	Last Name : <form:input path="lastName"/>
	 	
	 	<br><br>
	 	
	 	Country : <form:select path ="country">
	 		<form:options items="${student.countryOptions}"/>
	 		
	 		</form:select>
	 	<br><br>
	 	Favorite  Languages:
	 	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
	 	
	 	<!--  Java<form:radiobutton path="favoriteLanguage" value="Java"/>
	 	 Python<form:radiobutton path="favoriteLanguage" value="Python"/>
	 	Dart<form:radiobutton path="favoriteLanguage" value="Dart"/>
	 	Go<form:radiobutton path="favoriteLanguage" value="Go"/>-->
	 		
	 	<br><br>
	 	 Operating Systems:
	 	 <form:checkboxes path="operatingSystems" items="${student.operatingSystemsOptions}"/> 
	 	<br><br>
	 	<input type="submit" value= "Submit"/>	
	 	
	</form:form>



</body>
</html>