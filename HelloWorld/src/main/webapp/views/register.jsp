<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Đăng ký tài khoản</h2>
	<form action="${pageContext.request.contextPath}/register"
		method="post">
		<label for="username">Tên đăng nhập:</label> <input type="text"
			id="username" name="username" required><br> <label
			for="password">Mật khẩu:</label> <input type="password" id="password"
			name="password" required><br> <label for="fullName">Họ
			và tên:</label> <input type="text" id="fullName" name="fullName" required><br>

		<label for="email">Email:</label> <input type="email" id="email"
			name="email" required><br> <input type="submit"
			value="Đăng ký">
	</form>
</body>
</html>