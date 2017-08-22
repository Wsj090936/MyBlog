<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>后台管理</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" media="all" />
<script type="text/javascript">
	function delArticle(id){
		if(confirm("确定要删除该文章吗？")){
			location.href="${pageContext.request.contextPath }/servlet/deleteServlet?id="+id;
		}
	}
	function checkAll(){
		//得到ckAll元素，获得其选取状态
		var ckAll = document.getElementById("ckAll").checked;
		//得到所有cb复选框元素
		var cb = document.getElementsByName("cb");
		//给每个复选框赋值
		for (var i = 0; i < cb.length; i++) {
			cb[i].checked = ckAll;
		}
	}
</script>
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
			    <li><a href="${pageContext.request.contextPath }/index.jsp" class="active"><span>首页</span></a></li>
			    <li><a href="${pageContext.request.contextPath }/publish.jsp" ><span>发布文章</span></a></li>
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
								<th width="13"><input type="checkbox" class="checkbox" id="ckAll" onclick="checkAll()"/></th>
								<th>标题</th>
								<th>日期</th>
								<th>作者</th>
								<th width="110" class="ac"></th>
							</tr>
							<c:forEach items="${article }" var="each">
							<tr>
								<td><input type="checkbox" class="checkbox" name="cb"/></td>
								<td><h3><a href="#">${each.title }</a></h3></td>
								<td>${each.date }</td>
								<td><a href="#">${each.username }</a></td>
								<td><a href="javascript:delArticle('${each.id }')" class="ico del">删除</a><a href="${pageContext.request.contextPath }/servlet/findArticleByIdServlet?id=${each.id }" class="ico edit">编辑</a></td>
							</tr>
							</c:forEach>
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