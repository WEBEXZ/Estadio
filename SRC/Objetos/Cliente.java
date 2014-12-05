package Acciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente 
{
    static Calendar calendario = new GregorianCalendar();
    
    public String getClave(String nombre,String fecha,String hora)
    {
        String clave;
        String nom_temp = nombre.substring(0,3).toUpperCase();
        String fecha_temp = fecha;
        String hora_temp = hora;
        String clave_temp = nom_temp+"-"+fecha_temp+"-"+hora_temp;
        clave=clave_temp;
        return clave;
    }
    
    String fecha()
    {
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        String date = año+"-"+mes+"-"+dia;
        return date;
        
    }
    String tiempo()
    {
        int horas = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        String tiempo = horas+"-"+minutos+"-"+segundos;
        return tiempo;
    }
    
    public double tipo(String tipo)
    {
        double descuento = 0;
        if(tipo.equals("Ordinario"))
        {
            descuento = 0;
        }else if(tipo.equals("Estudiante"))
        {
            descuento = 0.1;
        }else if(tipo.equals("Nino"))
        {
            descuento = 0.2;
        }
        return descuento;
    }
}