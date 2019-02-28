package Controlador;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Modelo.RelacionClientes;
import Modelo.RelacionFacturas;
import Modelo.RelacionLlamadas;
import Vista.VentanaClientes;
import Vista.VentanaFacturas;
import Vista.VentanaLlamadas;

public class ListController implements ListSelectionListener {
	private int anterior = -1;
	private int actual = -1;
	private JPanel pral;
	private RelacionClientes clientes;
	private RelacionFacturas facturas;
	private RelacionLlamadas llamadas;
	public ListController(JPanel pral, RelacionClientes clientes, RelacionFacturas facturas, RelacionLlamadas llamadas) {
		this.pral = pral;
		this.clientes = clientes;
		this.facturas = facturas;
		this.llamadas = llamadas;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		anterior = actual;
		JList aux = (JList)e.getSource();
		actual=aux.getSelectedIndex();
		
		if(anterior != actual) {
			System.out.println(actual);
			VentanaClientes vc = new VentanaClientes(clientes);
			VentanaLlamadas vl = new VentanaLlamadas(llamadas, clientes);
			VentanaFacturas vf = new VentanaFacturas(facturas, clientes);
			pral.removeAll();
			switch (actual) {
			case 0: 
				pral.add(vc.addAltaCliente());
				break;

			case 1: 
				pral.add(vc.addBorrarCliente());
				break;

			case 2: 
				pral.add(vc.addCambiarTarifa());
				break;

			case 3: 
				pral.add(vc.addRecuperarPorNif());
				break;

			case 4: 
				pral.add(vc.addListado());
				break;

			case 5: 
				pral.add(vc.addEntreFechas());
				break;

			case 6: 
				pral.add(vl.addAltaLlamada());
				break;

			case 7: 
				pral.add(vl.addListado());
				break;

			case 8: 
				pral.add(vl.addEntreFechas());
				break;
			case 9:
				pral.add(vf.addAltaFactura());
				break;
			case 10:
				pral.add(vf.addBorrarFactura());
				break;
			case 11:
				pral.add(vf.addRecuperarPorCliente());
				break;
			case 12:
				pral.add(vf.addEntreFechas());
				break;
			}
			pral.validate();
			pral.repaint();
		}
	}

}
