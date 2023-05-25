<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@page import="fr.eni.encheres.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% ArticleVendu article = (ArticleVendu) request.getAttribute("article"); %>
<% Utilisateur utilisateurConnecter = (Utilisateur) session.getAttribute("pseudo"); %>
<%int surenchere = (int) request.getAttribute("surenchere"); %>
<% String erreur = (String) request.getAttribute("erreur"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
<title>Detail Vente</title>
</head>
<body>
	
	<input type="hidden" name="no_article" value="<%= article.getNoArticle() %>">
						 			

	<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
	</header>
	
	<main>
		<h1 class="text-center"> D�tail Vente</h1>
					
						<% if (erreur!= null){ %> 
						<div class="col-3 offset-5">
							<div class=" alert alert-dismissible alert-danger">
								<p><%=erreur %></p>
							</div>
						</div>
						<%} %>
					
		
		<% if (article.getEtatVente()=='N') { %>
			<% if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> Vous avez cr�er cette article � vendre. il n'est pas encore en vente</h2>
			<% } %>	
		<% } %>
		
		<% if (article.getEtatVente()=='C') { %>
			<% if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> Vous vendez cet article</h2>
			<% } %>
			<% if (article.getUtilisateur().getNoUtilisateur()!=utilisateurConnecter.getNoUtilisateur()
					&& article.getEnchereMax().getUtilisateur().getNoUtilisateur() ==utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> Vous avez la meilleur ench�re sur cet article</h2>
			<% } %>
		<% } %>
		
		<% if (article.getEtatVente()=='T') { %>
			<% if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()
				&& article.getEnchereMax().getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> L'article n'a pas �t� vendu</h2>
			<% } %>
			<% if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()
				&& article.getEnchereMax().getUtilisateur().getNoUtilisateur()!=utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> L'article a �t� vendu!</h2>
			<% } %>
			<% if (article.getEnchereMax().getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> Vous avez remporter l'ench�re</h2>
			<% } %>
		<% } %>
		
		<% if (article.getEtatVente()=='R') { %>
			<% if (article.getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> l'article � �t� retirer</h2>
			<% } %>
			<% if (article.getEnchereMax().getUtilisateur().getNoUtilisateur()==utilisateurConnecter.getNoUtilisateur()) { %>
					<h2 class="text-center"> Vous avez retir� cette article</h2>
			<% } %>
		<% } %>
		
		
		
		
		
		<div >
<!-- 		//col-l-10 offset-l-1	col-xl-8 offset-xl-2	col-xxl-6 offset-xxl-3 mt-4 -->
			

				
				<div class="row ">

					<div class="col-3 offset-1 ">
				    	<img class="img-thumbnail" src="<%= request.getContextPath()%>/img/article_<%= article.getNoArticle() %>.png" alt="Image de l'article <%=article.getNoArticle()%>">
				 	</div>
					<div class=" col-6 offset-1 ">
						<div class=" row mt-4">
							<div class="col-4 col-xxl-2">
								Article : 				
							</div>
							<div class="col-8">
								${article.nomArticle}
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4 col-xxl-2">
								Description : 				
							</div>
							<div class="col-8">
								${article.description}
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4 col-xxl-2">
								Cat�gorie : 				
							</div>						
							<div class="form-group col-8">
						    	${article.categorie.libelle}
						    </div>	
						</div>
						
						<div class=" row mt-4">
							<div class="col-4 col-xxl-2">
								Meilleur Offre : 				
							</div>
							<div class="form-group col-8">
						    	${article.prixVente} par ${article.enchereMax.utilisateur.pseudo }
						    </div>
							
						</div>
						<div class=" row mt-4">
							<div class="col-4 col-xxl-2">
								Mise � prix : 				
							</div>
							<div class="form-group col-8">
						    	${article.miseAPrix} 
						    </div>
							
						</div>
						
						<div class=" row mt-4">
							<div class="col-4 col-xxl-2">
								Fin de l'ench�re : 				
							</div>
							<div class="form-group col-8">
						    	${article.dateFinEncheres}
						    </div>
						</div>
						
						<div class="card text-white bg-primary mb-3 mt-4 col-12 col-xxl-8" >			
								<div class="card-header text-center"><h3>Retrait</h3></div>
								<div class="card-body">	
									<div class=" row mt-4">
										<div class="col-4 col-xxl-3">
											Rue : 				
										</div>
										<div class="form-group col-8">
									    	${article.retrait.rue}
									    </div>
									</div>
									<div class=" row mt-4">
										<div class="col-4 col-xxl-3" >
											Code postal :			
										</div>
										<div class="form-group col-8">
									    	${article.retrait.codePostal}
									    </div>
									</div>
									<div class=" row mt-4">
										<div class="col-4 col-xxl-3">
											Ville :			
										</div>
										<div class="form-group col-8">
									    	${article.retrait.ville}
									    </div>
									</div>			
						 		</div>
						</div>	
						
						
						<div class=" row mt-4">
							<div class="col-4 col-xxl-2">
								Vendeur : 				
							</div>
							<div class="form-group col-8">
						    	${article.utilisateur.pseudo}
						    </div>
						</div>
						<form action="" method ="POST" class="mt-4 row ">
									<div class=" row mt-4">
										<div class="col-4 col-xxl-2">
											<label for="enchere" >Ma proposition :</label>				
										</div>
										<div class="form-group col-2">
											<input type="hidden" name="no_article" value="<%= article.getNoArticle() %>">
									    	<select  id="enchere" name="enchere">			
									    		<option  value="<%= surenchere %>"><%= surenchere %></option>
									    			<% for (int i = surenchere; i <= 9989; i += 10) { %>
									      				<option value="<%= i +10 %>"><%= i +10 %></option>
									    			<% } %>
									  		</select>
									    </div>
									    <div class="form-group col-4">
									    	<button type="submit">Ench�rir</button>
									    </div>
									</div>	
						
						
						 	
						  
						</form>
											
					</div>
				</div>	
					
				
		
		
		
		</div>
		
		
	
	</main>
	
	

</body>
</html>