<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(135deg, #ff7e5f, #feb47b); /* Gradient background */
        }

        .form-box {
            width: 100%;
            max-width: 400px;
            padding: 30px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .form-box h2 {
            text-align: center;
            margin-bottom: 30px;
            font-size: 28px;
            color: #333;
        }

        .form-control {
            height: 45px;
            border-radius: 8px;
        }

        .input-group-text {
            background-color: #f1f1f1;
            border-radius: 8px 0 0 8px;
        }

        .form-check-label {
            font-size: 14px;
        }

        .button-group {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .button-group .btn {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border-radius: 8px;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-secondary {
            background-color: #6c757d;
            border-color: #6c757d;
        }

        .alert {
            margin-top: 20px;
            text-align: center;
        }

        .alert-danger {
            background-color: #f8d7da;
            color: #721c24;
        }

        .alert-success {
            background-color: #d4edda;
            color: #155724;
        }

        .form-check-input {
            margin-left: 0;
        }

        .btn-link {
            font-size: 14px;
            color: #007bff;
        }

        .btn-link:hover {
            text-decoration: underline;
        }

        .d-flex {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>

<body>

    <div class="form-box">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <h2>Login</h2>

            <c:if test="${alert != null}">
                <div class="alert alert-danger">${alert}</div>
            </c:if>
            <c:if test="${successMsg != null}">
                <div class="alert alert-success">${successMsg}</div>
            </c:if>

            <div class="mb-3">
                <label class="form-label">userName</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-user"></i></span>
                    <input type="text" name="username" class="form-control" placeholder="Enter your username" required>
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fa fa-lock"></i></span>
                    <input type="password" name="password" class="form-control" placeholder="Enter your password" required>
                </div>
            </div>

            <div class="form-check mb-3">
                <input class="form-check-input" type="checkbox" id="rememberMe" name="remember">
                <label class="form-check-label" for="rememberMe">Remember me</label>
            </div>

            <div class="button-group">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>

            <div class="d-flex mt-3">
                <a href="register.jsp" class="btn btn-link">Register</a>
                <a href="forgot-password.jsp" class="btn btn-link">Forgot Password?</a>
            </div>

        </form>
    </div>

</body>

</html>
