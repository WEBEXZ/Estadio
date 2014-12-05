package Acciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Area 
{
    Conexion conexion = new Conexion();
    
    
    public int boleto_disponible(int id_temporada,int id_partido,int area,int zona)
    {
        int boletos=0;
        try
        {
        String usuario = "SELECT boletos_disp FROM areas where id_Temporada = ? and id_Partido =? and id_area = ? and id_zona = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setInt(1,id_temporada);
        p.setInt(2,id_partido);
        p.setInt(3,area);
        p.setInt(4,zona);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                boletos = rs.getInt("boletos_disp");
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return boletos;
    }
    
    public String boletos_disponibles(int id_temporada,int id_partido,int area,int zona)
    {
        String consulta = "NO EXISTE DICHA RELACIÓN";
        try
        {
        String usuario = "SELECT boletos_disp FROM areas where id_Temporada = ? and id_Partido =? and id_area = ? and id_zona = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setInt(1,id_temporada);
        p.setInt(2,id_partido);
        p.setInt(3,area);
        p.setInt(4,zona);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = rs.getString("boletos_disp");
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
   }
    
    public int restar_asientos(String cantidad,String a_restar)
    {
        int total = Integer.parseInt(cantidad);
        int vendidos = Integer.parseInt(a_restar);
        return total = total-vendidos;
    }
    
    public void update_Asientos(int disponibles,int id_temporada,int id_partido, int zona,int area)
    {
        try
        {
            String eliminar = "UPDATE areas set boletos_disp = boletos_disp - ? where id_Temporada = ? and id_Partido = ? and id_zona = ? and id_area = ? ";
            PreparedStatement p = conexion.getConexion().prepareStatement(eliminar);
            p.setInt(1, disponibles);                             
            p.setInt(2,id_temporada);
            p.setInt(3,id_partido);
            p.setInt(4,area);
            p.setInt(5,zona);
            p.execute();
            p.close();            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int precio_boleto(int area,int zona)
    {
        int consulta = 0;
        try
        {
        String usuario = "SELECT precio_boleto FROM areas where id_area = ? and id_zona = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setInt(1,area);
        p.setInt(2,zona);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = rs.getInt("precio_boleto");
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
   }
}
