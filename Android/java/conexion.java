package com.example.alebrijes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conexion {
	Connection conexionMySQL;
public String HacerConsulta(String Consulta){
	  String resultadoSQL = "";
	try{
		 // String QSLEjecutar = "select * from partidos";
		 String QSLEjecutar =Consulta;
		  conectarBDMySQL("feliciano", "alebrijes", 
				  "s155.eatj.com", "3307", "feliciano");
		  
		  Statement st = conexionMySQL.createStatement();
			  ResultSet rs = st.executeQuery(QSLEjecutar);
		  Integer numColumnas = 0;
			  
		  //número de columnas (campos) de la consula SQL            	  
		  numColumnas = rs.getMetaData().getColumnCount();            	  

		  //mostramos el resultado
		  while (rs.next()) 
		  {  
			  for (int i = 1; i <= numColumnas; i++)
	        {                          
	            if (rs.getObject(i) != null)
	            {
	          	  if (resultadoSQL != "")
	          		  if (i < numColumnas)
	          			  resultadoSQL = resultadoSQL + rs.getObject(i).toString() + ";";
	          		  else
	          			  resultadoSQL = resultadoSQL + rs.getObject(i).toString();
	          	  else
	          		  if (i < numColumnas)
	          			  resultadoSQL = rs.getObject(i).toString() + ";";
	          		  else
	          			  resultadoSQL = rs.getObject(i).toString();
	            }
	            else
	            {
	          	  if (resultadoSQL != "")
	          		  resultadoSQL = resultadoSQL + "null;";
	          	  else
	          		  resultadoSQL = "null;";
	            }                           
	        }
	        resultadoSQL = resultadoSQL + "nn";
		  }
		  //textResultadoSQL.setText(resultadoSQL);
		  //System.out.println(resultadoSQL);
		  st.close();
		  rs.close();    		  
	}

	catch (Exception e) 
	{  
		/*  Toast.makeText(getApplicationContext(),
	              "Error: " + e.getMessage(),
	              Toast.LENGTH_SHORT).show();*/
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
		      	/*  Toast.makeText(getApplicationContext(),
		                    "Error: " + e.getMessage(),
		                    Toast.LENGTH_SHORT).show();*/
				System.out.println(e.getMessage());
			} 
			catch (SQLException e) 
			{
		      /*	  Toast.makeText(getApplicationContext(),
		                    "Error: " + e.getMessage(),
		                    Toast.LENGTH_SHORT).show();*/
				System.out.println(e.getMessage());
			}
		}
	}
}

}
