package Modelo;
import java.util.Date;

import Modelo.clientes.Cliente;
import Modelo.interfaces.FechaDeAlta;
import Modelo.tarifas.Tarifa;

public class Factura implements FechaDeAlta {
	public Date fechaEmision;
	public Date fechaInicio;
	public Date fechaFin;
	public float importe;
	public Tarifa tarifa;
	public Cliente cliente;
	
	public Factura(Cliente cliente) {
		this.tarifa=cliente.tarifa;
		this.cliente=cliente;
		fechaEmision= new Date();
	}
	
	public void cambiaTarifa(Tarifa tarifa) {
		this.tarifa=tarifa;
	}
	
	public Factura putFechaInicio(Date fechaInicio) {
		this.fechaInicio=fechaInicio;
		return this;
	}

	public Factura putFechaFin(Date fechaFin) {
		this.fechaFin=fechaFin;
		return this;
	}
	
	public Factura putFechaEmision(Date fecha) {
		this.fechaEmision=fecha;
		return this;
	}
	
	public Factura putImporte(float importe) {
		this.importe=importe;
		return this;
	}
	
	public Factura putTarifa(Tarifa tarifa) {
		this.tarifa=tarifa;
		return this;
	}
	
	public Date getFecha() {
		// TODO Auto-generated method stub
		return fechaEmision;
	}

	@Override
	public String toString() {
		return cliente.nif+"  |  Emision: "+fechaEmision+"  |  Inicio "+fechaInicio+"  |  Fin: "+fechaFin;
	}
	
	
}
