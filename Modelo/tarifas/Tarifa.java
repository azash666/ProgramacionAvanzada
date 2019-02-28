package Modelo.tarifas;

import java.util.Date;

public class Tarifa {
	private double valor;
	
	public Tarifa() {
		valor=0;
	}
	
	public Tarifa(double tarifa) {
		// TODO Auto-generated constructor stub
		this.valor=tarifa;
	}

	public Tarifa putTarifa(double valor) {
		this.valor=valor;
		return this;
	}
	
	public double getTarifa(Date horaActual) {
		return valor;
	}
	
	
	
	public static double minimo(double A, double B) {
		if(A<B) {
			return A;
		}
		return B;
		
	}
}
