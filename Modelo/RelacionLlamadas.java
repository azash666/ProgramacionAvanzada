package Modelo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Modelo.clientes.Cliente;

public class RelacionLlamadas {
	Map<Llamada, Cliente> llamadas;
	
	public RelacionLlamadas() {
		llamadas= new HashMap<Llamada, Cliente>();
	}
	
	public void addLlamada(Llamada llamada, Cliente cliente) {
		llamadas.put(llamada, cliente);
	}
	
	public Set<Llamada> llamadasDelCliente(Cliente cliente){
		Set<Llamada> devolver = new HashSet<Llamada>();
		Iterator<Llamada> iter = llamadas.keySet().iterator();
		while(iter.hasNext()) {
			Llamada aux = iter.next();
			if(llamadas.get(aux)==cliente) {
				devolver.add(aux);
			}
		}
		return devolver;
	}
	
	public void saveLlamadas() {
		FicheroDriver fd = new FicheroDriver();
		fd.openSave("llamadas.txt");
		Iterator<Llamada> iter = llamadas.keySet().iterator();
		while(iter.hasNext()) {
			Llamada aux = iter.next();
			fd.saveLlamada(aux);
			fd.saveCliente(llamadas.get(aux));
		}
		fd.closeSave();
	}
	

	public void loadLlamadas() {
		FicheroDriver fd = new FicheroDriver();
		fd.openLoad("llamadas.txt");
		while(fd.hasNextLine()) {
			llamadas.put(fd.loadLlamada(fd.readNextLine()), fd.loadCliente(fd.readNextLine()));
		}
		fd.closeLoad();
	}

	public String[] getArray() {
		String[] aux = new String[llamadas.size()];
		Iterator<Llamada> iter = llamadas.keySet().iterator();
		int i=0;
		while(iter.hasNext()) {
			Llamada llam = iter.next();
			Cliente cli = llamadas.get(llam);
			aux[i] = cli.nif+"  |  "+llam;
			i++;
		}
		return aux;
	}
}
