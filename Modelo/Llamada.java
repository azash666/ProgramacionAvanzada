package Modelo;
import java.util.Date;

import Modelo.interfaces.FechaDeAlta;

public class Llamada implements FechaDeAlta {
	private String telefono;
	private Date fecha;
	private int duracion;
	
	public Llamada() {
		telefono = "";
		fecha = new Date();
		duracion = 0;
	}
	
	public Llamada putTelf(String telefono) {
		this.telefono=telefono;
		return this;
	}
	
	public Llamada putDuracion() {
		this.duracion=(int) (fecha.getTime()-new Date().getTime());
		return this;
	}
	
	public Llamada putDuracion(int duracion) {
		this.duracion=duracion;
		return this;
	}
	
	public Llamada putFecha(Date fecha){
		this.fecha = fecha;
		return this;
	}

	public Date getFecha() {
		// TODO Auto-generated method stub
		return fecha;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public String toString() {
		return "Fecha: "+ fecha.getYear() +"/"+ fecha.getMonth()+"/"+fecha.getDay()+" "+ fecha.getHours() +":"+ fecha.getMinutes()+":"+fecha.getSeconds()+"  |  Telefono: "+telefono+"  |  Duración: "+duracion;
	}
	
}
