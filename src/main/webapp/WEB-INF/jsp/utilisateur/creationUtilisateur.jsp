<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String erreur = (String) request.getAttribute("erreur"); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
	<title>Création d'un utilisateur</title>
</head>
<body>
	<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
	</header>

	<main class="row mt-5">
			<div class="row text-center">
				<h1>Création d'un utilisateur </h1>
			</div>

			<div class="col-8 offset-2"></div>
			
			 	<%	
 		   		if (erreur!= null){ %> 
 				<p><%=erreur %></p>
 				<%} %> 
			
<!-- 			Gestion des erreurs -->

<%-- 				<%  if( erreurs!=null ) for(String erreur : erreurs){ %> --%>
<!-- 					<div class="alert alert-danger"> -->
<%-- 						<%= erreur %> --%>
<!-- 					</div>	 -->
<%-- 				<% } %> --%>

								
						<form action="" method="POST" >

								<div class="container ">

									<div class="row">								
										<div class="form-group col-md-6 col-12 " >
											<label for="title" class="col-form-label mt-4">Pseudo</label>
											<input type="text" class="form-control" 
											id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]+" value="${pseudo}"  placeholder="">  
											<span class="error">Le pseudo ne doit comporter que des lettres et des chiffres</span>
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Nom</label>
											<input type="text" class="form-control" 
											id="nom" name="nom" value=""  placeholder="">  
										</div>
									</div>	
										
									<div class="row">	
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Prénom</label>
											<input type="text" class="form-control" 
											id="prenom" name="prenom" value=""  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Email</label>
											<input type="email" class="form-control" 
											id="email" name="email" value=""  placeholder="">  
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Téléphone</label>
											<input type="text" class="form-control" 
											id="telephone" name="telephone" value=""  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Rue</label>
											<input type="text" class="form-control" 
											id="rue" name="rue" value=""  placeholder="">  
										</div>
									</div>
										
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Code Postal</label>
										  	<input type="text" class="form-control" 
										  	id="codePostal" name="codePostal" value=""  placeholder="">  
										</div>
											<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Ville</label>
										  	<input type="text" class="form-control" 
										  	id="ville" name="ville" value=""  placeholder="">  
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Mot De Passe</label>
											<input type="password" class="form-control" 
											id="motDePasse" name="motDePasse" value=""  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
									  		<label for="title" class="form-label mt-4">Confirmation</label>
											<input type="password" class="form-control" 
											id="confirmation" name="confirmation" value=""  placeholder="">  
										</div>
									</div>
									
									<div class=" row mt-5 text-center py-5" >
								    	<button type="submit" class="btn btn-primary mt-3 col-2 offset-3" >Créer l'utilisateur</button>
								    	<a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3 col-2 offset-2 " >Annuler</a>
								    </div>
								</div>
								
						</form>
			
		</main>
		
		<%@ include file="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>