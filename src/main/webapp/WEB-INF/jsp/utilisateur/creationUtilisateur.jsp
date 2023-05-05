<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			
<!-- 			Gestion des erreures -->
<%-- 				<%  if( erreurs!=null ) for(String erreur : erreurs){ %> --%>
<!-- 					<div class="alert alert-danger"> -->
<%-- 						<%= erreur %> --%>
<!-- 					</div>	 -->
<%-- 				<% } %> --%>
								
						<form action="" method="POST" >

								<div class="container ">

									<div class="row">								
										<div class="form-group col-md-6 col-12 " >
											<label for="title" class="col-form-label mt-4">pseudo</label>
											<input type="text" class="form-control" 
											id="pseudo" name="pseudo" value="${pseudo}"  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">nom</label>
											<input type="text" class="form-control" 
											id="nom" name="nom" value=""  placeholder="">  
										</div>
									</div>	
										
									<div class="row">	
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">pénom</label>
											<input type="text" class="form-control" 
											id="penom" name="penom" value=""  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">email</label>
											<input type="email" class="form-control" 
											id="email" name="email" value=""  placeholder="">  
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">téléphone</label>
											<input type="text" class="form-control" 
											id="telephone" name="telephone" value=""  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">rue</label>
											<input type="text" class="form-control" 
											id="rue" name="rue" value=""  placeholder="">  
										</div>
									</div>
										
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">codePostal</label>
										  	<input type="text" class="form-control" 
										  	id="codePostal" name="codePostal" value=""  placeholder="">  
										</div>
											<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">ville</label>
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