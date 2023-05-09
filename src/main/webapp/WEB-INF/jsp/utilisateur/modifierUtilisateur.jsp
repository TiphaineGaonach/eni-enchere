<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>   
    

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
	<title>Modifier l'utilisateur</title>
</head>



<body>

	<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
	</header>

	<main class="row mt-5">
		<div class="row text-center">
				<h1>Modification de  l'utilisateur </h1>
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
											<label for="title" class="col-form-label mt-4">Pseudo</label>
											<input type="text" class="form-control" 
											id="pseudo" name="pseudo" pattern="[a-zA-Z0-9]+"  value="${pseudo.pseudo}"  placeholder="">
											<span class="error">Le pseudo ne doit comporter que des lettres et des chiffres</span> 
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Nom</label>
											<input type="text" class="form-control" 
											id="nom" name="nom" value="${pseudo.nom}"  placeholder="">  
										</div>
									</div>	
										
									<div class="row">	
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Prénom</label>
											<input type="text" class="form-control" 
											id="prenom" name="prenom" value="${pseudo.prenom}"  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Email</label>
											<input type="email" class="form-control" 
											id="email" name="email" value="${pseudo.email}"  placeholder="">  
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Téléphone</label>
											<input type="text" class="form-control" 
											id="telephone" name="telephone" value="${pseudo.telephone}"  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Rue</label>
											<input type="text" class="form-control" 
											id="rue" name="rue" value="${pseudo.rue}"  placeholder="">  
										</div>
									</div>
										
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Code Postal</label>
										  	<input type="text" class="form-control" 
										  	id="codePostal" name="codePostal" value="${pseudo.codePostal}"  placeholder="">  
										</div>
											<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Ville</label>
										  	<input type="text" class="form-control" 
										  	id="ville" name="ville" value="${pseudo.ville}"  placeholder="">  
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Mot de passe actuel</label>
											<input type="password" class="form-control" 
											id="ancienMotDePasse" name="ancienMotDePasse" value="${pseudo.motDePasse}"  placeholder="">  
										</div>		
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<label for="title" class="form-label mt-4">Nouveau mot de passe</label>
											<input type="password" class="form-control" 
											id="motDePasse" name="motDePasse" value="${pseudo.motDePasse}"  placeholder="">  
										</div>
										<div class="form-group col-md-6 col-12">
									  		<label for="title" class="form-label mt-4">Confirmation</label>
											<input type="password" class="form-control" 
											id="confirmation" name="confirmation" value="${pseudo.motDePasse}"  placeholder="">  
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											<p class="form-label mt-4">Crédit : ${pseudo.credit }</p> 
										</div>		
									</div>
									
									
									
									
									
									<div class="row mt-5 text-center py-5 d-flex justify-content-center" >
								    	<button type="submit" class="btn btn-primary mt-3 mx-2 col-2 offset-3" >Enregistrer</button>
								    	<a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3 mx-2 col-2 offset-2 " >Annuler</a>
								    	<a onclick="return confirm('Confirmer la suppression?');"
								    		href = "<%= request.getContextPath()%>/utilisateur/suprimerMonCompte" 
								    		class = "btn btn-primary mt-3 mx-2 col-2 offset-1" >Supprimer mon compte</a>
								    </div>
								    
								    
								</div>
								

						</form>
						
				
	</main>
	

<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>
</body>
</html>