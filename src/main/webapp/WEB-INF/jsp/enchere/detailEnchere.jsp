<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% ArticleVendu article = (ArticleVendu) request.getAttribute("article"); %>
<%int surenchere = (int) request.getAttribute("surenchere"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
<title>Detail Vente</title>
</head>
<body>

	<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
	</header>
	
		<div class="row text-center">
		<h1>Détail Vente </h1>
	</div>
	
<div class="row">
  <div class="col-md-3 offset-md-1">
    <img src="<%= request.getContextPath()%>/img/article_<%= article.getNoArticle() %>.png" alt="Image de l'article <%=article.getNoArticle()%>">
  </div>
  <div class="col-md-7">
    <div class="text-center">
      <h3><span style="color:red; font-weight:bold;">Formulaire à créer</span></h3>
      <p><%= article.getNomArticle() %></p>
      <p>Description : <%= article.getDescription() %> </p>
      <p>Catégorie : <span style="color:red; font-weight:bold;">A CREER </span></p>

      <p>Retrait: <span style="color:red; font-weight:bold;">A CREER </span> </p>
      <%-- <p>Vendeur: <%= enchere.getArticleVendu().getUtilisateur().getPseudo() %><span style="color:red; font-weight:bold;"> REQUETE A CREER</span> </p> --%>
      
	  	<form action="" method ="POST">
	  				<p> champ caché ! il y a cet id dedans ! <%= article.getNoArticle() %></p>
		 				<input type="hidden" name="nom_article" value="<%= article.getNoArticle() %>">
		 			<p> fin champ caché</p>
		 	<label for="enchere">Ma proposition :</label>		 		
		 		<select id="enchere" name="enchere">

		    		<option value="<%= surenchere %>"><%= surenchere %></option>
		    			<% for (int i = surenchere; i <= 9989; i += 10) { %>
		      				<option value="<%= i +10 %>"><%= i +10 %></option>
		    			<% } %>
		  		</select>
		  		  		
		  	<button type="submit">Enchérir</button>
		  
		</form>



      
      <p></p>
    </div>
  </div>
</div>
	

</body>
</html>