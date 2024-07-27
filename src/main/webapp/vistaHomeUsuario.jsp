<%@page import="cl.desafioLatam.servicios.ServicioDireccion"%>
<%@page import="cl.desafioLatam.servicios.ServicioRolUsuario"%>
<%@page import="cl.desafioLatam.DTO.RolUsuarioDTO"%>
<%@page import="cl.desafioLatam.DTO.DireccionDTO"%>
<%@page import="cl.desafioLatam.DTO.UsuarioDTO"%>
<%@page import="cl.desafioLatam.DTO.DireccionDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi Portal Trabajador</title>
<%@include file="assets/html/importHead.html"%>
<link rel="stylesheet" href="assets/css/homeUsuario.css">
</head>
<body>

	<%@include file="assets/html/navbarPortal.html"%>
	<section class="contenedor-pagina container">

		<div class="bienvenida-Txt pt-3">
			<h1>
				Bienvenido(a) <a href="#" class=txt-color2>${userNick}</a> a tu
				portal de trabajador:
			</h1>
		</div>
		<hr>
		<div class="contenido-pagina row mt-5">

			<div class="contenedor-contenido">
				<h2 class="pt-2">
					<i class="fa-regular fa-bell"></i> Notificaciones
				</h2>
				<hr>
				<div class="ps-4">
					<p>
						<i class="fa-solid fa-check"></i> No tienes notificaciones
						pendientes.
					</p>
				</div>

			</div>

			<div class="contenedor-contenido mt-5 ">
				<h2 class="pt-2">
					<i class="fa-regular fa-file-lines"></i> Perfil Usuario
				</h2>
				<hr>
				<div class="row">
					<div class=" ps-5 pt-5 col-6">
						<p>
							<i class="fa-regular fa-user"></i> Nombre: ${userName}
						</p>
						<p>
							<i class="fa-solid fa-circle-user"></i> Nick Usuario: ${userNick}
						</p>
						<p>
							<i class="fa-regular fa-envelope"></i> Correo Electrónico:
							${userMail}
						</p>
						<p>
							<i class="fa-solid fa-scale-balanced"></i> Peso: ${userWeight} kg
						</p>
						<p>
							<i class="fa-regular fa-address-book"></i> Direccion:
							${userAddressStreet}, #${userAddressNumber}
						</p>
					</div>
					<div class="col-6 d-flex align-items-center justify-content-center">
						<img class="w-50" alt="imgPerfil"
							src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png">
					</div>
				</div>
			</div>





			<%
			Integer userIdRol = (Integer) session.getAttribute("userIdRol");

			if (userIdRol != null && userIdRol == 2) {
			%>
			<div class="contenedor-contenido py-3 my-5">
				<h2>
					<i class="fa-solid fa-unlock-keyhole"></i> Admin Mode:
				</h2>
				<hr>
				
				<div class=" d-flex justify-content-center py-2 pb-2">
				<form action="DatosTrabajadores" method="post">
					<button class ="btn-mostrar-reg r" type="submit" name="registroUsuarios" value="Administrador">Mostrar
						Informacion Trabajadores</button>
				</form>
				</div>
			
			<%
			}
			%>

			<%
			Boolean adminMod = (Boolean) request.getAttribute("adminMod");
			 
			if (adminMod != null) {
				if (adminMod == true) {
					ServicioRolUsuario sr = new ServicioRolUsuario();
					ServicioDireccion sd = new ServicioDireccion();
					List <UsuarioDTO> usuarios = (List<UsuarioDTO>) request.getAttribute("listaUsuarios");
			%>
			
			
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Nick</th>
						<th scope="col">Correo</th>
						<th scope="col">Peso</th>
						<th scope="col">Fecha Ingreso</th>
						<th scope="col">Fecha Actualición</th>
						<th scope="col">Direccion</th>
						<th scope="col">Nivel Permisos</th>
					</tr>
				</thead>
				<%for(UsuarioDTO usuario : usuarios){ %>
				<tbody>
						
					<tr>
						<th scope="row"><%=usuario.getId()%></th>
						<td><%=usuario.getNombre()%></td>
						<td><%=usuario.getNick() %></td>
						<td><%=usuario.getCorreo()%></td>
						<td><%=usuario.getPeso()%></td>
						<td><%=usuario.getCreatedAt()%></td>
						<td><%=usuario.getUpdateAt() %></td>
						<td><%=sd.findAdressByUserId(usuario.getId()).getNombre()%> #<%=sd.findAdressByUserId(usuario.getId()).getNumeracion()%></td>
						<td><%=sr.findRolByUserId(usuario.getId()).getRolId() %></td>
					</tr>

				</tbody>
				<%} %>
				
				
				
			</table>
		</div>
		
		<%
			}
		}
		%>

	</div>




	</section>
	<%@include file="assets/html/importFooter.html"%>
</body>
</html>