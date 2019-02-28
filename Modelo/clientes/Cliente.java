package Modelo.clientes;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Modelo.Direccion;
import Modelo.interfaces.FechaDeAlta;
import Modelo.tarifas.Tarifa;

public class Cliente implements FechaDeAlta{
	public String nombre;
	public String nif;
	public Direccion direccion;
	public String email;
	public Date alta;
	public Tarifa tarifa;
	public Set<Integer> facturas;
	public Cliente() {
		facturas = new HashSet<Integer>();
	}
	
	public Cliente(Cliente cliente) {
		this.nombre = cliente.nombre;
		this.nif = cliente.nif;
		this.direccion = cliente.direccion;
		this.email = cliente.email;
		this.alta = cliente.alta;
		this.tarifa = cliente.tarifa;
		this.facturas=new HashSet<Integer>();
	}
	
	public Cliente putNombre(String nombre) {
		this.nombre=nombre;
		return this;
	}

	public Cliente putNif(String nif) {
		this.nif=nif;
		return this;
	}

	public Cliente putDireccion(Direccion direc) {
		this.direccion=direc;
		return this;
	}

	public Cliente putEmail(String email) {
		this.email=email;
		return this;
	}
	
	public Cliente putAlta(Date alta) {
		this.alta=alta;
		return this;
	}
	
	public Cliente putAlta() {
		this.alta=new Date();
		return this;
	}
	
	public Cliente putTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
		return this;
	}
	
	public Cliente putTarifa() {
		this.tarifa=new Tarifa();
		return this;
	}
	
	public String getDni() {
		return this.nif;
	}

	public Set<Integer> getFacturasCode() {
		return facturas;
	}

	public Date getFecha() {
		// TODO Auto-generated method stub
		return alta;
	}
	
	public String toString() {
		String devolver = "";
		devolver =  nif +"  |  "+ nombre+"  |  "+ direccion+ "  |  "+ email+"  |  "+  alta.getDay()+"/"+ alta.getMonth()+"/"+alta.getYear();
		return devolver;
	}
}
