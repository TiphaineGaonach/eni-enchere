<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel = "stylesheet" type = "text/css" href = "<%= request.getContextPath()%>/assets/css/bootstrap.min.css">
	<link rel = "stylesheet" type = "text/css" href = "<%= request.getContextPath()%>/assets/css/style.css">
<title>Connexion</title>
</head>
<body>

<!----------------------- HEADER / NAVBAR ----------------------->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">TrocEncheres</a>
   
    <div class="collapse navbar-collapse" id="navbarColor01">
    </div>
  </div>
</nav>

	<!----------------------- MAIN ----------------------->

<main>

<h1>Connexion</h1>
	<form method="post">
		<div>
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




</body>
</html>