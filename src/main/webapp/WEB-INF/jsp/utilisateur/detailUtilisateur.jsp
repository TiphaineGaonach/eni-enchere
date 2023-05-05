<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
    
    
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
				<p>Pseudo : <%= utilisateur.getPseudo() %></p>
				<p>Nom : <%= utilisateur.getNom() %></p>
				<p>Prénom : <%= utilisateur.getPrenom() %></p>
				<p>Email : <%= utilisateur.getEmail() %></p>
				<p>Téléphone : <%= utilisateur.getTelephone() %></p>
				<p>Rue : <%= utilisateur.getRue() %></p>
				<p>Code Postal : <%= utilisateur.getCodePostal() %></p>
				<p>Ville : <%= utilisateur.getVille() %></p>
			
			<!-------------- BOUTONS -------------->
						
				<div>
				<a href = "<%= request.getContextPath()%>/utilisateur/modifierMonCompte/<%= utilisateur.getNoUtilisateur() %>" class = "btn btn-info" >Modifier</a>
				<a href = "<%= request.getContextPath()%>/utilisateur/suprimerMonCompte" class = "btn btn-info" >Supprimer</a>
				</div>
				
			</div>
	
	</main>

<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>