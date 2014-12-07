package com.example.alebrijes;

public class partidos {
String id_temporada,id_partido,visitante,fecha,hora;
public partidos(String id_temporada, String id_partido, String visitante,String fecha, String hora) {
	this.id_temporada = id_temporada;
	this.id_partido = id_partido;
	this.visitante = visitante;
	this.fecha = fecha;
	this.hora = hora;
}
public String getId_temporada() {
	return id_temporada;
}
public void setId_temporada(String id_temporada) {
	this.id_temporada = id_temporada;
}
public String getId_partido() {
	return id_partido;
}
public void setId_partido(String id_partido) {
	this.id_partido = id_partido;
}
public String getVisitante() {
	return visitante;
}
public void setVisitante(String visitante) {
	this.visitante = visitante;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getHora() {
	return hora;
}
public void setHora(String hora) {
	this.hora = hora;
}

}
