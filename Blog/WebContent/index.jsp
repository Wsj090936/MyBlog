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
				欢迎你&nbsp;&nbsp;${user.username }
				<span>|</span>
				<a href="${pageContext.request.contextPath }/serlvet/logoutServlet">退出</a>
			</div>
		</div>
		<!-- End Logo + Top Nav -->
		
		<!-- Main Nav -->
		<div id="navigation">
			<ul>
			    <li><a href="index.jsp" class="active"><span>首页</span></a></li>
			    <li><a href="publish.jsp" ><span>发布文章</span></a></li>
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
			<a href="#">首页</a>
			<span>&gt;</span>
			文章列表
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
						<h2 class="left">文章列表</h2>
						<div class="right">
							<label>搜索文章</label>
							<input type="text" class="field small-field" />
							<input type="submit" class="button" value="搜索" />
						</div>
					</div>
					<!-- End Box Head -->	

					<!-- Table -->
					<div class="table">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th width="13"><input type="checkbox" class="checkbox" /></th>
								<th>标题</th>
								<th>日期</th>
								<th>作者</th>
								<th width="110" class="ac"></th>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr>
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<!--<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>
							<tr class="odd">
								<td><input type="checkbox" class="checkbox" /></td>
								<td><h3><a href="#">Lorem ipsum dolor sit amet, consectetur.</a></h3></td>
								<td>12.05.09</td>
								<td><a href="#">管理员</a></td>
								<td><a href="#" class="ico del">删除</a><a href="#" class="ico edit">编辑</a></td>
							</tr>-->
						</table>
						
						
						<!-- Pagging -->
						<div class="pagging">
							<div class="left">1-2</div>
							<div class="right">
								<a href="#">上一页</a>
								<a href="#">1</a>
								<a href="#">2</a>
								<a href="#">3</a>
								<a href="#">4</a>
								<a href="#">245</a>
								<span>...</span>
								<a href="#">下一页</a>
								<a href="#">最后一页</a>
							</div>
						</div>
						<!-- End Pagging -->
						
					</div>
					<!-- Table -->
					
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