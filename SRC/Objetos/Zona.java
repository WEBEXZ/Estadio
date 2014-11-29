package Base_Datos;

public class Zona 
{
    private int id_partido;
    public String visitante;
    
    public Zona(int id_partido,String visitante)
    {
    	this.setId_partido(id_partido);
    	this.visitante=visitante;
    }
    
    public int getId_partido() 
    {
        return id_partido;
    }
    
    public void setId_partido(int id_partido) 
    {
        this.id_partido = id_partido;
    }
    
    public String getVisitante()
    {
        return visitante;
    }

    public void serVisitante(String visitante)
    {
	this.visitante=visitante;
    }
}