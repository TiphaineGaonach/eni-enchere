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
	<div class=" col-8 offset-2 	col-md-6 offset-md-3 	col-ig-4 offset-ig-4 	">
		<h1 class="mt-5 text-center">Connexion</h1>
		<form action="" method="post">
		
			<div class="row mt-5">
				<div>
					<label class="col-4 	col-xxl-2 offset-xxl-2 	">Pseudo : </label>
					<input class="col-6 	col-xxl-4 offset-xxl-1	" type = "text" name = "pseudo">
				</div>
				
				<div class="mt-2">
					<label class="col-4 	col-xxl-2 offset-xxl-2">Mot de passe : </label>
					<input class="col-6		col-xxl-4 offset-xxl-1" type = "password" name = "motDePasse">
				</div>
			</div>
			
			<div class="row mt-5">
				<div class="col-4 	col-xxl-2 offset-xxl-2">
					<button type = "submit" class="btn btn-primary mt-3 ">Connexion</button>
				</div>
				<div class="col-8 	col-xxl-6 offset-xxl-1">
					<div class="form-check">
					        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
					        <label class="form-check-label" for="flexCheckDefault"> Se souvenir de moi -> iteration 2</label>
				     </div>
				     <div ><a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3" >Mot de passe oublier -> iteration 2</a></div>
				</div>

			</div>
			
			<a class="mt-5 btn btn-primary mt-3 col-12 		col-xl-10 offset-xl-1		col-xxl-8 offset-xxl-2 " href="<%= request.getContextPath() %>/ajouterUtilisateur"  >Créer un Compte </a>
		
		
		
		
		
		
		
		
			
				
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