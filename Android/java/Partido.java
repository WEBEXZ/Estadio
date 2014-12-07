package com.example.alebrijes;

public class Partido 
{
    public String fecha;
    private String hora;
    private double costo;
    public String jornadas[]={"<selecciona>","JORNADA 1","JORNADA 2","JORNADA 3","JORNADA 4","JORNADA 5","JORNADA 6","JORNADA 7","JORNADA 8","JORNADA 9","JORNADA 10"};
    private String nom_rival; 
    
    public void getPartido(String jornada)
    {
        if(jornada.equals("JORNADA 1"))
        {
        fecha = "1/11/2014";
        hora = "21:00";
        nom_rival="Tecos";
        costo=400;
        }
        else if(jornada.equals("JORNADA 2"))
        {
        fecha = "2/11/2014";
        hora = "20:00";
        nom_rival="America";
        costo=400;
        }
        else if(jornada.equals("JORNADA 3"))
        {
        fecha = "3/11/2014";
        hora = "19:00";
        nom_rival="Cruz Azul";
        costo=400;
        }
        else if(jornada.equals("JORNADA 4"))
        {
        fecha = "4/11/2014";
        hora = "18:00";
        nom_rival="Chivas";
        costo=400;
        }
        else if(jornada.equals("JORNADA 5"))
        {
        fecha = "5/11/2014";
        hora = "17:00";
        nom_rival="Toluca";
        costo=400;
        }
        else if(jornada.equals("JORNADA 6"))
        {
        fecha = "6/11/2014";
        hora = "16:00";
        nom_rival="Santos";
        costo=400;
        }
        else if(jornada.equals("JORNADA 7"))
        {
        fecha = "7/11/2014";
        hora = "15:00";
        nom_rival="Necaxa";
        costo=400;
        }
        else if(jornada.equals("JORNADA 8"))
        {
        fecha = "8/11/2014";
        hora = "10:00";
        nom_rival="Jaguares";
        costo=200;
        }
        else if(jornada.equals("JORNADA 9"))
        {
        fecha = "9/11/2014";
        hora = "12:00";
        nom_rival="Pumas";
        costo=300;
        }
        else if(jornada.equals("JORNADA 10"))
        {
        fecha = "10/11/2014";
        hora = "13:00";
        nom_rival="Leon";
        costo=1400;
        }
    }
    
    public String get_nom_rival()
    {
        return nom_rival;
    }
    
    public String get_hora()
    {
        return hora;
    }
    
    public String get_fecha()
    {
        return fecha;
    }
    
    public double getCosto()
    {
        return costo;
    }
    
    public String[] getJornadas()
    {
        return jornadas;
    }
}
