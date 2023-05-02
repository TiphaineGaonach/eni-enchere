<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Article> articles = (List<Article>) request.getAttribute("articles"); %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- import CSS -->

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/Style.css">
<title>Liste Articles</title>
</head>
<body>
<div class="container-fluid">
	<header class="row">
<%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
	
	</header>
	
	<main class="row mt-5">
	<div class="row text-center">
		<h1>Liste Articles</h1>
	</div>
	
	<div class="col-8 offset-2 mt-5">
		<div class="row mt-5">
			
			<!--  Code JAVA -->
			<% for (Article article : articles) { %>
			
			<div class="col-4">
				<div class="card border-light mb-3" style="max-width: 20rem;">
				  <div class="card-header"><%= article.getAuthor() %></div>
				  <div class="card-body">
				    <h4 class="card-title"><%= article.getTitle() %></h4>
				    <p class="card-text"><%= article.getContent() %></p>
				    <a href="<%= request.getContextPath() %>/tutos/detail/<%= article.getId() %>" class="btn btn-primary">Détail</a>
				  </div>
				 </div>
			</div>
		<% } %>	
		<!-- fin JAVA -->

		</div>
</div>

	</main>
	<footer class ="row text-center">
		
		<small>Blog Dev &copy; 2023</small>
	
	</footer>
</div>

</body>
</html>