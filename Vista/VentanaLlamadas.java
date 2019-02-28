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

import Modelo.Llamada;
import Modelo.RelacionClientes;
import Modelo.RelacionLlamadas;
import Modelo.clientes.Cliente;

public class VentanaLlamadas {
	RelacionLlamadas llamadas;
	RelacionClientes clientes;
	public VentanaLlamadas(RelacionLlamadas llamadas, RelacionClientes clientes) {
		// TODO Auto-generated constructor stub
		this.llamadas = llamadas;
		this.clientes = clientes;
	}
	public JPanel addAltaLlamada() {
		JPanel devolver = new JPanel();
		devolver.setLayout(new GridLayout(18,2));
		JComboBox client = new JComboBox(clientes.getArray());
		client.setPrototypeDisplayValue("text here fddsfdsadfddfasatextfdsadsfdgfgsfgsdfgsdfgffasdfs");
		JLabel nomLabel = new JLabel("Cliente: ");
		JLabel direccion1 = new JLabel("LLAMADA ");
		JLabel direccion2 = new JLabel("");
		JLabel vacio1 = new JLabel("");
		JLabel vacio2 = new JLabel("");
		JLabel vacio3 = new JLabel("");
		JLabel vacio4 = new JLabel("");
		JLabel vacio5 = new JLabel("");
		JLabel vacio6 = new JLabel("");
		JLabel direccion3 = new JLabel("Teléfono: ");
		JLabel direccion5 = new JLabel("Duración (segundos): ");
		JTextField direccion4 = new JTextField(20);
		JTextField direccion6 = new JTextField(20);
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = (Cliente)client.getSelectedItem();
				String telefono = direccion4.getText();
				int duracion = Integer.parseInt(direccion6.getText());
				Llamada nueva = new Llamada();
				nueva.putDuracion(duracion).putFecha(new Date()).putTelf(telefono);
				llamadas.addLlamada(nueva, cliente);
				llamadas.saveLlamadas();
				direccion4.setText("");
				direccion6.setText("");
			}
		});
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				client.setSelectedItem(null);
				direccion4.setText("");
				direccion6.setText("");
			}
		});
		devolver.add(vacio1);
		devolver.add(vacio2);
		devolver.add(nomLabel);
		devolver.add(client);
		devolver.add(vacio3);
		devolver.add(vacio4);
		devolver.add(direccion1);
		devolver.add(direccion3);
		devolver.add(direccion4);
		devolver.add(direccion5);
		devolver.add(direccion6);
		devolver.add(vacio5);
		devolver.add(vacio6);
		devolver.add(guardar);
		devolver.add(limpiar);
		return devolver;
	}
	
	public JPanel addListado() {
		JPanel devolver = new JPanel();
		String[] aux = llamadas.getArray();
		JList listaclientes = new JList(aux);
		listaclientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaclientes.setFixedCellHeight(20);
		listaclientes.setPreferredSize(new Dimension(500, 500));
		JScrollPane scroll = new JScrollPane(listaclientes);
		//devolver.add(titulo, BorderLayout.NORTH);
		devolver.add(listaclientes);
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
				devolver.add(vef.addEntreFechas(llamadas, cliente));
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
		devolver.add(vacio3);
		devolver.add(nomLabel);
		devolver.add(client);
		devolver.add(vacio2);
		devolver.add(vacio4);
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
