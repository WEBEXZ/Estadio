package Acciones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JqueryServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
    Login login = new Login();

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        if(usuario.equals("")||contrasena.equals("")) 
        {
            usuario = "NO HAS INGRESADO USUARIO O CONTRASEÑA";
        } else if(login.acceso(usuario,contrasena)==true)
        {
            usuario="";
        }else
        {
            usuario = "Usuario No Registrado";
        }
        
        response.setContentType("text/plain");
        response.getWriter().write(usuario);
    }
    
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException 
    {

        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        if(login.acceso(usuario,contrasena)==true)
        {
            if(login.tipo_Usuario(usuario,contrasena).equals("SEGURIDAD"))
            {
                response.sendRedirect("seguridad.jsp");    
            }else
            if(login.tipo_Usuario(usuario,contrasena).equals("ADMINISTRADOR"))
            {
                response.sendRedirect("administrador.jsp");    
            }
        }
            else
        {
            response.sendRedirect("login.jsp");
        }
        
        response.setContentType("text/plain");
    }
}