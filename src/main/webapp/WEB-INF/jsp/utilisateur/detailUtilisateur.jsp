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
		
			<div class = "row mt-5 text-center">
				<h1> Mon Profil</h1>
				<p>Pseudo : 		${pseudo.pseudo }</p>
				<p>nom : 			${pseudo.nom }</p>
				<p>prénom : 		${pseudo.prenom }</p>
				<p>émail : 			${pseudo.email }</p>
				<p>Téléphone : 		${pseudo.telephone }</p>
				<p>Rue : 			${pseudo.rue }</p>
				<p>Code Postal :	${pseudo.codePostal }</p>
				<p>Ville : 			${pseudo.ville }</p>
				

			
			<!-------------- BOUTONS -------------->
						

				
				<div class="row mt-5 text-center">
								
					<div class="col-2 offset-4" ><a href="<%= request.getContextPath() %>/utilisateur/modifierMonCompte" class="btn btn-info" >Modifier</a></div>
							
					<div class="col-2" ><a onclick="return confirm('Voulez-vous vraiment supprimer votre compte ?');"  href="<%= request.getContextPath() %>/utilisateur/suprimerMonCompte" class="btn btn-danger" >Supprimer</a></div>
				</div>
				
			</div>
	
	</main>

<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>