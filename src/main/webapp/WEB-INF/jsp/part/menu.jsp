<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%
	String [][] menu = {
			
			
			{"Liste des ench�res","/"},
			
			
	};

	String [][] menuNonConnecter = {
		
		
		{"Se connecter - S'inscrire","/utilisateur/connexion"},
		
		
		
	};

	String [][] menuConnecter = {
		
		
		{"Mes Ench�res","/"},
		
		{"Vendre un Article","/enchere/ajouterEnchere"},
		{"Mon Profil","/utilisateur/mon-compte/"},
		{"D�connexion","/utilisateur/deconnexion"}
		
		
};
%>
			<nav class="navbar navbar-expand-lg navbar-dark bg-primary" style="padding-right: 20px; padding-left: 20px;">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="<%=request.getContextPath()%>">
			    <img alt="Trocencheres.fr" width="60" src="<%=request.getContextPath() %>/img/logoMarteau.png">
			    </a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    
			    <div class="collapse navbar-collapse" id="navbarColor01">
			      <ul class="navbar-nav ms-auto" style="font-size: 20px;">
			        
			        
			        <% for(String[] item : menu ){%>
			        <li class="nav-item">
			          <a class="nav-link" href="<%= request.getContextPath()+item[1]%> "><%= item[0] %></a>
			        </li>
			        <% } %>
			        
			        <% if(session.getAttribute("pseudo")==null){
			        
				        for(String[] item : menuNonConnecter ){%>
				        <li class="nav-item">
				          <a class="nav-link" href="<%= request.getContextPath()+item[1]%> "><%= item[0] %></a>
				        </li>
				      <% } } %>
				       
				   <%  if(session.getAttribute("pseudo")!=null){
			        
				        for(String[] item : menuConnecter ){%>
				        <li class="nav-item">
				          <a class="nav-link" href="<%= request.getContextPath()+item[1]%> "><%= item[0] %></a>
				        </li>
				       
			       <% } } %>
			        
			      </ul>
			    </div>
			  </div>
			</nav>

