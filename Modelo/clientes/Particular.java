package Modelo.clientes;

import Modelo.exceptions.InvalidDniException;

public class Particular extends Cliente {
	
	
	public String apellidos;

	public Particular() {
		
	}
	
	public Particular(Cliente cliente) {
		this.nombre = cliente.nombre;
		try {
			compruebaDNI(cliente.nif);
			this.nif = cliente.nif;
		} catch (InvalidDniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.direccion = cliente.direccion;
		this.email = cliente.email;
		this.alta = cliente.alta;
		this.tarifa = cliente.tarifa;
		this.apellidos = "";
	}
	
	public Particular(Particular particular) {
		this.nombre = particular.nombre;
		try {
			compruebaDNI(particular.nif);
			this.nif = particular.nif;
		} catch (InvalidDniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.direccion = particular.direccion;
		this.email = particular.email;
		this.alta = particular.alta;
		this.tarifa = particular.tarifa;
		this.apellidos = particular.apellidos;
	}
	
	public Particular putNif(String nif) {
		try {
			compruebaDNI(nif);
			this.nif = nif;
		} catch (InvalidDniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public Particular putApellidos(String apellidos) {
		this.apellidos=apellidos;
		return this;
	}

	public Particular putCliente(Cliente cliente) {
		this.nombre = cliente.nombre;
		try {
			compruebaDNI(cliente.nif);
			this.nif = cliente.nif;
		} catch (InvalidDniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.direccion = cliente.direccion;
		this.email = cliente.email;
		this.alta = cliente.alta;
		this.tarifa = cliente.tarifa;
		return this;
	}
	
	private void compruebaDNI(String dni) throws InvalidDniException {
		if (dni.length()== 9) {
			int numero = Integer.parseInt(dni.substring(0, 8));
			char letra = dni.toUpperCase().charAt(8);
			char[] letras = new char[] {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
			if(letras[numero%23] != letra) {
				throw new InvalidDniException();
			}
		}else {
			
			throw new InvalidDniException();
			
		}
	}
}
