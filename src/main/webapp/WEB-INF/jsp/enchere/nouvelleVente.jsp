<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni.encheres.bo.Categorie"%>
<% List<Categorie> categories = (List<Categorie>) request.getAttribute("categories"); %> 
<% String erreur = (String) request.getAttribute("erreur"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<%@ include file ="/WEB-INF/jsp/part/metaLink.jsp" %>
<title>Nouvelle Vente</title>
</head>
<body>
	<header class="row">
		<%@ include file="/WEB-INF/jsp/part/menu.jsp" %>
	</header>
	<main>
		<h1 class="text-center mt-4"> Nouvelle vente</h1>
		
		<div class="container	col-12  col-l-10 offset-l-1	col-xl-8 offset-xl-2	col-xxl-6 offset-xxl-3 mt-4">
			<div class="row">
				<div class="col-8 offset-2">
					<%	
				   	if (erreur!= null){ %> 
					<p><%=erreur %></p>
					<%} %>
				</div>
				<form action="" method="POST" >
					<div class=" col-12">
						<div class=" row mt-4">
							<div class="col-4">
								Article : 				
							</div>
							<div class="col-8">
								<input type="text" class="form-control" 
								id="nomArticle" name="nomArticle" value=""  placeholder="">						
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Description : 				
							</div>
							<div class="col-8">
								<textarea type="text" class="form-control" 
								id="description" name="description" value=""  placeholder=""></textarea>						
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Catégorie : 				
							</div>						
							<div class="form-group col-8">
						    	<select class="form-select" id="categorie" name="categorie">
						    		
						    	<% for (Categorie categorie: categories){%>
						        	<option><%=categorie.getLibelle() %></option>
						        <%}%>	
						    	</select>
						    </div>	
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Photo de l'article : 				
							</div>
							<div class="col-8">
								 <input class="form-control" type="file" id="formFile">						
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Mise à prix : 				
							</div>
							<div class="col-8">
								<input type="text" class="form-control" 
								id="miseAPrix" name="miseAPrix" pattern="[0-9]+" value=""  placeholder="">
								<span class="error">Le prix ne peut être composé que de chiffres</span>						
							</div>
<!-- 							<div class="form-group col-8"> -->
<!-- 						    	<select class="form-select " id="miseAPrix" name ="miseAPrix" size="4"> -->
<%-- 						    		<% for (int i = 0; i < 100; i++) {%> --%>
<%-- 						        	<option><%=i %></option> --%>
<%-- 						        	<%}%> --%>
						        	
<!-- 						    	</select> -->
<!-- 						    </div> -->
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Début de l'enchère : 				
							</div>
							<div class="col-8">
								<input type="text" class="form-control" 
								id="dateDebutEncheres" name="dateDebutEncheres" pattern="[0-9/]+" value="${currentDate}"  placeholder="jj/mm/aaaa">
								<span class="error">Format date : jj/mm/aaaa</span>							
							</div>
						</div>
						<div class=" row mt-4">
							<div class="col-4">
								Fin de l'enchère : 				
							</div>
							<div class="col-8">
								<input type="text" class="form-control" 
								id="dateFinEncheres" name="dateFinEncheres" pattern="[0-9/]+" value=""  placeholder="jj/mm/aaaa">	
								<span class="error">Format date : jj/mm/aaaa</span>					
							</div>
						</div>
						
						<div class="card text-white bg-primary mb-3 mt-4 col-12" >			
								<div class="card-header text-center"><h3>Retrait</h3></div>
								<div class="card-body">	
									<div class=" row mt-4">
										<div class="col-4">
											Rue : 				
										</div>
										<div class="col-8">
											<input type="text" class="form-control" 
											id="rue" name="rue" pattern="[a-zA-Z0-9 ]+" value="${pseudo.rue }"  placeholder="">						
										</div>
									</div>
									<div class=" row mt-4">
										<div class="col-4">
											Code postal :			
										</div>
										<div class="col-8">
											<input type="text" class="form-control" 
											id="codePostal" name="codePostal" pattern="[a-zA-Z0-9]+" value="${pseudo.codePostal }"  placeholder="">						
										</div>
									</div>
									<div class=" row mt-4">
										<div class="col-4">
											Ville :			
										</div>
										<div class="col-8">
											<input type="text" class="form-control" 
											id="ville" name="ville" pattern="[a-zA-Z0-9]+" value="${pseudo.ville }"  placeholder="">						
										</div>
									</div>			
						 		</div>
						</div>	
						
						
						<div  >
							<button type="submit" class="btn btn-primary mt-3 col-4" >Créer la vente</button>
							<a href="" class="btn btn-primary mt-3 col-4 offset-2 " >Annuler</a>
						</div>
											
					</div>
				</form>	
			</div>	
		
		
		
		</div>
		
		
	
	</main>

</body>
</html>