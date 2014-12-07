package com.example.alebrijes;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends Activity{
	private static String KEY_MSG="KEY_MSG";
	private static String KEY_ENCUENTRO="KEY_ENCUENTRO";
	private static String KEY_NOMBRE="KEY_NOMBRE";
	private static String KEY_PRECIO="KEY_PRECIO";
	private static String KEY_NBOLETOS="KEY_NBOLETOS";
	private static String KEY_FECHA="KEY_FECHA";
	private static String KEY_HORA="KEY_HORA";
	private static String KEY_CAMARA="KEY_CAMARA";
	private static String KEY_CLAVE="KEY_CLAVE";
	private static String KEY_ID_PARTIDO="KEY_ID_PARTIDO";
	private static String KEY_ID_ZONA="KEY_ID_ZONA";
	private static String KEY_ID_AREA="KEY_ID_AREA";
	private static String KEY_TIPO_CLIENTE="KEY_TIPO_CLIENTE";
	private static String KEY_T_BOL="KEY_T_BOL";
	private Spinner partidos,zona,area,descuento;
	private EditText boletos_disponibles,nombre,nboletos;
	private CheckBox check;
	private String clave="hola mundo",id_partido="",id_zona="",id_area="",tipo_cliente,precioU="",t_bol="";
	private TextView precio,fecha,hora;
	private partidos part[];
	private area are[];
	private String[] Jornadas={"Sin partidos"}; 
	conexion c;
	private String[] Zonas= {"GOL NORTE", "GOL SUR", "PREFERENTE","GENERAL"};
	private String[] Descuentos={ "Ordinario", "Estudiante", "Niño"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(this,"Cargando datos...",2).show();
        Thread tr = new Thread(){
			@Override
			public void run(){
				c=new conexion();
				String partidoss=c.HacerConsulta("select * from partidos");
				String datos[]=partidoss.split("nn");
		        Jornadas=new String[datos.length];
		        part=new partidos[datos.length];
		        for(int x=0;x<datos.length;x++){
		        			String datosPartido[]=datos[x].split(";");
		        	partidos p=new partidos(datosPartido[0],datosPartido[1],datosPartido[2],datosPartido[3],datosPartido[4]);
		        	Jornadas[x]="ALEBRIJES VS "+p.getVisitante();
		        	part[x]=p;
		        } 
				System.out.println(partidoss);
				for(int x=0;x<datos.length;x++){
					System.out.println(Jornadas[x]);					
				}
			}			
		};
		tr.start();	
		 Thread trr = new Thread(){
				@Override
				public void run(){
					c=new conexion();
					String areass=c.HacerConsulta("select * from areas");
					String datos[]=areass.split("nn");
			        are=new area[datos.length];
			        for(int x=0;x<datos.length;x++){
			        	String datosArea[]=datos[x].split(";");
			        	area a=new area(datosArea[0],datosArea[1],datosArea[2],datosArea[3],datosArea[4],datosArea[5],datosArea[6],datosArea[7]);
			        	are[x]=a;
			        } 
					System.out.println(areass);
					for(int x=0;x<datos.length;x++){
						System.out.println(are[x].getNum_boletos());					
					}
				}			
			};
			trr.start();	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inicializar();
		rellenarDatos();
		final Button comprar = (Button) findViewById(R.id.buttonComprar);
		comprar.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			/*if(nombre.equals("") || nboletos.equals("") || t_bol.equals("0") ||Integer.parseInt(t_bol)<Integer.parseInt(nboletos.getText().toString()))
			{
			}
			else{*/
			if(nombre.length()>=3 && !nboletos.getText().toString().equals("") && Integer.parseInt(nboletos.getText().toString())<=Integer.parseInt(boletos_disponibles.getText().toString()) &&Integer.parseInt(nboletos.getText().toString())>0){
			String BC="false";
			String tipo_cliente=descuento.getSelectedItem().toString();
			if(check.isChecked()){
				BC="true";
			}
			Intent ayuda=new Intent(MainActivity.this,Venta.class);
			ayuda.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			ayuda.putExtra(KEY_ENCUENTRO,partidos.getSelectedItem().toString());
			ayuda.putExtra(KEY_NOMBRE,nombre.getText().toString());
			ayuda.putExtra(KEY_PRECIO,precioU);
			ayuda.putExtra(KEY_NBOLETOS,nboletos.getText().toString());
			ayuda.putExtra(KEY_FECHA,fecha.getText().toString());
			ayuda.putExtra(KEY_HORA,hora.getText().toString());
			ayuda.putExtra(KEY_CLAVE,clave);
			ayuda.putExtra(KEY_ID_PARTIDO,id_partido);
			ayuda.putExtra(KEY_ID_ZONA,id_zona);
			ayuda.putExtra(KEY_ID_AREA,id_area);
			ayuda.putExtra(KEY_TIPO_CLIENTE,tipo_cliente);
			ayuda.putExtra(KEY_T_BOL,t_bol);
			ayuda.putExtra(KEY_CAMARA,BC);
			startActivity(ayuda);
		//}
			}		
			else{			
			}
		}
		});
		
		
		
		//ESTE CODIGO ES PARA EL BOTON SIGUIENTE
	      Button  next = (Button)findViewById(R.id.buttonSiguiente);
	        next.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View view) {
	            	 if(!partidos.getSelectedItem().toString().equals("Sin partidos")){
	                   ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
	                   vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_in_right));
	                   vf.showNext();
	                   String NoZ=zona.getSelectedItem().toString();
	                   String NoA=area.getSelectedItem().toString();
	                   int NuZ=0;
	                   int NuA=0;
	                   if(NoZ.equals("GOL NORTE")){NuZ=1;}
	                   if(NoZ.equals("GOL SUR")){NuZ=2;}
	                   if(NoZ.equals("PREFERENTE")){NuZ=4;}
	                   if(NoZ.equals("GENERAL")){NuZ=4;}
	                   if(NoA.equals("ALTA")){NuA=1;}
	                   if(NoA.equals("BAJA")){NuA=2;}
	                   if(NoA.equals("CENTRAL")){NuA=3;}
	                   if(NoA.equals("VIP")){NuA=4;}
	                   if(NoA.equals("PALCOS")){NuA=5;}
	                  final int id_part=partidos.getSelectedItemPosition()+1;
	                  final String id_ar=""+NuA;
	                  final String id_zon=""+NuZ;
	                  id_zona=id_zon;
	                  id_area=id_ar;
	                  int NN=0;
	                  for(int y=0;y<are.length;y++){
	                	  if(are[y].getId_Temporada().equals("1") && are[y].getId_Partido().equals(""+id_part) && are[y].getId_zona().equals(id_zon) && are[y].getId_area().equals(id_ar)){
	                		  NN=Integer.parseInt(are[y].getBoletos_disp());
	                		  precioU=are[y].getPrecio_boleto();
	                		  t_bol=are[y].getBoletos_disp();
	                	  }          	  
	                  }
	                  boletos_disponibles.setText(""+NN);
	                  
	            	 }
	             }
	        });
	        //ESTE CODIGO ES PARA EL BOTON ATRAS
	        Button previous = (Button)findViewById(R.id.buttonAtras);
	        previous.setOnClickListener(new View.OnClickListener() {
	              public void onClick(View view) {
	                    ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
	                    vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_in_left));
	                    vf.showPrevious();
	              }
	        });  
	}

	public void inicializar(){
		check=(CheckBox)findViewById(R.id.checkBoxPorra);
		boletos_disponibles=(EditText)findViewById(R.id.editText1);
		boletos_disponibles.setEnabled(false);
		nombre= (EditText)findViewById(R.id.editText2);
		precio= (TextView)findViewById(R.id.textView10);
		nboletos= (EditText)findViewById(R.id.editText4);
		fecha= (TextView)findViewById(R.id.textView8);
		hora=(TextView)findViewById(R.id.textView10);
		partidos =(Spinner)findViewById(R.id.spinnerJornada);
		zona = (Spinner)findViewById(R.id.spinner2);
		area = (Spinner)findViewById(R.id.spinner3);
		descuento = (Spinner)findViewById(R.id.spinnerDescuentp);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void siguiente(View v){
		Intent ayuda=new Intent(MainActivity.this,Venta.class);
		startActivity(ayuda);
	}
	public void mostrarMensaje(){
		Toast.makeText(this,"Faltan datos", 0).show();
	}
	public void rellenarDatos(){
		//EN ESTE METODO RELLENAMOS LOS DATOS DE LOS SPINNER
		
		  //EN ESTA PARTE GUARDAMOS LAS ZONAS DISPONIBLES
        ArrayAdapter countryAdapter2 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,Zonas);
        zona.setAdapter(countryAdapter2);
        
        //EN ESTA PARTE GUARDAMOS EL AREA DISPONIBLE
        String selec=zona.getSelectedItem().toString();
        ArrayAdapter countryAdapter3 = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] { "ALTA", "BAJA","CENTRAL","VIP","PALCOS"});
        	area.setAdapter(countryAdapter3);
        	
        //EN ESTA PARTE GUARDAMOS LOS DESCUENTOS
        ArrayAdapter countryAdapterDESCUENTOS = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,Descuentos);
        descuento.setAdapter(countryAdapterDESCUENTOS);  
        
        
		
		//EN ESTE SPINNER GUARDAREMOS LOS PARTIDOS QUE ESTAN DISPONIBLES 
	        ArrayAdapter countryAdapter = new ArrayAdapter(this,
	                android.R.layout.simple_spinner_dropdown_item,Jornadas);
	        partidos.setAdapter(countryAdapter);
	        try{
	        partidos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
						@Override
						public void onItemSelected(AdapterView<?> arg0,View arg1, int i, long arg3) {
							// TODO Auto-generated method stub
							if(!partidos.getSelectedItem().toString().equals("Sin partidos")){
								fecha.setText(""+part[i].getFecha());
								hora.setText(""+part[i].getHora());								
								id_partido=part[i].getId_partido();
							}
							if(partidos.getSelectedItem().toString().equals("Sin partidos")){
								rellenarDatos();
							}
						}
						@Override
						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub
						}
			});}
	        catch(Exception e){
	        }
	}

}
