package Practica1;

public class Menu {
	private String menu;
	public Menu() {
		menu=	"Con respecto a los clientes:\n\n" + 
	
				"1.- Dar de alta un nuevo cliente.\n" + 
				"2.- Borrar un cliente.\n" + 
				"3.- Cambiar la tarifa de un cliente.\n" + 
				"4.- Recuperar los datos de un cliente a partir de su NIF.\n" + 
				"5.- Recuperar el listado de todos los clientes.\n" + 
				
				"\nCon respecto a las llamadas:\n\n" + 
				
				"6.- Dar de alta una llamada.\n" + 
				"7.- Listar todas las llamadas de un cliente.\n" + 
				
				"\nCon respecto a las facturas:\n\n" + 
				
				"8.- Emitir una factura para un cliente, calculando el importe de la misma en función de las llamadas.\n" + 
				"9.- Recuperar los datos de una factura a partir de su código.\n" + 
				"0.- Recuperar todas las facturas de un cliente.\n\n"+
				"10- Salir.\n";
	}
	public String muestraMenu() {
		return menu;
	}
}
