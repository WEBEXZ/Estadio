package Base_Datos;

public class Temporada 
{
	private int id_temporada;
	private int num_jornada;
	private String fecha_inicio;
	private String fecha_terminacion; 

    public Temporada(int id_temporada,int num_jornada, String fecha_inicio,String fecha_terminacion )
    {
	this.id_temporada=id_temporada;
	this.num_jornada=num_jornada;
	this.fecha_inicio=fecha_inicio;
	this.fecha_terminacion=fecha_terminacion; 
    }

    public void setid_temporada(int id_temporada)
    {
	this.id_temporada=id_temporada;	
    }

    public void setid_jornada(int num_jornada)
    {
	this.num_jornada=num_jornada;	
    }

    public void setfecha_inicio(String fecha_inicio)
    {
	this.fecha_inicio=fecha_inicio;	
    }

    public void setfecha_terminacion(String fecha_terminacion)
    {
	this.fecha_terminacion=fecha_terminacion; 	
    }

    public int getid_temporada()
    {
	return id_temporada;	
    }

    public int getid_jornada()
    {
	return num_jornada;	
    }

    public String getfecha_inicio()
    {
	return fecha_inicio;	
    }

    public String getfecha_terminacion()
    {
	return fecha_terminacion; 	
    }
}