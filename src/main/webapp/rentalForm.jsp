<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Rental Form</title>
</head>
<body>
	<h2>Rental Form</h2>
	<form action="rentalBook" method="post">
		<input type="text" name="bookId" placeholder="도서 아이디를 입력해주세요."><br>
		<input type="number" name="rentalPeriod" placeholder="대여기간을 입력해주세요."><br>
		<input type="submit" value="대여">
	</form>
	
</body>
</html>