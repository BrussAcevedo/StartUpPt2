package cl.desafioLatam.DAO;

import java.awt.Taskbar.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.desafioLatam.ConnectionBBDD.ConnectionBBDD;
import cl.desafioLatam.DAO.imp.DireccionDaoImp;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.Enum.EstadoSQL;


public class DireccionDAO implements DireccionDaoImp{

	List<DireccionDTO> direcciones = new ArrayList<>();
	
	private static final String SQL_FINDALL = "SELECT * FROM direcciones";
	private static final String SQL_FINDBY_ID = "SELECT * FROM direcciones WHERE usuario_id = ?";
	private static final String SQL_INSERT = "INSERT INTO direcciones (nombre, numeracion, usuario_id)  VALUES(?, ?, ?)";
	private static final String SQL_UPDATEBY_ID =  "UPDATE direcciones SET nombre = ?, numeracion= ?, usuario_id = ? WHERE usuario_id = ?";
	private static final String SQL_DELETE = "DELETE FROM direcciones WHERE id = ?";
	
	
	
	@Override
	public EstadoSQL findAll(List<DireccionDTO> direcciones) {
		List<DireccionDTO> direccionesTemp = new ArrayList<>();
		DireccionDTO direccion= null;
		
		try (Statement st = ConnectionBBDD.getConnection().createStatement();) {
			
			ResultSet rs = st.executeQuery(SQL_FINDALL);
			
			while (rs.next()) {
				
				direccion = new DireccionDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				direccionesTemp.add(direccion);
			}
			
			direcciones.addAll(direccionesTemp);
			return EstadoSQL.EXITO;
			
		} catch (SQLException e) {
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		
	}
	
	
	@Override
	public EstadoSQL findById(int idUsuario, DireccionDTO direccion){
		
		DireccionDTO direccionTemp = null;
		
		try {
			PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_FINDBY_ID);
			st.setInt(1, idUsuario);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {

				direccion.setId(rs.getInt(1));
				direccion.setNombre(rs.getString(2));
				direccion.setNumeracion(rs.getString(3));
				direccion.setUsuarioId(rs.getInt(4));
				
				if(direccion != null) {
					return EstadoSQL.CONDICION_EXITOSA;
				}
			}
				
			
		} catch (SQLException e) {
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}
		return EstadoSQL.SIN_EXITO;
		
	}
	
	
	@Override
	public EstadoSQL save(DireccionDTO direccion){
		
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_INSERT);){
			
			st.setString(1, direccion.getNombre());
			st.setString(2, direccion.getNumeracion());
			st.setInt(3, direccion.getUsuarioId());
			
			int res = st.executeUpdate();
			
			if (res >0) {
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
	public EstadoSQL Delete(int idDireccion){
		
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_DELETE);){
			
			st.setInt(1, idDireccion);
			
			int res = st.executeUpdate();
				
			if (res >0) {
				return EstadoSQL.EXITO;
			}else {
				return EstadoSQL.SIN_EXITO;
			}
			

		} catch (SQLException e) {
			System.out.println("Error. No se ha podido realizar la solicitud: " + e.getMessage());
			return EstadoSQL.SIN_EXITO;
		}

	}
	
	
	public EstadoSQL Update(int id, DireccionDTO direccionModificada) {
		
		
		try (PreparedStatement st = ConnectionBBDD.getConnection().prepareStatement(SQL_UPDATEBY_ID);){
			
			st.setString(1, direccionModificada.getNombre());
			st.setString(2, direccionModificada.getNumeracion());
			st.setInt(3, direccionModificada.getUsuarioId());
			st.setInt(4, id);
				
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
	
}
