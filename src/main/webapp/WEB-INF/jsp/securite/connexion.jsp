<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% Utilisateur utilisateur; %>
<% String erreur = (String) request.getAttribute("erreur"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
<title>Connexion</title>
</head>
<body>


	<!----------------------- HEADER / NAVBAR ----------------------->
	<%@ include file ="/WEB-INF/jsp/part/menu.jsp" %>

	<!----------------------- MAIN ----------------------->

	<main>
	<div class=" col-8 offset-2 col-md-4 offset-md-4">
		<h1>Connexion</h1>
		<form action="" method="post">
		
			<div class="row">
				<div>
					<label class="col-4">Pseudo : </label>
					<input class="col-6" type = "text" name = "pseudo">
				</div>
				
				<div>
					<label class="col-4">Mot de passe : </label>
					<input class="col-6" type = "password" name = "motDePasse">
				</div>
			</div>
			
			<div class="row">
				<div class="col-4">
					<button type = "submit" class="btn btn-primary mt-3 ">Connexion</button>
				</div>
				<div class="col-8 ">
					<div class="form-check">
					        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
					        <label class="form-check-label" for="flexCheckDefault"> Se souvenir de moi -> iteration 2</label>
				     </div>
				     <div><a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3" >Mot de passe oublier -> iteration 2</a></div>
				</div>

			</div>
			
			<a href="<%= request.getContextPath() %>/ajouterUtilisateur" class="btn btn-primary mt-3 col-12" >Créer un Compte </a>
		
		
		
		
		
		
		
		
			
				
				<button type = "submit" class="btn btn-primary mt-3">Connexion</button>
				
				
				
			</form> 
			      
		      
		  
		   					<div class=" col-md-5 mx-auto py-5" >
<!-- 						    	<button type="submit" class="btn btn-primary mt-3">Créer l'utilisateur</button> -->
<%-- 						    	<a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3" >Mot de passe oublié -> iteration 2</a> --%>
						    	<a href="<%= request.getContextPath() %>/ajouterUtilisateur" class="btn btn-primary mt-3" >Créer un Compte </a>
						    </div>

		   	
 		   		<%	
 		   		if (erreur!= null){ %> 
 				<p><%=erreur %></p>
 				<%} %> 
		
	
		</div>
	</main>
	<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>