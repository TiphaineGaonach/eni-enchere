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

<% List<ArticleVendu> articleVendus = (List<ArticleVendu>) request.getAttribute("articleVendus"); %> 
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
			<div class = "col-8 offset-2">


				<form action="" method="POST">
					<div class = "row">  
						<div class="col-8">
							<h2>Filtres</h2>
							
							<input type="text" class="form-control" 
							id="motClef" name="motClef" pattern="[a-zA-Z0-9]+" value=""  placeholder=" le nom de l'article contient ">

							<div class= "row mt-3">
								<div class="col-2">
										Catégorie : 				
								</div>						
								<div class="form-group col-6 ">
								    <select class="form-select" id="categorie" name="categorie">
								    	
								    <% for (Categorie categorie: categories){%>
								        <option><%=categorie.getLibelle() %></option>
								    <%}%>	
								    </select>
								</div>
							</div>
							<div class= "row mt-3">
								<div class="col">
									<h5>Achats :</h5>
									<div class="row ">
										<div class="col-8">
											Enchère ouverte : 				
										</div>
										<div class="col-2">
											<input type="radio" name="boutonActif" value="achatOuvert">				
										</div>
									</div>	
									<div class="row ">
										<div class="col-8">
											Mes enchères en cours :				
										</div>
										<div class="col-2">
											<input type="radio" name="boutonActif" value="achatEnCours">				
										</div>
									</div>
									<div class="row ">
										<div class="col-8">
											Mes enchères reportées :				
										</div>
										<div class="col-2">
											<input type="radio" name="boutonActif" value="achatRemporter">				
										</div>
									</div>
								</div>
								<div class="col">
									<h5>Mes Ventes :</h5>
									<div class="row ">
										<div class="col-8">
											Mes ventes en cours :			
										</div>
										<div class="col-2">
											<input type="radio" name="boutonActif" value="VenteEnCours">				
										</div>
									</div>	
									<div class="row ">
										<div class="col-8">
											Mes ventes non débutées :			
										</div>
										<div class="col-2">
											<input type="radio" name="boutonActif" value="VenteNonDebuter">				
										</div>
									</div>
									<div class="row ">
										<div class="col-8">
											Mes ventes terminée : 				
										</div>
										<div class="col-2">
											<input type="radio" name="boutonActif" value="VenteTerminer">				
										</div>
									</div>
								</div>				
							</div> 
							
							
						</div>
						<div class="col-4" style= "margin-top: 40px;">
							<button type="submit" class="btn btn-primary mt-3 col-4" >Rechercher</button>
						</div>
					</div>
				</form>
		
			 
				<div class = "row mt-5">
				<% for (ArticleVendu articleVendu: articleVendus){%>
						<div class = "col-4">
							<div class="card text-white bg-primary mb-3" style="max-width: 20rem;">			
								  <div class="card-header card-header-link text-center">
<%-- 								  	<a class="card-header-link" href="<%= request.getContextPath() %>/enchere/detailEnchere?article=<%= enchere.getArticleVendu().getNoArticle() %>&user=<%= enchere.getUtilisateur().getNoUtilisateur()%>"> --%>
								  	<a class="card-header-link" href="<%= request.getContextPath() %>/enchere/detailEnchere?article=<%= articleVendu.getNoArticle() %>">
								  		<h4><%= articleVendu.getNomArticle()%></h4>
								  	</a>
								  </div>
								  <div class="card-body">
								  	<div class="alert alert-dismissible alert-secondary"><img src="<%= request.getContextPath()%>/img/article_<%= articleVendu.getNoArticle() %>.png" alt="Image de l'article <%=articleVendu.getNoArticle()%>" width="255" height="150"></div>
								    <p class="card-text">prix : <%= (articleVendu.getPrixVente()==0)?articleVendu.getMiseAPrix(): articleVendu.getPrixVente()%> points</p>
								    
	
								    <p class="card-text">Fin de l'enchère : <%=articleVendu.getDateFinEncheres().format(formatter)%></p>					    
	
								    <p class="card-text">vendeur : <a href="<%= request.getContextPath() %>/utilisateur/mon-compte/<%=articleVendu.getUtilisateur().getNoUtilisateur()%>"><%= articleVendu.getUtilisateur().getPseudo() %></a></p>
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