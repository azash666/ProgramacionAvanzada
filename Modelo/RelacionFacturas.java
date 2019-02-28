package Modelo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Modelo.clientes.Cliente;
import Modelo.tarifas.Tarifa;

public class RelacionFacturas {
	Map<Integer, Factura> relacion;	//El Integer es el codigo de la factura
	int cantidad;
	
	public RelacionFacturas() {
		relacion= new HashMap<Integer, Factura>();
		cantidad=0;
	}
	
	public Factura nuevaFactura(Cliente cliente) {
		Factura nueva = new Factura(cliente);
		relacion.put(++cantidad, nueva);
		cliente.facturas.add(cantidad);
		return nueva;
	}
	
	public int modificaFactura(int codigo, Factura factura) {
		relacion.put(codigo, factura);
		return codigo;
	}
	
	public int modificaTarifa(int codigo, Tarifa tarifa) {
		relacion.get(codigo).cambiaTarifa(tarifa);
		return codigo;
	}
	
	public Factura getFactura(int codigo) {
		return relacion.get(codigo);
	}


	public double emitirFactura(Cliente client) {
		double devolver = 0;
		Set<Integer> codigos = client.getFacturasCode();
		Iterator<Integer> iter = codigos.iterator();
		while(iter.hasNext()) {
			Factura aux = relacion.get(iter.next());
			devolver=devolver+aux.tarifa.getTarifa(aux.fechaInicio)*(double)(aux.fechaFin.getTime()-aux.fechaInicio.getTime())/60.0;
		}
		return devolver;
	}
	
	public Set<Factura> facturasDelCliente(Cliente cliente){
		Set<Factura> devolver = new HashSet<Factura>();
		Set<Integer> codigos = cliente.getFacturasCode();
		Iterator<Integer> iter = codigos.iterator();
		while(iter.hasNext()) {
			devolver.add(relacion.get(iter.next()));
		}
		return devolver;
	}
	
	public void saveFacturas() {
		FicheroDriver fd = new FicheroDriver();
		fd.openSave("facturas.txt");
		Iterator<Integer> iter = relacion.keySet().iterator();
		while(iter.hasNext()) {
			int aux = iter.next();
			fd.saveInt(aux);
			fd.saveFactura(relacion.get(aux));
		}
		fd.closeSave();
	}

	public void loadFacturas() {
		FicheroDriver fd = new FicheroDriver();
		fd.openLoad("facturas.txt");
		while(fd.hasNextLine()) {
			relacion.put(fd.loadInt(fd.readNextLine()), fd.loadFactura(fd.readNextLine()));
		}
		fd.closeLoad();
	}
}
