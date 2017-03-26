package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AcessoBD{	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}	 
	public Connection obtemConexao() throws SQLException{
		//trampo
		//return DriverManager.getConnection("jdbc:mysql://localhost/restaurante?user=root&password=@Supprema123&useSSL=false");
		//facul
		return DriverManager.getConnection("jdbc:mysql://localhost/restaurante?user=alunos&password=alunos&useSSL=false");
		//casa
		//return DriverManager.getConnection("jdbc:mysql://localhost/restaurante?user=root&password=&useSSL=false");
		//final
		//return DriverManager.getConnection("jdbc:mysql://localhost/restaurante?user=root&password=alunos&useSSL=false");
	}
} 	