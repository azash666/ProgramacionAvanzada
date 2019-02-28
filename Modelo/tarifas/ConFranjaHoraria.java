package Modelo.tarifas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConFranjaHoraria extends Tarifa{
	private Tarifa tarifa;
	private float horaInicio, horaFinal;
	
	public ConFranjaHoraria(Tarifa tarifa) {
		super();
		this.tarifa = tarifa;
		horaInicio=0;
		horaFinal=23.99f;
	}
	
	public ConFranjaHoraria(Tarifa tarifa, double precio, float horaInicio, float horaFinal) {
		super(precio);
		this.tarifa = tarifa;
		putHoraInicio(horaInicio);
		putHoraFinal(horaFinal);
	}
	
	@Override
	public Tarifa putTarifa(double valor) {
		super.putTarifa(valor);
		return this;
	}
	
	@Override
	public double getTarifa(Date horaActual) {
		double tarifaActual;
		SimpleDateFormat h = new SimpleDateFormat("hh");
		float hora = Float.parseFloat(h.format(horaActual));
		SimpleDateFormat m = new SimpleDateFormat("mm");
		hora += Float.parseFloat(m.format(horaActual))/60f;
		SimpleDateFormat s = new SimpleDateFormat("ss");
		hora += Float.parseFloat(s.format(horaActual))/3600f;
		if(hora>=horaInicio && hora<=horaFinal) {
			tarifaActual=super.getTarifa(horaActual);
		}else{
			tarifaActual=tarifa.getTarifa(horaActual);
		}
		return Tarifa.minimo(tarifaActual, tarifa.getTarifa(horaActual));
	}
	
	
	public ConFranjaHoraria putHoraInicio(float horaInicio) {
		while(horaInicio>=24)
			horaInicio=horaInicio-24;
		this.horaInicio=horaInicio;
		return this;
	}
	
	public ConFranjaHoraria putHoraFinal(float horaFinal) {
		while(horaFinal>=24)
			horaFinal=horaFinal-24;
		this.horaFinal=horaFinal;
		return this;
	}
}
