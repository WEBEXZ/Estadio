package com.example.alebrijes;

public class Login 
{
    public String verificar(String usuario, String contrasena) 
    {
        String tipo="";
        if(usuario.equalsIgnoreCase("ADMIN")&&contrasena.equals("root")){
            tipo = "Administrador";}
        if(usuario.equalsIgnoreCase("UsuarioV") && contrasena.equalsIgnoreCase("contraseña")){
        tipo="Vendedor";
        }
        if(usuario.equalsIgnoreCase("UsuarioS") && contrasena.equalsIgnoreCase("contraseña")){
        tipo="Seguridad";
        }
       /* if(BD.usuario.equalsIgnoreCase(usuario)&&BD.contrasena.equals(contrasena)){
        tipo=BD.tipo;
        }*/
        return tipo;
    }

    public String acceder(String tipoU) 
    {
        String Acceso="sin acceso";
        if(tipoU.equals("Administrador")){
        Acceso = "Eres administrador";}
        if(tipoU.equals("Vendedor")){
        Acceso = "Eres vendedor";}
        if(tipoU.equals("Seguridad")){
        Acceso = "Eres policia";}
        return Acceso;
    }
}
