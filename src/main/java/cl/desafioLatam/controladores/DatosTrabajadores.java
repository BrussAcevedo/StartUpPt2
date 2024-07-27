package cl.desafioLatam.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.desafioLatam.DAO.DireccionDAO;
import cl.desafioLatam.DAO.RolUsuarioDAO;
import cl.desafioLatam.DAO.UsuarioDAO;
import cl.desafioLatam.DTO.DireccionDTO;
import cl.desafioLatam.DTO.RolUsuarioDTO;
import cl.desafioLatam.DTO.UsuarioDTO;

/**
 * Servlet implementation class DatosTrabajadores
 */
@WebServlet("/DatosTrabajadores")
public class DatosTrabajadores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatosTrabajadores() {
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
		List<UsuarioDTO> usuarios = new ArrayList<>();
		List<DireccionDTO> direcciones = new ArrayList<>();
		List<RolUsuarioDTO> roles = new ArrayList<>();
		UsuarioDAO ud = new UsuarioDAO();
		DireccionDAO dd = new DireccionDAO();
		RolUsuarioDAO rd = new RolUsuarioDAO();	
		String noData = "No hay Datos";
		ud.findAll(usuarios);
		dd.findAll(direcciones);
		rd.findAll(roles);
		
		
		Boolean modoAdmin = false;
	 String mostrarListado = request.getParameter("registroUsuarios");
	 if (mostrarListado.equals("Administrador")) {
		 modoAdmin = true;
		 	if (!usuarios.isEmpty()) {
		 		
		 		request.setAttribute("listaUsuarios", usuarios);
		 	}
		 	
		 	
			if (!direcciones.isEmpty()) {
 				request.setAttribute("listaDirecciones", direcciones);
 			}
		  
			if (!roles.isEmpty()){
				request.setAttribute("listaRoles", roles);
			}
	 	}
		 
		 request.setAttribute("adminMod", modoAdmin);
		 request.getRequestDispatcher("vistaHomeUsuario.jsp").forward(request, response);
	
	 
	}

}
