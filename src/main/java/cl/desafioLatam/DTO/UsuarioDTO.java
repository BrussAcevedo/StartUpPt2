package cl.desafioLatam.DTO;

public class UsuarioDTO {

	
	private int id;
	private String correo;
	private String createdAt;
	private String nick;	
	private String nombre;
	private String password;
	private int peso;
	private String updateAt;
	
	
	  public UsuarioDTO() {}
	
	public UsuarioDTO(int id, String correo, String createdAt, String nick, String nombre, String password, int peso,
			String updateAt) {
	
		this.id = id;
		this.correo = correo;
		this.createdAt = createdAt;
		this.nick = nick;
		this.nombre = nombre;
		this.password = password;
		this.peso = peso;
		this.updateAt = updateAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", correo=" + correo + ", createdAt=" + createdAt + ", nick=" + nick
				+ ", nombre=" + nombre + ", password=" + password + ", peso=" + peso + ", updateAt=" + updateAt + "]";
	}
	
	
}
