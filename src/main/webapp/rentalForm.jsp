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
		<input type="text" name="bookId" placeholder="���� ���̵� �Է����ּ���."><br>
		<input type="number" name="rentalPeriod" placeholder="�뿩�Ⱓ�� �Է����ּ���."><br>
		<input type="submit" value="�뿩">
	</form>
	
</body>
</html>