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

import Modelo.Direccion;
import Modelo.RelacionClientes;
import Modelo.clientes.Cliente;

public class VentanaClientes {
	RelacionClientes clientes;
	public VentanaClientes(RelacionClientes clientes) {
		// TODO Auto-generated constructor stub
		this.clientes = clientes;
	}
	public JPanel addAltaCliente() {
		JPanel devolver = new JPanel();
		devolver.setLayout(new GridLayout(18,2));
		JTextField nom = new JTextField(20);
		JLabel nomLabel = new JLabel("Nombre: ");
		JTextField ape = new JTextField(20);
		JLabel apeLabel = new JLabel("Apellidos: ");
		JTextField nif = new JTextField(20);
		JLabel nifLabel = new JLabel("Nif: ");
		JTextField milio = new JTextField(20);
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
		JTextField direccion6 = new JTextField(20);
		JTextField direccion8 = new JTextField(20);
		JTextField direccion10 = new JTextField(20);
		JButton guardar = new JButton("Guardar");
		guardar.setName("Nuevo.Guardar");
		JButton limpiar = new JButton("Limpiar");
		limpiar.setName("Nuevo.Limpiar");
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nombre, niff, email, cp, calle, ciudad, provincia;
				nombre = nom.getText();
				niff=nif.getText();
				email=milio.getText();
				cp = direccion4.getText();
				calle = direccion6.getText();
				ciudad = direccion8.getText();
				provincia = direccion10.getText();
				Direccion dir = new Direccion();
				dir.CP = cp;
				dir.direccion=calle;
				dir.poblacion=ciudad;
				dir.provincia=provincia;
				Cliente nuevo= new Cliente();
				nuevo.putAlta().putDireccion(dir).putEmail(email).putNif(niff).putNombre(nombre);
				clientes.anadeCliente(nuevo);
				clientes.saveClientes();
				nom.setText("");
				ape.setText("");
				nif.setText("");
				milio.setText("");
				direccion4.setText("");
				direccion6.setText("");
				direccion8.setText("");
				direccion10.setText("");
			}
			
		});
		limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nom.setText("");
				ape.setText("");
				nif.setText("");
				milio.setText("");
				direccion4.setText("");
				direccion6.setText("");
				direccion8.setText("");
				direccion10.setText("");
			}
		});
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
		devolver.add(guardar);
		devolver.add(limpiar);
		return devolver;
	}
	public JPanel addBorrarCliente() {
		JPanel devolver = new JPanel();
		devolver.setLayout(new GridLayout(18,2));
		JComboBox client = new JComboBox(clientes.getArray());
		client.setPrototypeDisplayValue("text here fddsfdsadfddfasatextfdsadsfdgfgsfgsdfgsdfgffasdfs");
		JLabel nomLabel = new JLabel("Cliente: ");
		
		JLabel vacio1 = new JLabel("");
		JLabel vacio2 = new JLabel("");
		JLabel vacio3 = new JLabel("");
		JLabel vacio4 = new JLabel("");
		JLabel vacio5 = new JLabel("");
		JLabel vacio6 = new JLabel("");
		JButton borrar = new JButton("Borrar");
		borrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Cliente borrable = (Cliente)client.getSelectedItem();
				if(borrable!=null) {
					clientes.borraCliente(borrable);
					clientes.saveClientes();
				}
				client.repaint();
			}
		});
		devolver.add(vacio1);
		devolver.add(vacio2);
		devolver.add(nomLabel);
		devolver.add(client);
		
		devolver.add(vacio3);
		devolver.add(vacio4);
		devolver.add(vacio5);
		devolver.add(vacio6);
		devolver.add(borrar);
		return devolver;
		
	}
	public JPanel addCambiarTarifa() {
		JPanel devolver = new JPanel();
		JLabel nodisponible = new JLabel("No disponible todavía hasta que no se arregle Tarifa");
		nodisponible.setForeground(Color.RED);
		devolver.add(nodisponible);
		return devolver;
	}
	public JPanel addRecuperarPorNif() {
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
		JButton buscar = new JButton("Buscar");
		JButton limpiar = new JButton("Limpiar");
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String dni = nif.getText();
				Cliente cliente = clientes.getCliente(dni);
				if(cliente!=null) {
					nom.setText(cliente.nombre);
					milio.setText(cliente.email);
					direccion4.setText(cliente.direccion.CP);
					direccion6.setText(cliente.direccion.direccion);
					direccion8.setText(cliente.direccion.poblacion);
					direccion10.setText(cliente.direccion.provincia);
				}else {
					nom.setText("*error*");
					milio.setText("*error*");
					direccion4.setText("*error*");
					direccion6.setText("*error*");
					direccion8.setText("*error*");
					direccion10.setText("*error*");
				}
			}
			
		});
		limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nom.setText("");
				ape.setText("");
				nif.setText("");
				milio.setText("");
				direccion4.setText("");
				direccion6.setText("");
				direccion8.setText("");
				direccion10.setText("");
			}
		});
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
		devolver.add(buscar);
		devolver.add(limpiar);
		return devolver;
	}
	
	
	public JPanel addListado() {
		JPanel devolver = new JPanel();
		Cliente[] aux = clientes.getArray();
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
		JLabel vacio1 = new JLabel("");
		JLabel vacio2 = new JLabel("");
		JLabel vacio3 = new JLabel("");
		JLabel vacio4 = new JLabel("");
		JLabel vacio5 = new JLabel("");
		JLabel vacio6 = new JLabel("");
		devolver.setLayout(new GridLayout(18,2));
		devolver.setPreferredSize(new Dimension(550, 550));
		JLabel direccion3 = new JLabel("De ");
		JLabel direccion5 = new JLabel(" a ");
		JTextField direccion4 = new JTextField(15);
		//direccion4.setPrototypeDisplayValue("999999999999999");
		JTextField direccion6 = new JTextField(15);
		//direccion3.setPrototypeDisplayValue("999999999999999");
		JButton guardar = new JButton("Mostrar");
		JButton limpiar = new JButton("Limpiar");
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Date inicio = new Date(Long.parseLong(direccion4.getText()));
				Date fin = new Date(Long.parseLong(direccion6.getText()));
				VentanaEntreFechas vef = new VentanaEntreFechas(inicio, fin);
				
				devolver.removeAll();
				devolver.setLayout(new BorderLayout());
				devolver.add(vef.addEntreFechas(clientes));
				devolver.validate();
				devolver.repaint();
			}
		});
		limpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				direccion4.setText("");
				direccion6.setText("");
			}
		});
		JTextField direccion8 = new JTextField(20);
		direccion8.setEnabled(false);
		devolver.add(vacio1);
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
