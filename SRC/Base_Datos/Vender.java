package Base_Datos;

public class Vender {
	Cliente c;
        Partido p;
        Lugar L;
    
    public Vender(Cliente c, Partido p, Lugar L) 
    {
        this.c=c;
        this.p=p;
        this.L=L;
    }
    
    public int getPrecio(Lugar L,int pre,String desc) 
    {
        int Precio=0;
        Precio=pre*400;
        if(desc.equals("Alumno")){
        Precio=Precio-((Precio/100)*10);
        }
        if(desc.equals("Porra")){
        Precio=Precio-((Precio/100)*15);
        }
        if(desc.equals("Niños")){
        Precio=Precio-((Precio/100)*20);
        }
        return Precio;
    }
    
    public boolean Disponible(Lugar L,int Dis, int Cant) 
    {
        int ND=Dis;        //NUMERO DE BOLETOS DISPONIBLES
        boolean Disponible=false;
        if(L.getZona().equals("Gol Sur"))
        {
            if((ND-800)>Cant)Disponible=true;
        }
        if(L.getZona().equals("Gol Norte"))
        {
            if((ND-1500)>Cant)Disponible=true;
        }
        if(L.getZona().equals("Preferente")&&(L.getArea().equals("Palcos")||L.getArea().equals("VIP")))
        {
            if((ND-200)>Cant)Disponible=true;
        }
        return Disponible;
    }
}