<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>后台管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" media="all" />
</head>
<body>
<!-- Header -->
<div id="header">
	<div class="shell">
		<!-- Logo + Top Nav -->
		<div id="top">
			<h1><a href="#">MagicWolf</a></h1>
			<div id="top-navigation">
				欢迎&nbsp;&nbsp;<a href="#"><strong>${user.username }</strong></a>
				<span>|</span>
				<a href="${pageContext.request.contextPath }/serlvet/logoutServlet">退出</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
		<div id="navigation">
			<ul>
			    <li><a href="${pageContext.request.contextPath }/servlet/pageServlet" ><span>首页</span></a></li>
			    <li><a href="${pageContext.request.contextPath }/publish.jsp" class="active"><span>发布文章</span></a></li>
			</ul>
		</div>
		<!-- End Main Nav -->
	</div>
</div>
<!-- End Header -->

<!-- Container -->
<div id="container">
	<div class="shell">
		
		<!-- Small Nav -->
		<div class="small-nav">
			<a href="${pageContext.request.contextPath }/servlet/pageServlet">首页</a>
			<span>&gt;</span>
			查看文章
		</div>
		<!-- End Small Nav -->
				
		<br />
		<!-- Main -->
		<div id="main">
			<div class="cl">&nbsp;</div>
			
			<!-- Content -->
			<div id="content">
				
				
				<!-- Box -->
				<div class="box">
					<!-- Box Head -->
					<div class="box-head">
						<h2>查看文章</h2>
					</div>
					<!-- End Box Head -->
											
						<!-- Form -->
						<div class="form">
									<h1 align="center" style="color:black">${look.title }</h1>
								<p style="color:black;font-size:16px">
									${look.content }
								</p>	
							
						</div>
						<!-- End Form -->
						
						<!-- Form Buttons -->
						<!-- End Form Buttons -->
				</div>
				<!-- End Box -->

			</div>
			<!-- End Content -->
						
			<div class="cl">&nbsp;</div>			
		</div>
		<!-- Main -->
	</div>
</div>
<!-- End Container -->

<!-- Footer -->
<div id="footer">
	<div class="shell">
		<span class="left">&copy; 2010 - CompanyName</span>
		<span class="right">
			Design by <a href="http://chocotemplates.com" target="_blank" title="The Sweetest CSS Templates WorldWide">Chocotemplates.com</a>
		</span>
	</div>
</div>
<!-- End Footer -->
	
</body>
</html>