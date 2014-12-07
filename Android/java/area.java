package com.example.alebrijes;

public class area {
	private String id_Temporada,id_Partido,id_zona,id_area,nom_area,num_boletos,boletos_disp,precio_boleto;

	public String getId_Temporada() {
		return id_Temporada;
	}

	public area(String id_Temporada, String id_Partido, String id_zona,
			String id_area, String nom_area, String num_boletos,
			String boletos_disp, String precio_boleto) {
		super();
		this.id_Temporada = id_Temporada;
		this.id_Partido = id_Partido;
		this.id_zona = id_zona;
		this.id_area = id_area;
		this.nom_area = nom_area;
		this.num_boletos = num_boletos;
		this.boletos_disp = boletos_disp;
		this.precio_boleto = precio_boleto;
	}

	public void setId_Temporada(String id_Temporada) {
		this.id_Temporada = id_Temporada;
	}

	public String getId_Partido() {
		return id_Partido;
	}

	public void setId_Partido(String id_Partido) {
		this.id_Partido = id_Partido;
	}

	public String getId_zona() {
		return id_zona;
	}

	public void setId_zona(String id_zona) {
		this.id_zona = id_zona;
	}

	public String getId_area() {
		return id_area;
	}

	public void setId_area(String id_area) {
		this.id_area = id_area;
	}

	public String getNom_area() {
		return nom_area;
	}

	public void setNom_area(String nom_area) {
		this.nom_area = nom_area;
	}

	public String getNum_boletos() {
		return num_boletos;
	}

	public void setNum_boletos(String num_boletos) {
		this.num_boletos = num_boletos;
	}

	public String getBoletos_disp() {
		return boletos_disp;
	}

	public void setBoletos_disp(String boletos_disp) {
		this.boletos_disp = boletos_disp;
	}

	public String getPrecio_boleto() {
		return precio_boleto;
	}

	public void setPrecio_boleto(String precio_boleto) {
		this.precio_boleto = precio_boleto;
	}

	
}
