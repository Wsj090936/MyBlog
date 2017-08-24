<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
	window.onload=function(){
		var nameElement = document.getElementsByName("username")[0];
		nameElement.onblur = function(){
			var name = this.value;//得到用户输入的内容
			var req;
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  req=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  req=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			req.onreadystatechange = function(){
				if(req.readyState==4){//请求一切正常
					if(req.status==200){//服务器一切正常
						var namemsg = document.getElementById("namemsg");
						if(req.responseText=="true"){
							namemsg.innerHTML = "<font color='red' size='2'>用户名已存在</font>"
						}
					}
				}
			}
			req.open("get","${pageContext.request.contextPath }/servlet/CkUserNameServlet?username="+name);//创建连接
			req.send(null);//发送请求
		}
	}
</script>
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
					<span id="namemsg"></span><span><font color="red" size="2">${uf.msgMap.username }${regMsg }</font></span>
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
					<span><font color="red" size="2">${uf.msgMap.password }</font></span>
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
					<span><font color="red" size="2">${uf.msgMap.repassword }</font></span>
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
					<span><font color="red" size="2">${uf.msgMap.email }</font></span>
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