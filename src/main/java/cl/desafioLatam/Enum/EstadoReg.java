package cl.desafioLatam.Enum;

public enum EstadoReg {

	INGRESADO ("Datos Ingresado Exitosamente."),
	NO_INGRESADO ("Datos no ingresados"),
	EXISTENTE ("Los datos ya existen");
	
	
	private final String mensaje;
	
	private EstadoReg (String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje () {
		return mensaje;
	}
	
}
