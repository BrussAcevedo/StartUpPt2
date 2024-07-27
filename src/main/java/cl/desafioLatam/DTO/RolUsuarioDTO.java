package cl.desafioLatam.DTO;

public class RolUsuarioDTO {

	private int usuarioId;
	private int rolId;
	
	public RolUsuarioDTO () {}
	
	public RolUsuarioDTO(int usuarioId, int rolId) {
	
		this.usuarioId = usuarioId;
		this.rolId = rolId;
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}
	
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public int getRolId() {
		return rolId;
	}
	
	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	@Override
	public String toString() {
		return "RolesUsuariosDTO [usuarioId=" + usuarioId + ", rolId=" + rolId + "]";
	}
	
	
	
}
