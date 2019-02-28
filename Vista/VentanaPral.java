package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Controlador.ListController;
import Modelo.OpcionesMenu;
import Modelo.RelacionClientes;
import Modelo.RelacionFacturas;
import Modelo.RelacionLlamadas;

public class VentanaPral {
	
	public VentanaPral(RelacionClientes clientes, RelacionFacturas facturas, RelacionLlamadas llamadas) {
		JFrame ventana = new JFrame("Programación Avanzada");
		ventana.setSize(800, 600);
		Container contenedor = ventana.getContentPane();
		JList menu = new JList(OpcionesMenu.getCortaArray());
		menu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menu.setFixedCellHeight(30);
		menu.setFixedCellWidth(200);
		
		menu.setBackground(new Color(255, 245, 245));
		JScrollPane scroll = new JScrollPane(menu);
		
		JPanel zonaPrincipal = new JPanel();
		menu.addListSelectionListener(new ListController(zonaPrincipal, clientes, facturas, llamadas));
				
				
		contenedor.add(scroll, BorderLayout.WEST);
		contenedor.add(zonaPrincipal, BorderLayout.CENTER);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setVisible(true);
	}
}
