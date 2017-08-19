<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登录</title>
<style>
        * {
            margin: 0;
            padding: 0; 
        }
        input:focus{

    border-style:solid;

    border-color:white;

}
        form {
            width: 400px;
            height: 240px;
            border: 1px solid #BA4C32;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -120px;
            margin-left: -200px;
            text-align: center;
            color: #BA4C32;
        }
        h2 {
            position: absolute;
            width: 160px;
            height: 40px;
            line-height: 40px;
            top: -60px;
            left: 120px;
            background-color: white;
            font-family:方正兰亭超细黑简体;
            
        }
        input, select {
            display: block;
            border-radius: 5px;
            
            border: 1px solid #BA4C32;
            margin: 30px 25px;
            height: 35px;
            font-size: 18px;
            text-indent: 1em;
            width: 350px;
        }
        button {
            width: 100px;
            text-align: center;
            height: 40px;
            line-height: 40px;
            color: white;
            background-color: #BA4C32;
            font-size: 18px;
            border: 0;
            border-radius: 5px;
            margin: 0 auto;
            font-family:方正兰亭超细黑简体;
        }
    </style>
</head>
<body>
    <form action="${pageContext.request.contextPath }/servlet/loginServlet" method="post">
    <input type="hidden" name="action" value="login">
        <h2>欢 迎 登 录</h2>
        <input type="text" name="username" placeholder="用户名" />
        <input type="password" name="password" placeholder="用户密码" />
        <button type="reset">重&nbsp&nbsp&nbsp&nbsp&nbsp置</button>
        <button type="submit">登&nbsp&nbsp&nbsp&nbsp&nbsp录</button>
        <a href="register.jsp">注册</a>
    </form>
</body>
</html>