<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
 	Starting to create something incredible!
 	
 	<div style="color:green;">
 		<c:out value="${added}"></c:out>
 	</div>
 	<form action="newMember" method="POST">
 		
 		<div>
			<label>Name:</label><input type="text" name="name" id="name"/><br/>
		</div>
		<div>
			<label>Category:</label><input type="text" name="category" id="category"/>
		</div>
		<div>
			<label>Score:</label><input type="text" name="score" id="score"/>
		</div>
 		<div>
			Interested in:
			<label>Java</label><input type="checkbox" name="interests" value="Java"/>
			<label>.NET</label><input type="checkbox" name="interests" value=".NET"/>
			<label>SQL</label><input type="checkbox" name="interests" value="SQL"/>
			<label>Javascript</label><input type="checkbox" name="interests" value="Javascript"/>
 		</div>
 		
 		<input type="submit" value="Crear!"/>
 	</form>
</body>
</html>