package cl.desafioLatam.servicios;

import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.RolUsuarioDAO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;

public class ServicioRolUsuario {

	private RolUsuarioDAO rolUsuarioDao = new RolUsuarioDAO();
	
	
	public EstadoReg nuevoRol(RolUsuarioDTO nuevoRolUsuario) {
		
		if (nuevoRolUsuario != null && (nuevoRolUsuario.getRolId() > 0 && nuevoRolUsuario.getRolId() < 3)) {
			
			if (!existenciaRol(nuevoRolUsuario.getUsuarioId())) {
				
				 EstadoSQL estadoSql =  rolUsuarioDao.save(nuevoRolUsuario);
				 
				 if (estadoSql == EstadoSQL.EXITO) {
					 ConnectionBBDD.closeConnection();
					 return EstadoReg.INGRESADO;
				 }				
			}		
		}
		ConnectionBBDD.closeConnection();
		return EstadoReg.NO_INGRESADO;
	}
	
	public boolean existenciaRol (int idUsuario) {
		
		RolUsuarioDTO rolUsuario = new RolUsuarioDTO();
		EstadoSQL estado = rolUsuarioDao.findById(3, rolUsuario);
		
		if (estado == EstadoSQL.CONDICION_EXITOSA) {
			ConnectionBBDD.closeConnection();
			return true;
		}	
		ConnectionBBDD.closeConnection();
		return false;
	}
	
	public RolUsuarioDTO findRolByUserId(int idUsuario) {
		RolUsuarioDTO rolTemp = new RolUsuarioDTO(0, 0);
		EstadoSQL estado = rolUsuarioDao.findById(idUsuario, rolTemp);
		ConnectionBBDD.closeConnection();
			return rolTemp;		
		
	}
	
	
}
