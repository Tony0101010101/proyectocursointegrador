package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DAOUsuario;
import modelo.DTOUsuarioLogin;
import modelo.Usuario;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String contrasena = request.getParameter("contrasena");
		
		DAOUsuario daoUsuario = new DAOUsuario();
	    DTOUsuarioLogin dtoUsuario = new DTOUsuarioLogin();
	    
	    dtoUsuario.setEmail(email);
	    dtoUsuario.setContrasena(contrasena);
	    
	    boolean autentificacion = daoUsuario.autenticar(dtoUsuario);
		 
	    if (autentificacion) {
	        request.getRequestDispatcher("inicio.jsp").forward(request, response);
	        
	    } else {
	        request.getRequestDispatcher("index.jsp").forward(request, response);
	    }
	}

}
