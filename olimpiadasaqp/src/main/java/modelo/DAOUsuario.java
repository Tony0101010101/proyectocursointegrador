package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOUsuario extends DAO{
	GestionCifrado cifrado = new GestionCifrado();
	
	public boolean autenticar(DTOUsuarioLogin dtoUsuario) {
        Connection cnx = crearCnx();
        
        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM usuarios WHERE email = ?");

            ps.setString(1, dtoUsuario.getEmail());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String contrasenaGuardada = rs.getString("contrasena");
                String contrasenaIngresada = cifrado.encriptar(dtoUsuario.getContrasena());

                if (contrasenaGuardada.equals(contrasenaIngresada)) {
                    return true;
                }
            }
            rs.close();
            ps.close();
            cnx.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public boolean registrar(DTOUsuarioSignup dtoUsuario) {
        Connection cnx = crearCnx();
    
        try {
            PreparedStatement ps = cnx.prepareStatement("INSERT INTO public.usuarios(nombre, email, contrasena) VALUES (?, ?, ?);");

            ps.setString(1, dtoUsuario.getNombre());
            ps.setString(2, dtoUsuario.getEmail());
            ps.setString(3, cifrado.encriptar(dtoUsuario.getContrasena()));

            int filasAfectadas = ps.executeUpdate();

            ps.close();
            cnx.close();

            return filasAfectadas > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}

	/*public Usuario validar(DTOUsuarioLogin dtoUsuario) {
		Usuario usuario = null;
		Connection cnx = crearCnx();
		
        try {
            PreparedStatement ps = cnx.prepareStatement("SELECT * FROM usuarios WHERE email =juan@gmail.com AND contrasena = juan");

            ps.setString(1, dtoUsuario.getEmail());
            ps.setString(2, dtoUsuario.getContrasena());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setEmail(rs.getString("email"));
            }
            rs.close();
            ps.close();
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }*/
}
