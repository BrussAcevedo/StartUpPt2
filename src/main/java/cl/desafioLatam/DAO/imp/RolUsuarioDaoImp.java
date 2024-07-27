package cl.desafioLatam.DAO.imp;

import java.util.List;

import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.Enum.EstadoSQL;

public interface RolUsuarioDaoImp {

	
	EstadoSQL findAll(List<RolUsuarioDTO> roles); //Encuentra un Rol y modifica la lista de entrada.
	EstadoSQL findById(int idUsuario, RolUsuarioDTO rolUsuario); // Encuentra un Rol o los roles edun usuario. El list como parametro de entrada se modifica dentro del metodo.
	EstadoSQL save(RolUsuarioDTO rol);
	EstadoSQL Delete(int idRol);
	
}

