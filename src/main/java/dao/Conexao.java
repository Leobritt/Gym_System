package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private String url = "jdbc:postgresql://localhost:5432/gym";
	
	private String usuario = "postgres";
	
	private String senha = "123";
	
	private Connection con;
	
	public Connection conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url,usuario,senha);
			System.out.println(con);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
