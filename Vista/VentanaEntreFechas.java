package Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JPanel;

import Modelo.Factura;
import Modelo.Genericos;
import Modelo.Llamada;
import Modelo.RelacionClientes;
import Modelo.RelacionFacturas;
import Modelo.RelacionLlamadas;
import Modelo.clientes.Cliente;

public class VentanaEntreFechas {
	Date inicio, fin;
	public VentanaEntreFechas(Date inicio, Date fin) {
		// TODO Auto-generated constructor stub
		this.inicio=inicio;
		this.fin=fin;
	}
	public JPanel addEntreFechas(RelacionClientes clientes) {
		// TODO Auto-generated method stub
		JPanel devolver = new JPanel();
		Set<Cliente> clients = Genericos.entreFechas(clientes.getClientes(), inicio, fin);
		String [] cadenas = new String[clients.size()];
		Iterator iter = clients.iterator();
		for(int i=0; i<clients.size(); i++) {
			Cliente aux = (Cliente) iter.next();
			cadenas[i] = aux.toString();
		}
		JList lista = new JList(cadenas);
		lista.setPreferredSize(new Dimension(500, 500));
		devolver.add(lista);
		return devolver;
	}

	public JPanel addEntreFechas(RelacionLlamadas llamadas, Cliente cliente) {
		// TODO Auto-generated method stub
		JPanel devolver = new JPanel();
		Set<Llamada> llamads = Genericos.entreFechas(llamadas.llamadasDelCliente(cliente), inicio, fin);
		String [] cadenas = new String[llamads.size()];
		Iterator iter = llamads.iterator();
		for(int i=0; i<llamads.size(); i++) {
			Llamada aux = (Llamada) iter.next();
			cadenas[i] = "asdf";
		}
		JList lista = new JList(cadenas);
		lista.setPreferredSize(new Dimension(500, 500));
		devolver.add(lista);
		return devolver;
	}

	public JPanel addEntreFechas(RelacionFacturas facturas, Cliente cliente) {
		// TODO Auto-generated method stub
		JPanel devolver = new JPanel();
		Set<Factura> aux = facturas.facturasDelCliente(cliente);
		Set<Factura> facts = Genericos.entreFechas(aux, inicio, fin);
		Iterator iter = facts.iterator();
		String [] cadenas = new String[facts.size()];
		for(int i=0; i<facts.size(); i++) {
			Factura aux2 = (Factura) iter.next();
			cadenas[i] = aux2.toString();
		}
		JList lista = new JList(cadenas);
		lista.setPreferredSize(new Dimension(500, 500));
		devolver.add(lista);
		return devolver;
	}
	
}
