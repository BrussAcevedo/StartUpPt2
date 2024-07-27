package cl.desafioLatam.DAO.imp;

import java.util.List;

import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.Enum.EstadoSQL;

public interface DireccionDaoImp {
	EstadoSQL findAll(List<DireccionDTO> direcciones); //Encuentra un Rol y modifica la lista de entrada.
	EstadoSQL findById(int idUsuario, DireccionDTO direccion); // Encuentra un Rol o los roles edun usuario. El list como parametro de entrada se modifica dentro del metodo.
	EstadoSQL save(DireccionDTO direccion);
	EstadoSQL Delete(int idDireccion);
	EstadoSQL Update(int id, DireccionDTO direccionModificada);
}
