package cl.desafioLatam.controladores;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.UsuarioDTO;
import cl.desafioLatam.servicios.ServicioCuenta;

/**
 * Servlet implementation class registroControlador
 */
@WebServlet("/RegistroControlador")
public class RegistroControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int peso = 0;
		try {
			peso = Integer.parseInt(request.getParameter("pesoTxt")) ;
			
		} catch (Exception e) {
			System.out.println("Error al intentar parsear Peso: "+e.getMessage());
		}
	
		UsuarioDTO nuevoUsuario = new UsuarioDTO(0, request.getParameter("correoTxt"), null, request.getParameter("nickTxt"), request.getParameter("nombreTxt"), request.getParameter("passwordTxt"), peso, null);
		DireccionDTO nuevaDirrecion = new DireccionDTO(0, request.getParameter("calleTxt"), request.getParameter("numeracionTxt"), 0);
		
		ServicioCuenta sc = new ServicioCuenta();
		sc.registroDatos(nuevoUsuario, nuevaDirrecion);
		
		response.sendRedirect("vistaLogin.jsp");
				
	}

}
