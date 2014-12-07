package com.example.alebrijes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conexionModificar {
	Connection conexionMySQL;
public String IngresarDatos(String Consulta){
	  String resultadoSQL = "";
	try{
		 // String QSLEjecutar = "select * from partidos";
		 String QSLEjecutar =Consulta;
		  conectarBDMySQL("feliciano", "alebrijes", 
				  "s155.eatj.com", "3307", "feliciano");
		  Statement st = conexionMySQL.createStatement();
			  int rsS = st.executeUpdate(QSLEjecutar);
		  st.close();   		  
	}

	catch (Exception e) 
	{
		System.out.println(e.getMessage());
	}
	return resultadoSQL;
}	
	
	
	
	
	
	

public void conectarBDMySQL (String usuario, String contrasena,String ip, String puerto, String catalogo)
{
	if (conexionMySQL == null)    	
	{
		String urlConexionMySQL = "";
		if (catalogo != "")
			urlConexionMySQL = "jdbc:mysql://" + ip + ":" +	puerto + "/" + catalogo;
		else
			urlConexionMySQL = "jdbc:mysql://" + ip + ":" + puerto;
		if (usuario != "" & contrasena != "" & ip != "" & puerto != "")
		{
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
    			conexionMySQL =	DriverManager.getConnection(urlConexionMySQL, 
    					usuario, contrasena);					
			} 
			catch (ClassNotFoundException e) 
			{
				System.out.println(e.getMessage());
			} 
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}
		}
	}
}

}
