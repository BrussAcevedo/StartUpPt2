package cl.desafioLatam.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PasswordUtil;

import at.favre.lib.crypto.bcrypt.BCrypt;
import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.imp.UsuarioDaoImp;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.Enum.EstadoSQL;
import cl.desafioLatam.servicios.ServicioSeguridad;

public class UsuarioDAO implements UsuarioDaoImp{

	
	private static final String SQL_FINDALL = "SELECT * FROM usuarios";
	private static final String SQL_FINDBY_MAIL = "SELECT * FROM usuarios WHERE correo = ?";
	private static final String SQL_INSERT = "INSERT INTO usuarios (correo, created_at, nick, nombre, password, peso, updated_at)  VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATEBY_ID =  "UPDATE usuarios SET correo = ?, created_at = ?, nick = ?, nombre = ?, peso = ?, updated_at  = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";
	private static final String SQL_FINDPASSWORDBY_MAIL = "SELECT correo, password FROM usuarios WHERE correo = ?;";
	private static final String SQL_UPDATE_PASSWORD = "UPDATE usuarios SET password = ? WHERE correo = ?";
	
	
	@Override
	public EstadoSQL findAll(List<UsuarioDTO> usuarios) {
		List<UsuarioDTO> usuariosTemp = new ArrayList();
		
		UsuarioDTO usuario = null;
		
	
		try (	Statement st = ConnectionBBDD.getConnection().createStatement();
				ResultSet res = st.executeQuery(SQL_FINDALL)){			
		
			while(res.next()) {
				usuario = new UsuarioDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),"***********", res.getInt(7), res.getString(8));
				usuariosTemp.add(usuario);
			}
			
			usuarios.addAll(usuariosTemp);
			usuariosTemp.clear();
			return EstadoSQL.EXITO;
			
		} catch (SQLException e) {
			
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		
		
	} 
	
	
	@Override
	public EstadoSQL findByMail(String mail, UsuarioDTO buscarUsuario){


		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_FINDBY_MAIL);) {
			
			st.setString(1, mail);
			ResultSet res = st.executeQuery();
			while (res.next()) {

				buscarUsuario.setId(res.getInt(1));
				buscarUsuario.setCorreo(res.getString(2));
				buscarUsuario.setCreatedAt(res.getString(3));
				buscarUsuario.setNick(res.getString(4));
				buscarUsuario.setNombre(res.getString(5));
				buscarUsuario.setPassword("*************");
				buscarUsuario.setPeso(res.getInt(7));;
				buscarUsuario.setUpdateAt(res.getString(8));;
				
			
			}
			if(buscarUsuario.getCorreo() != null) {
				if(buscarUsuario.getCorreo().equals(mail)) {
					System.out.println("Usuario encontrado con éxito.");
					return EstadoSQL.CONDICION_EXITOSA;
				}
				return EstadoSQL.SIN_EXITO;
			}else {
				return EstadoSQL.CONDICION_NO_EXITOSA;
			}
	
		} catch (SQLException e) {
		System.out.println("Error. No fue posible enviar la solicitud a la base de datos: "+e.getMessage());
		return EstadoSQL.SIN_EXITO;
		}

		
	}  
	
	
	@Override
	public EstadoSQL validatePassword(String correo, String password) {
		
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_FINDPASSWORDBY_MAIL);) {
			
			st.setString(1, correo);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				
				if (rs.getString(1) != null) {
					BCrypt.Result resultPass = BCrypt.verifyer().verify(password.toCharArray(), rs.getString(2));
					boolean validacion = resultPass.verified;
					if (validacion == true) {
						return EstadoSQL.CONDICION_EXITOSA;
					}else {
						return EstadoSQL.CONDICION_NO_EXITOSA;
					}
				}
				
				
			}

	
		} catch (SQLException e) {
			System.out.println("Error. No fue posible enviar la solicitud a la base de datos: "+e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		return EstadoSQL.SIN_EXITO;

	}
	
	
	@Override
	public EstadoSQL save(UsuarioDTO usuario){
		
		try {
			PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_INSERT);
			st.setString(1, usuario.getCorreo());
			st.setString(2, usuario.getCreatedAt());
			st.setString(3, usuario.getNick());
			st.setString(4, usuario.getNombre());
			st.setString(5, usuario.getPassword());
			st.setInt(6, usuario.getPeso());
			st.setString(7, usuario.getUpdateAt());
			
		
			int rs = st.executeUpdate();
			
			if (rs>0) {
				System.out.println("Usuario Ingresador con éxito.");
				return EstadoSQL.EXITO;
			}
			
		} catch (SQLException e) {
			System.out.println("Error. No fue posible enviar la solicitud a la base de datos: "+e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		
		return EstadoSQL.SIN_EXITO;
	} 
	
	
	@Override
	public EstadoSQL Update(int id, UsuarioDTO usuario){
		
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_UPDATEBY_ID);){
			
			st.setString(1, usuario.getCorreo());
			st.setString(2, usuario.getCreatedAt());
			st.setString(3, usuario.getNick());
			st.setString(4, usuario.getNombre());
			st.setString(5, usuario.getPassword());
			st.setInt(6, usuario.getPeso());
			st.setString(7, usuario.getUpdateAt());
			st.setInt(8, id);
			
				
			int rs = st.executeUpdate();
			if (rs>0) {
				System.out.println("Usuario Actualizado con éxito.");
				
				return EstadoSQL.EXITO;
			}else {
				System.out.println("No se ha actualizado el Usuario");
				return EstadoSQL.SIN_EXITO;
			}
			
		} catch (SQLException e) {
			
			System.out.println("Error. No fue posible enviar la solicitud a la base de datos: "+e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		
		
		
		
	} 
	
	@Override
	public EstadoSQL Delete(int id){
		
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_DELETE);){
			
			st.setInt(1, id);
			
			int res = st.executeUpdate();
			
			 if (res >0) {
					System.out.println("Usuario Ingresador con éxito.");
					System.out.println(res);
					return EstadoSQL.EXITO;
			 }else {
				 System.out.println("No se ha encontrado valor indicado en la base de datos: "+id);
				 return EstadoSQL.SIN_EXITO;
			 }
			
			
			
		} catch (SQLException e) {
			System.out.println("Error. No fue posible enviar la solicitud a la base de datos: "+e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		
		
		

	} 
	
	
	
}
