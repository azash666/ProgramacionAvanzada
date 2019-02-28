package Modelo.clientes;

import java.util.Date;
import java.util.Set;

import Modelo.Direccion;
import Modelo.interfaces.FactoryClientesInterface;
import Modelo.tarifas.Tarifa;

public class ClienteFactory implements FactoryClientesInterface {
	private Cliente cliente;
	private Particular particular;
	private boolean esParticular;
	
	public ClienteFactory() {
		// TODO Auto-generated constructor stub
		esParticular = false;
	}

	@Override
	public boolean esParticular() {
		// TODO Auto-generated method stub
		return esParticular;
	}

	@Override
	public void putApellidos(String apellidos) {
		// TODO Auto-generated method stub
		particular = new Particular(cliente).putApellidos(apellidos);
		cliente=null;
		esParticular=true;
	}

	@Override
	public void putNombre(String nombre) {
		// TODO Auto-generated method stub
		if(esParticular) {
			particular.putNombre(nombre);
		}else {
			cliente.putNombre(nombre);
		}
	}

	@Override
	public void putNif(String nif) {
		// TODO Auto-generated method stub
		if(esParticular) {
			particular.putNif(nif);
		}else {
			cliente.putNif(nif);
		}
	}

	@Override
	public void putDireccion(Direccion direc) {
		// TODO Auto-generated method stub
		if(esParticular) {
			particular.putDireccion(direc);
		}else {
			cliente.putDireccion(direc);
		}
	}

	@Override
	public void putEmail(String email) {
		// TODO Auto-generated method stub
		if(esParticular) {
			particular.putEmail(email);
		}else {
			cliente.putEmail(email);
		}
	}

	@Override
	public void putAlta(Date alta) {
		// TODO Auto-generated method stub
		if(esParticular) {
			particular.putAlta(alta);
		}else {
			cliente.putAlta(alta);
		}
	}

	@Override
	public void putTarifa(Tarifa tarifa) {
		// TODO Auto-generated method stub
		if(esParticular) {
			particular.putTarifa(tarifa);
		}else {
			cliente.putTarifa(tarifa);
		}
	}

	@Override
	public Set<Integer> getFacturasCode() {
		// TODO Auto-generated method stub
		if(esParticular) {
			return particular.getFacturasCode();
		}else {
			return cliente.getFacturasCode();
		}
	}

	@Override
	public Date getFecha() {
		// TODO Auto-generated method stub
		if(esParticular) {
			return particular.getFecha();
		}else {
			return cliente.getFecha();
		}
	}


	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		if(esParticular) {
			return particular;
		}else {
			return cliente;
		}
	}
	

}
