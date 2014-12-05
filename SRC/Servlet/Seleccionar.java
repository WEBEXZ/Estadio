package Acciones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Seleccionar extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    Area areas = new Area();
    Partidos partidos = new Partidos();
    
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {
        String disponibles;
        String area = request.getParameter("area");
        String zona = request.getParameter("zona");
        String partido = request.getParameter("partido");
        int id_area = Integer.parseInt(area);
        int id_zona=Integer.parseInt(zona);
        int id_partido = Integer.parseInt(partido);
        
        if(area.equals("0") || zona.equals("0"))
        {
            disponibles="NO EXISTE DICHA RELACIÓN";
        }else
        {
            disponibles=areas.boletos_disponibles(1,id_partido,id_area,id_zona);
        }
        
        response.setContentType("text/plain");
        response.getWriter().write(disponibles);
        
    }
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {
        String partido = request.getParameter("partido");
        String horario;
        
        horario = partidos.hora(partido);
        response.setContentType("text/plain");
        
        response.getWriter().write(horario);
    }
}
