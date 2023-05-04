<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
	<title>Modifier l'utilisateur</title>
</head>
<body>

	<main class="row mt-5">
			<div class="row text-center">
				<h1>Modification de l'utilisateur </h1>
			</div>
			<div class="col-8 offset-2"></div>
<!-- 			Gestion des erreures -->
<%-- 				<%  if( erreurs!=null ) for(String erreur : erreurs){ %> --%>
<!-- 					<div class="alert alert-danger"> -->
<%-- 						<%= erreur %> --%>
<!-- 					</div>	 -->
<%-- 				<% } %> --%>
				<div >
					<form action="" method="POST" >
						<div class="row col-md-10 offset-1 col-xl-10 offset-xl-2">
							<div class="col-md-6 ">
							
								<div class="form-group col-8 " >
								  <label for="title" class="col-form-label mt-4">pseudo</label>
								  <input type="text" class="form-control" 
								  id="pseudo" name="pseudo" value="${ pseudo.pseudo }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">penom</label>
								  <input type="text" class="form-control" 
								  id="penom" name="penom" value="${ pseudo.prenom }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">téléphone</label>
								  <input type="text" class="form-control" 
								  id="telephone" name="telephone" value="${ pseudo.telephone }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">codePostal</label>
								  <input type="text" class="form-control" 
								  id="codePostal" name="codePostal" value="${ pseudo.codePostal }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">Mot De Passe actuel</label>
								  <input type="text" class="form-control" 
								  id="motDePasse" name="motDePasse" value="${ pseudo.motDePasse }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">Nouveau mot de passe</label>
								  <input type="text" class="form-control" 
								  id="motDePasse" name="motDePasse" value="${ pseudo.motDePasse }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
									<p> Crédit : ${ pseudo.credit }</p>
								 </div>
							</div>
							
							<div class="col-md-6 ">
							
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">nom</label>
								  <input type="text" class="form-control" 
								  id="nom" name="nom" value="${ pseudo.nom }"  placeholder="ex. Tuto Spring">  
								</div>
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">email</label>
								  <input type="email" class="form-control" 
								  id="email" name="email" value="${ pseudo.email }"  placeholder="ex. Tuto Spring">  
								</div>
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">rue</label>
								  <input type="text" class="form-control" 
								  id="rue" name="rue" value="${ pseudo.rue }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">ville</label>
								  <input type="text" class="form-control" 
								  id="ville" name="ville" value="${ pseudo.ville }"  placeholder="ex. Tuto Spring">  
								</div>
								
								<div class="form-group col-8">
								  <label for="title" class="form-label mt-4">Confirmation</label>
								  <input type="text" class="form-control" 
								  id="confirmation" name="confirmation" value="${ pseudo.motDePasse }"  placeholder="ex. Tuto Spring">  
								</div>
								
							</div>
							
							<div class=" col-md-5 mx-auto py-5" >
						    	<button type="submit" class="btn btn-primary mt-3">Enregistrer</button>
						    	<a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3" >Annuler</a>
						    </div>
						</div>
						
<!-- 						<div class=" mx-auto" > -->
<!-- 					    	<button type="submit" class="btn btn-primary mt-3">Créer l'utilisateur</button> -->
<%-- 					    	<a href="<%= request.getContextPath() %>" class="btn btn-primary mt-3" >Annuler</a> --%>
<!-- 					    </div>			 -->
					</form>
				</div>
			</div>
		</main>
	

<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>
</body>
</html>