<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/Style.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="registration mx-auto d-block w-100">
		<div class="page-header text-center">
			<h1>Sign up</h1>
		</div>
		
		<form id="member-registration" action="" method="post" class="form-validate form-horizontal well" >
			<fieldset>
				<legend>User Registration</legend>
				<div class="form-group">
					<label for="exampleInputPassword1">Prénom *</label>
					<input type="text" class="form-control" name ="firstName" id="exampleInputPassword1">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Nom *</label>
					<input type="text" class="form-control" name="lastName" id="exampleInputPassword1">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Email *</label>
					<input type="email" class="form-control" name="email" id="exampleInputPassword1">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Nom d'utilisateur *</label>
					<input type="text" class="form-control" name="username" id="exampleInputPassword1">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Mot de passe *</label>
					<input type="password" class="form-control" name="password" id="exampleInputEmail1">
				</div>

				<div class="d-flex justify-content-between align-items-center mt-2">
					<div class="form-group d-flex justify-content-start">
						<button type="submit" class="btn btn-primary">S'inscrire</button>
					</div>
					<div class="form-check form-group d-flex justify-content-end">
						<a href="#">Sign in instead</a>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</div>
</body>
</html>