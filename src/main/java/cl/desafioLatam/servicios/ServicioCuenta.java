package cl.desafioLatam.servicios;



import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.UsuarioDAO;
import cl.desafioLatam.DAO.imp.UsuarioDaoImp;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;
import cl.desafioLatam.utilidades.SetFechaHora;

public class ServicioCuenta {

	private ServicioUsuario servicioUsuario = new ServicioUsuario();
	private ServicioDireccion servicioDireccion = new ServicioDireccion();
	private ServicioRolUsuario servicioRol = new ServicioRolUsuario();
	private ServicioSeguridad seguridad = new ServicioSeguridad();
	
	public void registroDatos (UsuarioDTO datosUsuario, DireccionDTO datosDireccion) {
		RolUsuarioDTO rolUsuario = new RolUsuarioDTO(datosUsuario.getId(), 1);
		
		
		if (datosUsuario != null) {
			if (!datosUsuario.getCorreo().isEmpty() && !datosUsuario.getPassword().isEmpty()) {
				
				String passwordEncripted = seguridad.encriptarPassword(datosUsuario.getPassword());
				datosUsuario.setPassword(passwordEncripted);
				
				String fechaHoraActual= SetFechaHora.fijarFechaHora();
				datosUsuario.setCreatedAt(fechaHoraActual);
				datosUsuario.setUpdateAt(fechaHoraActual);
				
				EstadoReg estadoUsReg = servicioUsuario.NuevoUsuario(datosUsuario);
				EstadoReg estadoDirReg = EstadoReg.NO_INGRESADO;
				EstadoReg estadoRolReg = EstadoReg.NO_INGRESADO;
				
				if (estadoUsReg == EstadoReg.INGRESADO) {

					datosDireccion.setUsuarioId(findIdByMail(datosUsuario.getCorreo()));
						estadoDirReg = servicioDireccion.nuevaDireccion(datosDireccion);
					rolUsuario.setUsuarioId(findIdByMail(datosUsuario.getCorreo()));
						estadoRolReg = servicioRol.nuevoRol(rolUsuario);
				}
				
				
				String estadoGralReg = String.format("Resumen registro:\r\n"
											+ "Registro del usuario: %s\r\n"
											+ "registro direccion: %s\r\n"
											+ "registro rol: %s", estadoUsReg.getMensaje(), estadoDirReg.getMensaje(), estadoRolReg.getMensaje());
				
			}		
			
		}
		ConnectionBBDD.closeConnection();	
	}
	
	public boolean loginUsuario (String correoLogin, String passwordLogin) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		EstadoSQL estado = usuarioDao.validatePassword(correoLogin, passwordLogin);
		if(estado == EstadoSQL.CONDICION_EXITOSA) {
			ConnectionBBDD.closeConnection();
			return true;
		}
		ConnectionBBDD.closeConnection();
		return false;
		
	}
	
	
	
	public int findIdByMail(String correoNuevoUsuario) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		UsuarioDTO usuarioTemp = new UsuarioDTO();
		
		EstadoSQL estado = usuarioDao.findByMail(correoNuevoUsuario, usuarioTemp);
		if (estado == EstadoSQL.CONDICION_EXITOSA) {
			System.out.println("UsuarioEncontrado: " + estado.getMensaje());
			ConnectionBBDD.closeConnection();
			return usuarioTemp.getId();
		}else {
			System.out.println(estado.getMensaje());
			ConnectionBBDD.closeConnection();
			return 0;
		}
		
	}
	
	
	
	
	
}
