<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% ArticleVendu article = (ArticleVendu) request.getAttribute("article"); %>
<%int surenchere = (int) request.getAttribute("surenchere"); %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
<title>Detail Vente</title>
</head>
<body>

	<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
	</header>
	
	<main>
		<h1 class="text-center"> Détail Vente</h1>
		
		<div class="container	col-12  		col-xxl-8 offset-xxl-2">
			<div class="row">
				<div class="col-4">
				<div class="alert alert-dismissible alert-secondary"><img src="#" alt="Image de l'article "></div>
				
				</div>
				<form action="" method="POST" >
					<div class=" col-8">
						<div class=" row mt-4">
							<div class="col-4">
								Article : 				
							</div>
							<div class="col-8">
								${article.nomArticle}
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Description : 				
							</div>
							<div class="col-8">
								${article.description}
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Catégorie : 				
							</div>						
							<div class="form-group col-8">
						    	${article.categorie.libelle}
						    </div>	
						</div>
						
						<div class=" row mt-4">
							<div class="col-4">
								Meilleur Offre : 				
							</div>
							<div class="form-group col-8">
						    	${article.prixVente} par ${article.enchereMax.utilisateur.pseudo }
						    </div>
							
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Mise à prix : 				
							</div>
							<div class="form-group col-8">
						    	${article.miseAPrix} 
						    </div>
							
						</div>
						
						<div class=" row mt-4">
							<div class="col-4">
								Fin de l'enchère : 				
							</div>
							<div class="form-group col-8">
						    	${article.dateFinEncheres}
						    </div>
						</div>
						
						<div class="card text-white bg-primary mb-3 mt-4 col-12" >			
								<div class="card-header text-center"><h3>Retrait</h3></div>
								<div class="card-body">	
									<div class=" row mt-4">
										<div class="col-4">
											Rue : 				
										</div>
										<div class="form-group col-8">
									    	${article.retrait.rue}
									    </div>
									</div>
									<div class=" row mt-4">
										<div class="col-4">
											Code postal :			
										</div>
										<div class="form-group col-8">
									    	${article.retrait.codePostal}
									    </div>
									</div>
									<div class=" row mt-4">
										<div class="col-4">
											Ville :			
										</div>
										<div class="form-group col-8">
									    	${article.retrait.ville}
									    </div>
									</div>			
						 		</div>
						</div>	
						
						
						<div class=" row mt-4">
							<div class="col-4">
								Vendeur : 				
							</div>
							<div class="form-group col-8">
						    	${article.utilisateur.pseudo}
						    </div>
						</div>
											
					</div>
				</form>	
			</div>	
		
		
		
		</div>
		
		
	
	</main>
	
	
	
	
<div class="row">
  <div class="col-md-3 offset-md-1">
    <img src="<%= request.getContextPath()%>/img/article_<%= article.getNoArticle() %>.png" alt="Image de l'article <%=article.getNoArticle()%>">
  </div>
  <div class="col-md-7">
    <div class="text-center">
      <h3><span style="color:red; font-weight:bold;">Formulaire à créer</span></h3>
      <p><%= article.getNomArticle() %></p>
      <p>Description : <%= article.getDescription() %> </p>
      <p>Catégorie : <span style="color:red; font-weight:bold;">A CREER </span></p>

      <p>Retrait: <span style="color:red; font-weight:bold;">A CREER </span> </p>
      <%-- <p>Vendeur: <%= enchere.getArticleVendu().getUtilisateur().getPseudo() %><span style="color:red; font-weight:bold;"> REQUETE A CREER</span> </p> --%>
      
	  	<form action="" method ="POST">
	  				<p> champ caché ! il y a cet id dedans ! <%= article.getNoArticle() %></p>
		 				<input type="hidden" name="no_article" value="<%= article.getNoArticle() %>">
		 			<p> fin champ caché</p>
		 	<label for="enchere">Ma proposition :</label>		 		
		 		<select id="enchere" name="enchere">

		    		<option value="<%= surenchere %>"><%= surenchere %></option>
		    			<% for (int i = surenchere; i <= 9989; i += 10) { %>
		      				<option value="<%= i +10 %>"><%= i +10 %></option>
		    			<% } %>
		  		</select>
		  		  		
		  	<button type="submit">Enchérir</button>
		  
		</form>



      
      <p></p>
    </div>
  </div>
</div>
	

</body>
</html>