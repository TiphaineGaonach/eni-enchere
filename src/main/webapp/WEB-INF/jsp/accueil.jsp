<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="fr.eni.encheres.bll.EnchereManager"%>
<%@page import="fr.eni.encheres.bo.Enchere"%>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@page import="fr.eni.encheres.bo.Categorie"%>
<%@page import = "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% List<Enchere> encheres = (List<Enchere>) request.getAttribute("encheres"); %> 
<% List<Categorie> categories = (List<Categorie>) request.getAttribute("categories"); %>  


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
		<div><h1 style="color:pink;">BONJOUR GAUTHIER. NOUS TE SURVEILLONS. (merci pour les pains au choc mais on en veut d'autres)</h1></div>
		<form action="">
			<div class = "row">  
				<div class="col-8">
					<h2>Filtres</h2>
					<input type="text" class="form-control" 
					id="motClef" name="motClef" pattern="[a-zA-Z0-9]+" value=""  placeholder=" le nom de l'article contien ">
					<div class="col-4">
							Catégorie : 				
					</div>						
					<div class="form-group col-8">
					    <select class="form-select" id="categorie" name="categorie">
					    	<option>test</option>
					    <% for (Categorie categorie: categories){%>
					        <option><%=categorie.getLibelle() %></option>
					    <%}%>	
					    </select>
					</div>
				
				</div>

		</form>
		
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
		
			
		</main>
	<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>
		

</body>
</html>