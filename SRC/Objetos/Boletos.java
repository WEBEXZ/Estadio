package Acciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Boletos 
{
    Conexion conexion = new Conexion();
    
    public void agregar_cliente(String Clave,int id_Zona, int id_Area,int id_Temporada,int id_Partido,String nom_Cliente,String tipo_Cliente,String fecha_Compra,double precio,int boletos)
    {
        try
        {
        String insertar = "INSERT INTO boletos(id_boleto,id_zona,id_area,id_temporada,id_partido,nom_cliente,tipo_cliente,fecha_compra,precio_total,n_boletos) VALUES(?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement p = conexion.getConexion().prepareStatement(insertar);
            p.setString(1,Clave);
            p.setInt(2,id_Zona);
            p.setInt(3,id_Area);
            p.setInt(4,id_Temporada);
            p.setInt(5,id_Partido);
            p.setString(6,nom_Cliente);
            p.setString(7,tipo_Cliente);
            p.setString(8,fecha_Compra);
            p.setDouble(9,precio);
            p.setInt(10,boletos);
            p.execute();
            p.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String busqueda(String clave)
    {
        String consulta = "NO EXISTE EL CLIENTE";
        try
        {
        String usuario = "SELECT CLAVE FROM seguridad where CLAVE = ?;";
        PreparedStatement p = conexion.getConexion().prepareStatement(usuario);
        p.setString(1,clave);
        ResultSet rs = p.executeQuery(); 
            while (rs.next())
            {
                consulta = "CLIENTE REGISTRADO";
            }
            rs.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return consulta;
   }
}