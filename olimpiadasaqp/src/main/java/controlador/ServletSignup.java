package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DAOUsuario;
import modelo.DTOUsuarioSignup;

@WebServlet("/ServletSignup")
public class ServletSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletSignup() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String contrasena = request.getParameter("contrasena");
		
		DAOUsuario daoUsuario = new DAOUsuario();
	    DTOUsuarioSignup dtoUsuario = new DTOUsuarioSignup();
	    
	    dtoUsuario.setNombre(nombre);
	    dtoUsuario.setEmail(email);
	    dtoUsuario.setContrasena(contrasena);
	    
	    boolean registro = daoUsuario.registrar(dtoUsuario);
		
	    if (registro) {
	        request.getRequestDispatcher("index.jsp").forward(request, response);
	        
	    } else {
	        request.getRequestDispatcher("registro.jsp").forward(request, response);
	    }
	}

}
