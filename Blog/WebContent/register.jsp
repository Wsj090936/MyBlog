<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
		<form action="${pageContext.request.contextPath }/servlet/regServlet" method="post">
		<table align="center">
		
			<tr>
				<td>
					用户名:
				</td>
				<td>
					<input type="text" name="username" value="${uf.username }">
				</td>
				<td>
					${uf.msgMap.username }${regMsg }
				</td>
			</tr>
			<tr>
				<td>
					密码:
				</td>
				<td>
					<input type="password" name="password">
				</td>
				<td>
					${uf.msgMap.password }
				</td>
			</tr>
			<tr>
				<td>
					确认密码:
				</td>
				<td>
					<input type="password" name="repassword">
				</td>
				<td>
					${uf.msgMap.repassword }
				</td>
			</tr>
			<tr>
				<td>
					邮箱:
				</td>
				<td>
					<input type="text" name="email" value="${uf.email }">
				</td>
				<td>
					${uf.msgMap.email }
				</td>
			</tr>
			<tr><!-- 提交按钮 -->
				<td></td>
				<td>
					<input type="submit" value="注册">
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type="reset" value="重置">
				</td>
			</tr>
		
		</table>
	
	</form>
</body>
</html>