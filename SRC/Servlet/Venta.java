package Acciones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Venta extends HttpServlet 
{
    Boletos boletos = new Boletos();
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {
        String clave = request.getParameter("clave");
        String mensaje;
        
        mensaje = boletos.busqueda(clave);
        
        response.setContentType("text/plain");
        response.getWriter().write(mensaje);
    }
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {
        String clave = request.getParameter("clave");
        String mensaje;
        
        mensaje = boletos.busqueda(clave);
        
        response.setContentType("text/plain");
        response.getWriter().write(mensaje);
    }
    
}