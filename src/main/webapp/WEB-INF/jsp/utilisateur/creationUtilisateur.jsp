<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel = "stylesheet" type = "text/css" href = "<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
	<link rel = "stylesheet" type = "text/css" href = "<%= request.getContextPath()%>/assets/css/style.css">
	<title>Création d'un utilisateur</title>
</head>
<body>
	<header class="row">
		<!-- 		Ajouter ici partie navBar -->
	</header>

	<main class="row mt-5">
			<div class="row text-center">
				<h1>Création d'un utilisateur</h1>
			</div>
			<div class="col-8 offset-2"></div>
<!-- 			Gestion des erreures -->
<%-- 				<%  if( erreurs!=null ) for(String erreur : erreurs){ %> --%>
<!-- 					<div class="alert alert-danger"> -->
<%-- 						<%= erreur %> --%>
<!-- 					</div>	 -->
<%-- 				<% } %> --%>
				<div class="col-8 offset-2">
					<form action="" method="POST" >
						<div class="row col-8 offset-2">
							<div class="col-md-6">
							
								<div class="form-group col-6" >
								  <label for="title" class="col-form-label mt-4">pseudo</label>
								  <input type="text" class="form-control" 
								  id="pseudo" name="pseudo" value=""  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">penom</label>
								  <input type="text" class="form-control" 
								  id="penom" name="penom" value=""  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">téléphone</label>
								  <input type="text" class="form-control" 
								  id="telephone" name="telephone" value=""  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">codePostal</label>
								  <input type="text" class="form-control" 
								  id="codePostal" name="codePostal" value=""  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">Mot De Passe</label>
								  <input type="text" class="form-control" 
								  id="motDePasse" name="motDePasse" value=""  placeholder="ex. Tuto Spring">  
								</div>
							</div>
							
							<div class="col-md-6">
							
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">nom</label>
								  <input type="text" class="form-control" 
								  id="nom" name="nom" value=""  placeholder="ex. Tuto Spring">  
								</div>
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">email</label>
								  <input type="email" class="form-control" 
								  id="email" name="email" value=""  placeholder="ex. Tuto Spring">  
								</div>
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">rue</label>
								  <input type="text" class="form-control" 
								  id="rue" name="rue" value=""  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">ville</label>
								  <input type="text" class="form-control" 
								  id="ville" name="ville" value=""  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-6">
								  <label for="title" class="form-label mt-4">Confirmation</label>
								  <input type="text" class="form-control" 
								  id="confirmation" name="confirmation" value=""  placeholder="ex. Tuto Spring">  
								</div>
								
							</div>
						</div>
						
						<div class="col-2 offset-4 text-center" >
					    	<button type="submit" class="btn btn-primary mt-3">Créer l'utilisateur</button>
					    	<a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3" >Annuler</a>
					    </div>			
					</form>
				</div>
			</div>
		</main>

</body>
</html>