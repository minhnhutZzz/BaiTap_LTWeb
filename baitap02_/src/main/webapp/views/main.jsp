<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Page</title>
<style>
body {
	margin: 0;
	padding: 0;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #ffcc00; /* Màu vàng */
	font-family: Arial, sans-serif;
}

.welcome {
	background: white;
	padding: 40px 60px;
	border-radius: 15px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
	text-align: center;
	width: 80%;
	max-width: 500px;
}

.welcome h1 {
	color: #333;
	font-size: 28px;
	margin-bottom: 20px;
}

.welcome p {
	color: #555;
	font-size: 18px;
	margin-bottom: 30px;
}

.welcome button {
	padding: 12px 20px;
	font-size: 16px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 8px;
	cursor: pointer;
	transition: background-color 0.3s;
}

.welcome button:hover {
	background-color: #0056b3;
}

/* Add responsive design for smaller screens */
@media ( max-width : 600px) {
	.welcome {
		padding: 20px 30px;
	}
	.welcome h1 {
		font-size: 24px;
	}
	.welcome p {
		font-size: 16px;
	}
}
</style>
</head>

<body>

	<div class="welcome">
		<h1>Chúc mừng bạn đăng nhập thành công!</h1>
		<button onclick="window.location.href='home.jsp'">Đi đến
			trang chủ</button>
	</div>

</body>

</html>
