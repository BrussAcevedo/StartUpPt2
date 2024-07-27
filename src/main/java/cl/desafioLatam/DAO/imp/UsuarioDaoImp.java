package cl.desafioLatam.DAO.imp;

import java.util.List;

import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.Enum.EstadoSQL;

public interface UsuarioDaoImp {

	
	EstadoSQL findAll(List<UsuarioDTO> usuarios); //Encuentra un usuario y modifica la lista de entrada.
	EstadoSQL findByMail(String mail, UsuarioDTO buscarUsuario); // Encuentra un usuario mediante la id, se entrega parametro UsuarioDTO Inicializado y constructor vacio.
	EstadoSQL save(UsuarioDTO usuario);
	EstadoSQL Update(int id, UsuarioDTO usuario);
	EstadoSQL Delete(int id);
	EstadoSQL validatePassword(String correo, String password);
	

	
}
