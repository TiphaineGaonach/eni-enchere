<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="fr.eni.encheres.bll.EnchereManager"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@page import = "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% List<Enchere> encheres = (List<Enchere>) request.getAttribute("encheres"); %> 

<% // Extraction du code de formatage de date en dehors de la boucle
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
	<title>Accueil</title>
</head>


<body>

		<!----------------------- HEADER / NAVBAR ----------------------->
		<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
		</header>	

		<!----------------------- MAIN ----------------------->
		<main class= "row mt-5" >
		
		<form action="">
			<div class = "">  
				<h2>Filtres</h2>
			</div>
			<div class="form-group">
			  <fieldset>
			    <label class="form-label mt-4" for="readOnlyInput"></label>
			    <input class="form-control" id="readOnlyInput" type="text" placeholder="Le nom de l'article contient" readonly="">
			  </fieldset>
			</div>
			<div class = "">  			
				<div class="form-group">
			      <label for="exampleSelect1" class="form-label mt-4">Catégorie</label>
			      <select class="form-select" id="exampleSelect1">
			        <option>Informatique</option>
			        <option>Ameublement</option>
			        <option>Vêtement</option>
			        <option>Sport&Loisirs</option>
			      </select>
		   		</div>
			</div>
			
			<div class = "col-8 offset-2"> 
				<div class = "row mt-5">
				<% for (Enchere enchere: encheres){%>
						<div class = "col-4">
							<div class="card text-white bg-primary mb-3" style="max-width: 20rem;">			
								  <div class="card-header card-header-link text-center">
								  	<a class="card-header-link" href="<%= request.getContextPath() %>/enchere/detailEnchere?article=<%= enchere.getArticleVendu().getNoArticle() %>&user=<%= enchere.getUtilisateur().getNoUtilisateur()%>">
								  		<h4><%= enchere.getArticleVendu().getNomArticle()%></h4>
								  	</a>
								  </div>
								  <div class="card-body">
								  	<div class="alert alert-dismissible alert-secondary"><img src="<%= request.getContextPath()%>/img/article_<%= enchere.getArticleVendu().getNoArticle() %>.png" alt="Image de l'article <%=enchere.getArticleVendu().getNoArticle()%>" width="255" height="150"></div>
								    <p class="card-text">prix : <%= enchere.getMontantEnchere() %> points</p>
	
								    <p class="card-text">Fin de l'enchère : <%=enchere.getArticleVendu().getDateFinEncheres().format(formatter)%></p>					    
	
								    <p class="card-text">vendeur : <a href="<%= request.getContextPath() %>/utilisateur/mon-compte/<%=enchere.getArticleVendu().getUtilisateur().getNoUtilisateur()%>"><%= enchere.getUtilisateur().getPseudo() %></a></p>
								  </div>
							</div>
						</div>
				<%}%>
				</div>
			</div>
		</form>
			
		</main>
	<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>
		

</body>
</html>