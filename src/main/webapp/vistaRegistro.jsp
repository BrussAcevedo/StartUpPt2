<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrarse</title>
<%@include file="assets/html/importHead.html"%>
<link rel="stylesheet" href="assets/css/stylesVistaFormulario.css">

</head>
<body>

	<%@include file="assets/html/navbar.html"%>
<div class="contenedor-form container">
	<form action="RegistroControlador" method="post">
		<div class="row container content">

			<h4 class="py-3">Registro de usuario:</h4>

			<div class="col-12 mb-2">
				<p>Ingresa tu correo electrónico</p>
				<input class="form-control" type="text"
					placeholder="ejemplo@mail.com" aria-label="Correo" name="correoTxt">
			</div>
			<div class="col-12 mb-2">
				<p>Ingresa tu contraseña</p>
				<input class="form-control" type="password" placeholder=""
					aria-label="Contraseña" name="passwordTxt">
			</div>

			<p class="pt-3">Datos personales:</p>
			<div class="col-4 mb-2">
				<p>Nombre</p>
				<input class="form-control" type="text" placeholder="Nombre"
					aria-label="ej: Juan" name="nombreTxt">
			</div>
			<div class="col-4 mb-2">
				<p>Nick</p>
				<input class="form-control" type="text" placeholder="Nick"
					aria-label="Nick" name="nickTxt">
			</div>
			<div class="col-4 mb-2">
				<p>Ingresa tu peso actual</p>
				<input class="form-control" type="text" placeholder="kg"
					aria-label="Peso" name="pesoTxt">

			</div>



			<p class="pt-3">Direccion:</p>
			<div class="col-10 mb-2">
				<p>Ingresa el nombre de la calle</p>
				<input class="form-control" type="text" placeholder="ej: pasaje uno"
					aria-label="Calle" name="calleTxt">
			</div>

			<div class="col-2 mb-2">
				<p>Número:</p>
				<input class="form-control" type="text" placeholder="ej: 54"
					aria-label="Numeración" name="numeracionTxt">
			</div>

			<div class="botonFormulario">
				<button type="submit" class="btn btn-primary w-100" name="submit">Enviar</button>

			</div>
		</div>
	</form>

</div>





	<%@include file="assets/html/footer.html"%>
	<%@include file="assets/html/importFooter.html"%>
</body>
</html>