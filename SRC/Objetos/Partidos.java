package Acciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Partidos 
{
    Conexion conexion = new Conexion();
    
    public String hora(String id_partido)
    {
        String consulta = "NO HAY PARTIDO";
        try
        {
        String usuario = "SELECT fecha,hora FROM partidos where id_temporada = 1 and id_partido = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setString(1,id_partido);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = rs.getString("fecha")+" a las "+rs.getString("hora")+" hrs";
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
   }
}
