<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%-- <% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %> --%>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
	<title>Mon compte</title>
</head>


<body>
	<!----------------------- HEADER / NAVBAR ----------------------->
	<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
	</header>
	
	<!----------------------- MAIN ----------------------->
	<main>
	
			<!------------------- DETAIL ------------------->
		
			<div class = "row mt-5 col-8 offset-2	col-sm-4 offset-sm-4	col-md-4 offset-md-4 ">
				<h1 class="text-center"> Mon Profil</h1>
							
				
							<div class="container	col-10 offset-1  col-xl-8 offset-xl-2		col-xxl-6 offset-xxl-3">

									<div class="row">								
										<div class="form-group col-md-6 col-12 " >
											Pseudo : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.pseudo }  
										</div>
									</div>	
										
									<div class="row">	
										<div class="form-group col-md-6 col-12">
											nom : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.nom }  
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											prénom : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.prenom } 
										</div>
									</div>
										
									<div class="row">
										<div class="form-group col-md-6 col-12">
											email : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.email } 
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											Téléphone : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.telephone }
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											Rue : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.rue }
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											Code Postal : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.codePostal } 
										</div>
									</div>
									
									<div class="row">
										<div class="form-group col-md-6 col-12">
											Ville : 
										</div>
										<div class="form-group col-md-6 col-12">
											${pseudo.ville }
										</div>
									</div>
																								
									
									<div class=" " >
								    	
								    	<a href="<%= request.getContextPath() %>/utilisateur/modifierMonCompte" class="btn btn-primary mt-3 col-12 " >Modifier l'utilisateur</a>
								    </div>
								    
								    
								</div>
								
			
			<!-------------- BOUTONS -------------->
						

				
				
				
			</div>
	
	</main>

<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>