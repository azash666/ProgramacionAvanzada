package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import Modelo.Factura;
import Modelo.RelacionClientes;
import Modelo.RelacionFacturas;
import Modelo.clientes.Cliente;

public class VentanaFacturas {
	RelacionFacturas facturas;
	RelacionClientes clientes;
	public VentanaFacturas(RelacionFacturas facturas, RelacionClientes clientes) {
		// TODO Auto-generated constructor stub
		this.facturas = facturas;
		this.clientes = clientes;
	}
	public JPanel addAltaFactura() {
		JPanel devolver = new JPanel();
		devolver.setLayout(new GridLayout(18,2));
		JComboBox client = new JComboBox(clientes.getArray());
		client.setPrototypeDisplayValue("text here fddsfdsadfddfasatextfdsadsfdgfgsfgsdfgsdfgffasdfs");
		JLabel nomLabel = new JLabel("Cliente: ");
		JLabel direccion1 = new JLabel("FACTURA ");
		JLabel direccion2 = new JLabel("");
		JLabel vacio1 = new JLabel("");
		JLabel vacio2 = new JLabel("");
		JLabel vacio3 = new JLabel("");
		JLabel vacio4 = new JLabel("");
		JLabel vacio5 = new JLabel("");
		JLabel vacio6 = new JLabel("");
		JLabel direccion3 = new JLabel("Fecha Inicio: ");
		JLabel direccion5 = new JLabel("Fecha Fin: ");
		JTextField direccion4 = new JTextField(20);
		JTextField direccion6 = new JTextField(20);
		JButton guardar = new JButton("Guardar");
		JButton limpiar = new JButton("Limpiar");
		JLabel direccion7 = new JLabel("Importe: ");
		JTextField direccion8 = new JTextField(20);
		limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				client.setSelectedItem(null);
				direccion4.setText("");
				direccion6.setText("");
				direccion8.setText("");
			}
		});
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = (Cliente)client.getSelectedItem();
				Date fechaInicio, fechaFin, fecha;
				float factura = Float.parseFloat(direccion8.getText());
				fecha = new Date();
				fechaInicio =new Date(Long.parseLong(direccion4.getText()));
				fechaFin =new Date(Long.parseLong(direccion6.getText()));
				
				facturas.nuevaFactura(cliente).putFechaEmision(fecha).putFechaInicio(fechaInicio).putFechaFin(fechaFin).putImporte(factura);
				facturas.saveFacturas();
				clientes.saveClientes();
				direccion4.setText("");
				direccion6.setText("");
				direccion8.setText("");
			}
		});
		devolver.add(vacio1);
		devolver.add(nomLabel);
		devolver.add(client);
		devolver.add(vacio3);
		devolver.add(direccion1);
		devolver.add(direccion3);
		devolver.add(direccion4);
		devolver.add(direccion5);
		devolver.add(direccion6);
		devolver.add(vacio6);
		devolver.add(direccion7);
		devolver.add(direccion8);
		devolver.add(vacio2);
		devolver.add(guardar);
		devolver.add(limpiar);
		return devolver;
	}
	public JPanel addBorrarFactura() {
		JPanel devolver = new JPanel();
		devolver.setLayout(new GridLayout(18,2));
		JComboBox client = new JComboBox(clientes.getArray());
		client.setPrototypeDisplayValue("text here fddsfdsadfddfasatextfdsadsfdgfgsfgsdfgsdfgffasdfs");
		JLabel nomLabel = new JLabel("Cliente: ");
		
		JTextField ape = new JTextField(20);
		ape.setEnabled(false);
		JLabel apeLabel = new JLabel("Apellidos: ");
		JTextField nif = new JTextField(20);
		JLabel nifLabel = new JLabel("Nif: ");
		JTextField milio = new JTextField(20);
		milio.setEnabled(false);
		JLabel milioLabel = new JLabel("e-mail: ");
		JLabel direccion1 = new JLabel("DIRECCIÓN ");
		JLabel direccion2 = new JLabel("");
		JLabel vacio1 = new JLabel("");
		JLabel vacio2 = new JLabel("");
		JLabel vacio3 = new JLabel("");
		JLabel vacio4 = new JLabel("");
		JLabel vacio5 = new JLabel("");
		JLabel vacio6 = new JLabel("");
		JLabel direccion3 = new JLabel("CP: ");
		JLabel direccion5 = new JLabel("Calle: ");
		JLabel direccion7 = new JLabel("Ciudad: ");
		JLabel direccion9 = new JLabel("Provincia: ");
		JTextField direccion4 = new JTextField(20);
		direccion4.setEnabled(false);
		JTextField direccion6 = new JTextField(20);
		direccion6.setEnabled(false);
		JTextField direccion8 = new JTextField(20);
		direccion8.setEnabled(false);
		JTextField direccion10 = new JTextField(20);
		direccion10.setEnabled(false);
		JButton borrar = new JButton("Borrar");
		JButton limpiar = new JButton("Limpiar");
		devolver.add(vacio1);
		devolver.add(vacio2);
		devolver.add(nomLabel);
		devolver.add(apeLabel);
		devolver.add(ape);
		devolver.add(nifLabel);
		devolver.add(nif);
		devolver.add(milioLabel);
		devolver.add(milio);
		devolver.add(vacio3);
		devolver.add(vacio4);
		devolver.add(direccion1);
		devolver.add(direccion2);
		devolver.add(direccion3);
		devolver.add(direccion4);
		devolver.add(direccion5);
		devolver.add(direccion6);
		devolver.add(direccion7);
		devolver.add(direccion8);
		devolver.add(direccion9);
		devolver.add(direccion10);
		devolver.add(vacio5);
		devolver.add(vacio6);
		devolver.add(borrar);
		devolver.add(limpiar);
		return devolver;
		
	}

	public JPanel addRecuperarPorCliente() {
		JPanel devolver = new JPanel();
		devolver.setLayout(new GridLayout(18,2));
		JTextField nom = new JTextField(20);
		nom.setEnabled(false);
		JLabel nomLabel = new JLabel("Nombre: ");
		JTextField ape = new JTextField(20);
		ape.setEnabled(false);
		JLabel apeLabel = new JLabel("Apellidos: ");
		JTextField nif = new JTextField(20);
		JLabel nifLabel = new JLabel("Nif: ");
		JTextField milio = new JTextField(20);
		milio.setEnabled(false);
		JLabel milioLabel = new JLabel("e-mail: ");
		JLabel direccion1 = new JLabel("DIRECCIÓN ");
		JLabel direccion2 = new JLabel("");
		JLabel vacio1 = new JLabel("");
		JLabel vacio2 = new JLabel("");
		JLabel vacio3 = new JLabel("");
		JLabel vacio4 = new JLabel("");
		JLabel vacio5 = new JLabel("");
		JLabel vacio6 = new JLabel("");
		JLabel direccion3 = new JLabel("CP: ");
		JLabel direccion5 = new JLabel("Calle: ");
		JLabel direccion7 = new JLabel("Ciudad: ");
		JLabel direccion9 = new JLabel("Provincia: ");
		JTextField direccion4 = new JTextField(20);
		direccion4.setEnabled(false);
		JTextField direccion6 = new JTextField(20);
		direccion6.setEnabled(false);
		JTextField direccion8 = new JTextField(20);
		direccion8.setEnabled(false);
		JTextField direccion10 = new JTextField(20);
		direccion10.setEnabled(false);
		JButton ant = new JButton("< Anterior <");
		JButton sig = new JButton("> Siguiente >");
		devolver.add(vacio1);
		devolver.add(vacio2);
		devolver.add(nomLabel);
		devolver.add(nom);
		devolver.add(apeLabel);
		devolver.add(ape);
		devolver.add(nifLabel);
		devolver.add(nif);
		devolver.add(milioLabel);
		devolver.add(milio);
		devolver.add(vacio3);
		devolver.add(vacio4);
		devolver.add(direccion1);
		devolver.add(direccion2);
		devolver.add(direccion3);
		devolver.add(direccion4);
		devolver.add(direccion5);
		devolver.add(direccion6);
		devolver.add(direccion7);
		devolver.add(direccion8);
		devolver.add(direccion9);
		devolver.add(direccion10);
		devolver.add(vacio5);
		devolver.add(vacio6);
		devolver.add(ant);
		devolver.add(sig);
		return devolver;
	}
	
	
	public JPanel addEntreFechas() {
		JPanel devolver = new JPanel();
		devolver.setLayout(new GridLayout(18,2));
		devolver.setPreferredSize(new Dimension(550, 550));
		JComboBox client = new JComboBox(clientes.getArray());
		client.setPrototypeDisplayValue("text here fddsfdsadfddfasatextfdsadsfdgfgsfgsdfgsdfgffasdfs");
		JLabel nomLabel = new JLabel("Cliente: ");
		JLabel vacio1 = new JLabel("");
		JLabel vacio2 = new JLabel("");
		JLabel vacio3 = new JLabel("");
		JLabel vacio4 = new JLabel("");
		JLabel vacio5 = new JLabel("");
		JLabel vacio6 = new JLabel("");
		JLabel direccion3 = new JLabel("Fecha Inicio: ");
		JLabel direccion5 = new JLabel("Fecha Fin: ");
		JTextField direccion4 = new JTextField(20);
		JTextField direccion6 = new JTextField(20);
		JButton guardar = new JButton("Mostrar");
		JButton limpiar = new JButton("Limpiar");
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Date inicio = new Date(Long.parseLong(direccion4.getText()));
				Date fin = new Date(Long.parseLong(direccion6.getText()));
				VentanaEntreFechas vef = new VentanaEntreFechas(inicio, fin);
				Cliente cliente = (Cliente) client.getSelectedItem();
				devolver.removeAll();
				devolver.setLayout(new BorderLayout());
				devolver.add(vef.addEntreFechas(facturas, cliente));
				devolver.validate();
				devolver.repaint();
			}
		});
		limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				client.setSelectedItem(null);
				direccion4.setText("");
				direccion6.setText("");
			}
		});
		devolver.add(vacio1);
		devolver.add(nomLabel);
		devolver.add(client);
		devolver.add(vacio3);
		devolver.add(direccion3);
		devolver.add(direccion4);
		devolver.add(direccion5);
		devolver.add(direccion6);
		devolver.add(vacio6);
		devolver.add(guardar);
		devolver.add(limpiar);
		return devolver;
	}
}
