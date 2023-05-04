<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
<title>Connexion</title>
</head>
<body>


	<!----------------------- HEADER / NAVBAR ----------------------->
	<%@ include file ="/WEB-INF/jsp/part/navBarSansMenu.jsp" %>

	<!----------------------- MAIN ----------------------->

	<main>
	
	<h1>Connexion</h1>
		<form method="post">
			<div>
<%-- 				<% if (utilisateur == null){ %> --%>
<!-- 				<p>Pseudo ou mot de passe invalide</p> -->
<%-- 				<%} %> --%>
				<label>Pseudo</label>
				<input type = "text" name = "pseudo">
			</div>
			
			<div>
				<label>Mot de passe</label>
				<input type = "password" name = "motDePasse">
			</div>
			
			<button type = "submit">Connexion</button>
			
			<fieldset class="form-group">
		      <legend class="mt-4"></legend>
			      <div class="form-check">
			        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
			        <label class="form-check-label" for="flexCheckDefault">
			          Se souvenir de moi
			        </label>
			      </div>
		      <a href= "">Mot de passe oublié</a>
		    </fieldset>
		   	<button type = "submit">Créer un compte</button>
		</form>
	
	
	</main>
	<!----------------------- FOOTER ----------------------->
		<%@ include file ="/WEB-INF/jsp/part/footer.jsp" %>

</body>
</html>