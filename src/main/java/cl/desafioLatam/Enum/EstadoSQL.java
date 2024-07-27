package cl.desafioLatam.Enum;

public enum EstadoSQL {

	EXITO ("Solicitud SQL ingresada con éxito"),
	SIN_EXITO ("Solicitud SQL ingresada SIN éxito"),
	CONDICION_EXITOSA ("La informacion coincide con la BBDD"),
	CONDICION_NO_EXITOSA ("La informacion NO coincide con la BBDD");
	
	
	private final String mensaje;
	
	private EstadoSQL (String mensaje){
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	
}
