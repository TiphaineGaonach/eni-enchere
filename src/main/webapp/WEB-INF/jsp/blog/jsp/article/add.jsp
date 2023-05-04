<%@page import="bo.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<% List<String> erreurs = (List<String>) request.getAttribute("Erreurs"); %>

<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String author = request.getParameter("author");
	Integer id = (Integer) request.getAttribute("id");
	
	Article article = (Article) request.getAttribute("article");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- import CSS -->

<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/Style.css">
<title>Ajout d'un Article</title>
</head>
<body>
<div class="container-fluid">
	<header class="row">
	<%@ include file="/WEB-INF/jsp/parts/menu.jsp" %>
	
	</header>
	
	<main class="row mt-5">
	<div class="row text-center">
		<h1>Ajouter un article</h1>
	</div>
	
	<div class="col-8 offset-2">
		<div class="row mt-5">
			<% 
			if (erreurs!= null) for (String erreur : erreurs) { %>		
			<div class="alert alert-danger">
				<%= erreur %>
			</div>
			<% } %>
			


			
			<!-- on peut mettre "" dans l'action du formulaire car la page qui envoie et recoit les données est la même  -->
			<form action=""  method="POST"  >
			<% if (id != null) {%>
			<label for="id" class="form-label mt-4">ID</label>
			<input TYPE="text" NAME="id" VALUE="<%= id %>" READONLY >				
			<% } %>
			<div class="form-group">
				<label for="title" class="form-label mt-4">Titre</label>
				<input type="text" class="form-control" id="title" name="title" value="<%= (title!=null)? title:(id!=null)? article.getTitle():"" %>" placeholder="ex. Tuto Spring">
			</div>
			
			    <div class="form-group">
      			<label for="content" class="form-label mt-4">Contenu</label>
      			<textarea class="form-control" id="content" name="content"  "rows="3"><%= (content!=null)? content:(id!=null)? article.getContent():"" %></textarea>
    		</div>
    		
    		<div class="form-group">
				<label for="author" class="form-label mt-4">Auteur</label>
				<input type="text" class="form-control" id="author" name="author" value="<%= (author!=null)? author:(id!=null)? article.getAuthor():"" %>" placeholder="ex. Pierre">
			</div>
			<p></p>
			<button type="submit" class="btn btn-primary"><%=(id!=null)?"Modifier":"Ajouter" %></button>
    		
			
			</form>

		<!-- fin JAVA -->
	</div>
		
</div>

	</main>
	<footer class ="row text-center">
		<p>
		<small>Blog Dev &copy; 2023</small>
		</p>
	</footer>
</div>

</body>
</html>