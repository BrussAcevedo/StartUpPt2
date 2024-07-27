package cl.desafioLatam.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.imp.RolUsuarioDaoImp;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.Enum.EstadoSQL;

public class RolUsuarioDAO implements RolUsuarioDaoImp{

	List<DireccionDTO> direcciones = new ArrayList<>();
	
	private static final String SQL_FINDALL = "SELECT * FROM roles_usuarios";
	private static final String SQL_FINDBY_ID = "SELECT * FROM roles_usuarios WHERE usuario_id = ?";
	private static final String SQL_INSERT = "INSERT INTO roles_usuarios (usuario_id, rol_id)  VALUES(?, ?)";
	private static final String SQL_UPDATEBY_ID =  "UPDATE roles_usuarios SET usuario_id = ?, rol_id = ? WHERE usuario_id = ?";
	private static final String SQL_DELETE = "DELETE FROM roles_usuarios WHERE rol_id = ?";
	
	
	@Override
	public EstadoSQL findAll(List<RolUsuarioDTO> roles) {
		List<RolUsuarioDTO> rolesTemp = new ArrayList<>();
		try (Statement st = ConnectionBBDD.getConnection().createStatement();
			 ResultSet rs = st.executeQuery(SQL_FINDALL)	){
		
		while(rs.next()) {
			RolUsuarioDTO rolUsuario = new RolUsuarioDTO( rs.getInt(1),  rs.getInt(2));
			rolesTemp.add(rolUsuario);
		}
		
		roles.addAll(rolesTemp);
		rolesTemp.clear();
		return EstadoSQL.EXITO;
		
			
		} catch (SQLException e) {
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		
	}
	
	@Override
	public EstadoSQL findById(int idUsuario, RolUsuarioDTO rolUsuario){
	
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_FINDBY_ID);){
			
			st.setInt(1, idUsuario);
			
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				rolUsuario.setUsuarioId(res.getInt(1));
				rolUsuario.setRolId(res.getInt(2));	
				
				if (rolUsuario.getUsuarioId() == idUsuario) {
					return EstadoSQL.CONDICION_EXITOSA;
				}else {
					return EstadoSQL.CONDICION_NO_EXITOSA;
				}
			}	
			
		} catch (SQLException e) {
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		return EstadoSQL.SIN_EXITO;

		
	}
	
	
	
	@Override
	public EstadoSQL save(RolUsuarioDTO rol){
		
		try {
			PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_INSERT);
			st.setInt(1, rol.getUsuarioId());
			st.setInt(2, rol.getRolId());
		
			
			int res = st.executeUpdate();
			
			if (res>0) {
				return EstadoSQL.EXITO;
			}else {
				return EstadoSQL.SIN_EXITO;
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}

	}
	
	
	@Override
	public EstadoSQL Delete(int idRol){
		
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_DELETE);) {
			
			st.setInt(1, idRol);
			
			int res = st.executeUpdate();
			if(res>0) {
				return EstadoSQL.EXITO;
			}else {
				return EstadoSQL.SIN_EXITO;
				}	
			
		} catch (SQLException e) {
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		
	}
}
