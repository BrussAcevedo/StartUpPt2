package cl.desafioLatam.utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SetFechaHora {

	
	public static String fijarFechaHora() {
		
		LocalDateTime fechayHora = LocalDateTime.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy"+ ", "+ "hh:mm");
		String resultado = fechayHora.format(formatoFecha);
		return resultado;
	}
	
}
