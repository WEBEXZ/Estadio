package com.example.alebrijes;

import java.util.Date;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Venta extends Activity {
	private TextView TFecha,TPartido,TNombre,TNBoletos,TPrecio,TClave;
	private ImageView foto,imageView;
	private Bitmap bitmap,bmp;
	private Intent i;
	final static int cons=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_venta);
		Inicializar();
		String Kencuentro=getIntent().getExtras().getString("KEY_ENCUENTRO");
		String Knombre=getIntent().getExtras().getString("KEY_NOMBRE");
		String Kprecio=getIntent().getExtras().getString("KEY_PRECIO");
		String Knboletos=getIntent().getExtras().getString("KEY_NBOLETOS");
		String Kfecha=getIntent().getExtras().getString("KEY_FECHA");
		String Khora=getIntent().getExtras().getString("KEY_HORA");
		String qrData=getIntent().getExtras().getString("KEY_CLAVE");
		String BCam=getIntent().getExtras().getString("KEY_CAMARA");
		String Kid_partido=getIntent().getExtras().getString("KEY_ID_PARTIDO");
		String Kid_zona=getIntent().getExtras().getString("KEY_ID_ZONA");
		String Kid_area=getIntent().getExtras().getString("KEY_ID_AREA");
		String Ktipo_cliente=getIntent().getExtras().getString("KEY_TIPO_CLIENTE");
		final String Kt_bol=getIntent().getExtras().getString("KEY_T_BOL");
		Date horaActual=new Date();
		String hora=(horaActual.getYear()+1900)+"-"+(horaActual.getMonth()+1)+"-"+horaActual.getDate()+"-"+horaActual.getHours()+"-"+horaActual.getMinutes()+"-"+horaActual.getSeconds();
		final String id_zona=Kid_zona,id_area=Kid_area,id_temporada="1",id_partido=Kid_partido,nom_cliente=Knombre,tipo_cliente=Ktipo_cliente,fecha_compra=(horaActual.getYear()+1900)+"-"+(horaActual.getMonth()+1)+"-"+horaActual.getDate(),precio_total=""+descuento((Integer.parseInt(Kprecio)*Integer.parseInt(Knboletos)),tipo_cliente),n_boletos=Knboletos;
		final String id_boleto=""+nom_cliente.charAt(0)+nom_cliente.charAt(1)+nom_cliente.charAt(2)+"-"+hora;
		if(BCam.equals("true")){
			capturar();
		}
		else{}
		TFecha.setText("Fecha: "+Kfecha);
		TPartido.setText(Kencuentro);
		TNombre.setText("Nombre: "+Knombre);
		TNBoletos.setText("Boletos: "+Knboletos);
		TPrecio.setText("Precio: "+precio_total);
		TClave.setText(id_boleto);
		int qrCodeDimention = 400;
		QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(id_boleto, null,
		        Contents.Type.TEXT, BarcodeFormat.QR_CODE.toString(), qrCodeDimention);
		try {
		    bitmap = qrCodeEncoder.encodeAsBitmap();
		    imageView.setImageBitmap(bitmap);
		} catch (WriterException e) {
		    e.printStackTrace();
		}
		//
		System.out.println("insert into boletos values("+id_boleto+","+id_zona+","+id_area+","+id_temporada+","+id_partido+","+nom_cliente+","+tipo_cliente+","+fecha_compra+","+precio_total+","+n_boletos+")");
		System.out.println("update areas set boletos_disp="+(Integer.parseInt(Kt_bol)-Integer.parseInt(n_boletos))+" where id_temporada=1 and id_partido="+id_partido+" and id_zona="+id_zona+" and id_area="+id_area);
		//
		Thread tr = new Thread(){
			@Override
			public void run(){
				conexionModificar c=new conexionModificar();
				c.IngresarDatos("INSERT INTO  boletos (id_boleto,id_zona,id_area,id_temporada,id_partido,nom_cliente,tipo_cliente,fecha_compra,precio_total,n_boletos) VALUES ('"+id_boleto+"',"+id_zona+","+id_area+","+id_temporada+","+id_partido+",'"+nom_cliente+"','"+tipo_cliente+"','"+fecha_compra+"',"+precio_total+","+n_boletos+");");
			}			
		};
		tr.start();	
		Thread trr = new Thread(){
			@Override
			public void run(){
				conexionModificar c=new conexionModificar();
				c.IngresarDatos("UPDATE areas SET boletos_disp="+(Integer.parseInt(Kt_bol)-Integer.parseInt(n_boletos))+" WHERE id_temporada = 1 and id_partido = "+id_partido+" and id_zona = "+id_zona+" and id_area = "+id_area+";");
			}			
		};
		trr.start();	
	}
	public void Inicializar(){//Este metodo sirve para inicializar todas las variables que se ocupan 
		foto=(ImageView)findViewById(R.id.imgFoto);
		 imageView = (ImageView) findViewById(R.id.qrCode);
		 TFecha=(TextView)findViewById(R.id.textViewFecha);
		 TPartido=(TextView)findViewById(R.id.textViewPartido);
		 TNombre=(TextView)findViewById(R.id.textViewNombre);
		 TNBoletos=(TextView)findViewById(R.id.textViewNBoletos);
		 TPrecio=(TextView)findViewById(R.id.textViewPrecio);
		 TClave=(TextView)findViewById(R.id.textViewClave);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.venta, menu);
		return true;
	}
	public void capturar(){
		i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(i,cons);
	}
	@Override
	protected void onActivityResult(int requestCode,int resultCode,Intent data)
	{
	super.onActivityResult(requestCode, resultCode, data);
	if(resultCode==Activity.RESULT_OK){
		Bundle ext=data.getExtras();
		bmp=(Bitmap)ext.get("data");
		foto.setImageBitmap(bmp);
	}
	}
	public int descuento(int precio,String Cliente){
		if(Cliente.equals("Estudiante")){
			precio=(precio*90)/100;			
		}
		if(Cliente.equals("Niño")){
			precio=(precio*80)/100;			
		}		
		return precio;
	}
}
