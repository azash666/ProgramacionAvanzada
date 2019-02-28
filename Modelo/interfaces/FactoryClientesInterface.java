package Modelo.interfaces;

import java.util.Date;
import java.util.Set;

import Modelo.Direccion;
import Modelo.clientes.Cliente;
import Modelo.tarifas.Tarifa;

public interface FactoryClientesInterface {
	public boolean esParticular();
	public void putApellidos(String apellidos);
	public void putNombre(String nombre) ;
	public void putNif(String nif);
	public void putDireccion(Direccion direc) ;
	public void putEmail(String email);
	public void putAlta(Date alta) ;
	public void putTarifa(Tarifa tarifa) ;
	public Set<Integer> getFacturasCode() ;
	public Date getFecha() ;
	public Cliente getCliente();
}
