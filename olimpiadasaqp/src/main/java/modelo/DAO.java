package modelo;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	public Connection crearCnx() {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = null;
			ds = (DataSource) ctx.lookup("java:/jdbc/olimpiadasaqp");
			con = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
