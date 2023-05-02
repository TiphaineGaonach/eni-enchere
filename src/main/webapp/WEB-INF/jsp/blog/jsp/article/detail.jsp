<%@page import="helpers.Flash"%>
<%@page import="bo.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Article article = (Article) request.getAttribute("article"); %>
<% String info = Flash.getMessage("success",session);%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- import CSS -->

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../assets/css/Style.css">
<title>Détail Article</title>
</head>
<body>
<div class="container-fluid">
	<header class="row">
<%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
	
	</header>
	
	<main class="row mt-5">
	<% if(info!= null) { %>
	<div class="btn btn-alert">
	<%=info %>
	</div>
	<%} %>
	<div class="row text-center">
		<h1>Détail <%= article.getTitle() %></h1>
	</div>
	
	<div class="col-8 offset-2 text-center">
		<div class="row mt-5 text-center">
			
			<!--  Code JAVA -->
			<p>Contenu : <%= article.getContent() %> </p>
			<p>Auteur : <%= article.getAuthor() %> </p>
			<p>Date de création : <%= article.getDateCreation() %> </p>
			
			<!-- fin JAVA -->

		</div>
		<div class="row text-center">
			<div class="col-2 offset-4">
				<a href="<%= request.getContextPath() %>/articles/modifier/<%= article.getId() %>" class="btn btn-light">Modifier</a>
				<br><br>
				<a href="<%= request.getContextPath() %>/articles/modifier2/<%= article.getId() %>" class="btn btn-light">Modifier2</a>
			</div>

			<div class="col-2" >			
				<a onclick="return (confirm('Êtes-vous sûr de vouloir supprimer cet article ?'));" href="<%= request.getContextPath() %>/articles/supprimer/<%= article.getId() %>" class="btn btn-dark">Supprimer</a>
			</div>
		</div>

		
</div>

	</main>
	<footer class ="row text-center">
		
		<small>Blog Dev &copy; 2023</small>
	
	</footer>
</div>

</body>
</html>