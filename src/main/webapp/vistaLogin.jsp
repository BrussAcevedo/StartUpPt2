<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Iniciar Sesion</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="./assets/img/favicon.ico">
<%@include file="./assets/html/importHead.html"%>
<link rel="stylesheet" href="assets/css/stylesLogin.css">

</head>

<body>

	<div class="contenedor">

		<form action="LoginControlador" method="post">
			<h1>LogIn</h1>



			<div class="inputBox inputBoxFixed">
				<input type="text" placeholder="Correo Electronico" name ="correoLoginTxt" required>
				<i class="fa-solid fa-user"></i> 
			</div>
			
			<div class="inputBox">
				<input type="password" placeholder="Contraseña" name ="passwordLoginTxt" required>
				<i class="fa-solid fa-key"></i>
			</div>

			<div class="remember-forgot">
				<label><input type="checkbox"> Recordar Contraseña </label>
				<a href="#">¿Olvidaste tu contraseña?</a>
			</div>
			<div class="boton">
				<button type="submit" name="action" value="enviar" class="btn">Iniciar Sesión</button>
			</div>


			<div class="registrar">
				<p>
					¿Aun no tienes cuenta? <a href="IndexControlador?action=registro">Registrarse</a>
				</p>
			</div>


		</form>
		
	<div class="col-12 d-block boton-atras d-flex pt-3">
		<div>
		<form action="IndexControlador" method="get">
			<button type="submit" name="action" value="inicio">
				HOME <i class="fa-solid fa-house"></i>
			</button>
		</form>
			</div>
							<%String usuarioIncorrectoMsj = (String)request.getAttribute("usuarioIncorrecto"); %>
		<%if(usuarioIncorrectoMsj != null){ %>
		<div class ="usuario-contraseña-error mx-0 my-0" style="width 200px;">
			<p>El correo y/o contraseña son incorrectas. Porfavor intentalo denuevo.</p>
		</div>
			
		<%} %>
	</div>


	</div>



	<%@include file="./assets/html/importFooter.html"%>


</body>
</html>