package cl.desafioLatam.servicios;




import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.UsuarioDAO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;

public class ServicioUsuario {

	private UsuarioDAO usuarioDao = new UsuarioDAO();
	
	
	
	public EstadoReg NuevoUsuario (UsuarioDTO nuevoUsuario) {
		EstadoSQL estadoSql = null;
		if (nuevoUsuario.getCorreo() != null && nuevoUsuario.getPassword() != null ) {
			String correo = nuevoUsuario.getCorreo();
			if(!existenciaUsuario(correo)) {
				estadoSql= usuarioDao.save(nuevoUsuario);
				
				System.out.println(estadoSql.getMensaje());
				
				if (estadoSql == EstadoSQL.EXITO) {				
					return EstadoReg.INGRESADO;
				}
			}else {
				ConnectionBBDD.closeConnection();
				return EstadoReg.EXISTENTE;
			}		
		}		
		ConnectionBBDD.closeConnection();
		return EstadoReg.NO_INGRESADO;
		
		
		
	}
	
	private boolean existenciaUsuario (String correo) {
		UsuarioDTO usuarioTemp = new UsuarioDTO();
		EstadoSQL estado = usuarioDao.findByMail(correo, usuarioTemp);
		
		if (estado == EstadoSQL.CONDICION_EXITOSA) {
			System.out.println("usuario Encontrado");
			ConnectionBBDD.closeConnection();
			return true;
		}
		System.out.println("usuario no encontrado");
		ConnectionBBDD.closeConnection();
		return false;
	}
	
	public UsuarioDTO encontrarUsuario (String correoUsuario) {
		UsuarioDTO usuarioEncontrado = new UsuarioDTO();
		usuarioDao.findByMail(correoUsuario, usuarioEncontrado);
		if (usuarioEncontrado !=null) {
			ConnectionBBDD.closeConnection();
			return usuarioEncontrado;
		}
		ConnectionBBDD.closeConnection();
		return usuarioEncontrado;
		
	}
	
	
	
	
}
