package cl.desafioLatam.servicios;

import at.favre.lib.crypto.bcrypt.BCrypt;
import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.UsuarioDAO;

public class ServicioSeguridad {

	
	public static String encriptarPassword(String password) {
		return BCrypt.withDefaults().hashToString(12, password.toCharArray());
	}
	
	
	public static boolean verificarPassword (String correo, String passwordIngresada, String passwordHashed) {
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.validatePassword(correo, passwordIngresada);
		
		ConnectionBBDD.closeConnection();
		return false;
	}
	
}
