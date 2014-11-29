package Base_Datos;
import java.util.ArrayList;

public class Cliente 
{
    String nombre,TipoCliente;
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public Cliente()
    {
        this.nombre = "";
        this.TipoCliente="";
    }
    
    public Cliente(String nombre,String TipoCliente)
    {
    	 this.nombre = nombre;
         this.TipoCliente=TipoCliente;
    }
    public void setnombre(String nombre){
    	this.nombre=nombre;
    }
    public void setTipoCliente(String TipoCliente){
    	this.TipoCliente=TipoCliente;
    }
    public String getNombre(){
    	return nombre;
    }
    public String getTipoCliente(){
    	return TipoCliente;
    }
    
    public String Informacion()
    {
        String informacion = "Nombre: "+getNombre()+" Apellidos: "+getTipoCliente();
        return informacion;
    }
    
    public void agregarCliente(String nombre,String TipoCliente)
    {
        clientes.add(new Cliente(nombre,TipoCliente));
    }
    
    
    public String existe(String clave)
    {
        String encontrado = "No encontrado";
        for(int i = 0; i < clientes.size(); i++)
        {
            if(clave.equals(clientes.get(i).getTipoCliente()))
            {
                encontrado = "encontrado";
            }
        }
        return encontrado;
    }
    
    public String buscar_Nombre(String nombre)
    {
        String encontrado = "No encontrado";
        for(int i = 0; i < clientes.size(); i++)
        {
            if(nombre.equals(clientes.get(i).getNombre()))
            {
                encontrado = clientes.get(i).getNombre();
            }
        }
        return encontrado;
    }
}