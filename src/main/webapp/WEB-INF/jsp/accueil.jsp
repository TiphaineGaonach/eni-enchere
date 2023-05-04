<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@page import = "java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<ArticleVendu> articleVendus = (List<ArticleVendu>) request.getAttribute("articleVendus"); 
%>      

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
	<!-- 			<div class = "row mt-5"> -->
	<%-- 			<% for (ArticleVendu articleVendu: articleVendus){%> --%>
	<!-- 					<div class = "col-4"> -->
	<!-- 						<div class="card text-white bg-primary mb-3" style="max-width: 20rem;">			 -->
	<%-- 						  <div class="card-header"><%= articleVendu.getNomArticle() %></div> --%>
	<!-- 						  <div class="card-body"> -->
	<%-- 						    <p class="card-text">Prix : <%=articleVendu.getMiseAPrix()%></p> --%>
	<%-- 						    <p class="card-text">Fin de l'enchère : <%=articleVendu.getDateFinEncheres()%></p> --%>
	<%-- 						    <p class="card-text">Vendeur : <%=articleVendu.getUtilisateur()%></p> --%>
	<!-- 						  </div> -->
	<!-- 						</div> -->
	<!-- 					</div> -->
	<%-- 			<%}%> --%>
	<!-- 			</div> -->
			</div>
		</form>
			
		</main>
	<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>
		

</body>
</html>