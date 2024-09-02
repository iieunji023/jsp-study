<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback Summary</title>
</head>
<body>
	<h2>Feedback Summary</h2>
	<c:forEach var="feedback" items="${feedbackList}">
		<li> ${feedback}</li>
	</c:forEach>
</body>


</html>