package cl.desafioLatam.servicios;

import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.DireccionDAO;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.Enum.EstadoReg;
import cl.desafioLatam.Enum.EstadoSQL;

public class ServicioDireccion {

	
	private DireccionDAO direccionDao = new DireccionDAO();
	
	
	
	public EstadoReg nuevaDireccion (DireccionDTO nuevaDireccion) {
		boolean estado = !existenciaDireccion(nuevaDireccion.getUsuarioId());
		
		if(nuevaDireccion != null) {
			if(!existenciaDireccion(nuevaDireccion.getUsuarioId())) {
				
				EstadoSQL estadoSql =  direccionDao.save(nuevaDireccion);
				
				if (estadoSql == EstadoSQL.EXITO) {
					ConnectionBBDD.closeConnection();
					return EstadoReg.INGRESADO;
				}
			}	
		}
		ConnectionBBDD.closeConnection();
		return EstadoReg.NO_INGRESADO;
		
	}
	
	
	public boolean existenciaDireccion(int idUsuario) {
		
		DireccionDTO direccion = new DireccionDTO();
		EstadoSQL estado = direccionDao.findById(idUsuario, direccion);
		
		if (estado == EstadoSQL.CONDICION_EXITOSA){
			System.out.println(estado.getMensaje());
			ConnectionBBDD.closeConnection();
			return true;
		}
		
		return false;
	}
	
	public DireccionDTO findAdressByUserId(int idUsuario) {
		DireccionDTO direccionTemp = new DireccionDTO(0, "NOT_FOUND_ADRESS", "NOT_FOUND_NUMBER", 0);
		EstadoSQL estado = direccionDao.findById(idUsuario, direccionTemp);
		ConnectionBBDD.closeConnection();
			return direccionTemp;

	}
	
	
	
}
