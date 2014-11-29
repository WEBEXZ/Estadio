package Base_Datos;

public class Partido 
{
    private int id_partido;
    public String visitante;
    private String fecha;
    private String hora;
    private int  id_temporada;
    
    public Partido(int id_partido,String visitante,String fecha, String hora,int id_temporada)
    {
    	this.id_partido=id_partido;
        this.visitante=visitante;
        this.fecha=fecha;
        this.hora=hora;
        this.id_temporada=id_temporada;
    }
    
    
    public int get_id_partido()
    {
        return id_partido;
    }
    
    public String ListaPartidos()
    {
        return visitante;
    }
    
    public String get_fecha()
    {
        return fecha;
    }
    
    public String get_hora()
    {
        return hora;
    }

    public int getId_temporada() 
    {
        return id_temporada;
    }

    public void setId_temporada(int id_temporada) 
    {
        this.id_temporada = id_temporada;
    }
}