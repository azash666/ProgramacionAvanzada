package Modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Modelo.clientes.Cliente;

public class RelacionClientes {
	//private Set<Cliente> clientes;
	private Map <String, Cliente> clientes;
	
	public RelacionClientes() {
		clientes= new HashMap<String, Cliente>();
	}
	
	public Cliente anadeCliente(Cliente cliente) {
		if(cliente.nif==null){
			return null;
		}
		//clientes.add(cliente);
		clientes.put(cliente.nif, cliente);
		return cliente;
	}
	
	public boolean borraCliente(Cliente cliente) {
		//return clientes.remove(cliente);
		String nif = cliente.nif;
		if(clientes.containsKey(nif)) {
			clientes.remove(nif);
			return true;
		}
		return false;
	}
	
	public Cliente getCliente(String nif) {
		if(clientes.containsKey(nif)) {
			return clientes.get(nif);
		}
		return null;
	}
	
	public boolean existeCliente(String nif) {
		return clientes.containsKey(nif);
	}
	
	public Set<Cliente> listadoClientes(){
		Set<Cliente> devolver = new HashSet<Cliente>();
		Iterator iter = clientes.keySet().iterator();
		while(iter.hasNext()) {
			devolver.add(clientes.get(iter.next()));
		}
		return devolver;
	}
	
	public Cliente[] getArray() {
		Set<Cliente> aux = listadoClientes();
		Iterator<Cliente> iter = aux.iterator();
		Cliente[] devolver = new Cliente[aux.size()];
		int i=0;
		while(iter.hasNext()) {
			devolver[i] = iter.next();
			i++;
		}
		return devolver;
	}
	
	public Set<Cliente> getClientes(){
		return listadoClientes();
	}
	public void saveClientes() {
		FicheroDriver fd = new FicheroDriver();
		fd.openSave("clientes.txt");
		Set<Cliente> aux = listadoClientes();
		Iterator<Cliente> iter = aux.iterator();
		while(iter.hasNext()) {
			fd.saveCliente(iter.next());
		}
		fd.closeSave();
	}
	
	public void loadClientes() {
		FicheroDriver fd = new FicheroDriver();
		fd.openLoad("clientes.txt");
		while(fd.hasNextLine()) {
			Cliente aux = fd.loadCliente(fd.readNextLine());
			clientes.put(aux.nif, aux);
		}
		fd.closeLoad();
	}
}
