package Acciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Login
{
    Conexion conexion = new Conexion();
    
    public boolean acceso(String user,String password)
    {
        boolean consulta = false;
        try
        {
        String usuario = "SELECT nom_empleado FROM empleados where nom_empleado = ? and contraseña = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setString(1,user);
        p.setString(2,password);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = true;
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
   }
    
    public String tipo_Usuario(String user,String password)
    {
        String consulta = "";
        try
        {
        String usuario = "SELECT tipo_empleado FROM empleados where nom_empleado = ? and contraseña = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setString(1,user);
        p.setString(2,password);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = rs.getString("tipo_empleado");
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
    }
}