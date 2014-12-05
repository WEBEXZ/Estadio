package Acciones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Enviar extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    Area areas = new Area();
    Boletos boletos = new Boletos();
    Cliente cliente = new Cliente();
    boolean verificado = false;
    
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String tipo = request.getParameter("descuento");
        String partido = request.getParameter("partido");
        String b_disponibles = request.getParameter("b_disponibles");
        String mensaje;
        
        if(nombre.equals("")||cantidad.equals("0")||tipo.equals("0")||partido.equals("0")||b_disponibles.equals("NO EXISTE DICHA RELACIÓN"))
        {
            mensaje="CAMPOS VACIOS";
            verificado=false;
            response.getWriter().write(mensaje);
        }else
        {
            verificado=true;
        }
        response.setContentType("text/plain");
    }
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {
        String area = request.getParameter("area");
        String zona = request.getParameter("zona");
        String partido = request.getParameter("partido");
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String tipo = request.getParameter("descuento");
        
        if(verificado==true && !tipo.equals("0")) //ENTRA SI FUE VALIDADO ANTERIORMENTE O SI DESCUENTO FUE CAMBIADO DE VALOR
        {
            int id_area = Integer.parseInt(area); //OBETENER EL ID DEL AREA
            int id_zona = Integer.parseInt(zona); //OBTENER EL ID DE LA ZONA
            int b_cantidad = Integer.parseInt(cantidad); //OBTENER LA CANTIDAD DE BOLETOS
            int id_partido = Integer.parseInt(partido); //OBTENER EL ID DEL PARTIDO
            int precio = areas.precio_boleto(id_area,id_zona);
            double descuento = cliente.tipo(tipo);
            double sub_total = precio-(precio*descuento);
            double total = sub_total * b_cantidad;
            
            
            if(areas.boleto_disponible(1,id_partido,id_area,id_zona)>0 && b_cantidad<=areas.boleto_disponible(1,id_partido,id_area,id_zona))//SI LA CANTIDAD DE BOLETOS DISPONIBLES ES MAYOR A CERO
            {
                areas.update_Asientos(b_cantidad,1,id_partido,id_zona, id_area); //HACE EL UPDATE DE ASIENTOS DISPONIBLES
                String clave = cliente.getClave(nombre, cliente.fecha(), cliente.tiempo()); //GENERA LA CLAVE DEL USUARIO
                boletos.agregar_cliente(clave,id_zona,id_area,1,id_partido,nombre,tipo,cliente.fecha(),total,b_cantidad); //HACE LA VENTA
                response.sendRedirect("datos_enviados.jsp");
            }else //SI NO
            {
                response.sendRedirect("Boletos_agotados.jsp"); //REGRESA AL INDICE
            }
            
        }else
        {
            response.sendRedirect("datos_no_enviados.jsp");
        }
    }
}