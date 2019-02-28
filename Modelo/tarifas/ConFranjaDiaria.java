package Modelo.tarifas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConFranjaDiaria extends Tarifa{
	private Tarifa tarifa;
	private int dia;
	
	
	public ConFranjaDiaria(Tarifa tarifa, double valor, int dia) {
		this.dia=dia;
		this.tarifa = tarifa;
		super.putTarifa(valor);
	}
	
	@Override
	public Tarifa putTarifa(double valor) {
		super.putTarifa(valor);
		return this;
	}
	
	@Override
	public double getTarifa(Date horaActual) {
		double tarifaActual;
		SimpleDateFormat sdf = new SimpleDateFormat("u");
		int diaActual = Integer.parseInt(sdf.format(horaActual));
		if(diaActual==dia) {
			tarifaActual=super.getTarifa(horaActual);
		}else{
			tarifaActual=tarifa.getTarifa(horaActual);
		}
		return Tarifa.minimo(tarifaActual, tarifa.getTarifa(horaActual));
		
	}
}
