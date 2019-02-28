package Modelo;

public enum OpcionesMenu {
	//SALIR("Salir"),
	
	ALTA_CLIENTE("Dar de alta un nuevo cliente.", "Nuevo Cliente"),
	BORRAR_CLIENTE("Borrar un cliente.", "Borrar Cliente"),
	CAMBIAR_TARIFA("Cambiar la tarifa de un cliente.", "Tarifa Cliente"),
	RECUPERAR_CLIENTE_DE_NIF("Recuperar los datos de un cliente a partir de su NIF.", "Buscar Cliente"),
	RECUPERAR_LISTADO_CLIENTES("Recuperar el listado de todos los clientes.", "Listado Clientes"),
	CLIENTES_ENTRE_FECHAS("Mostrar un listado de clientes que fueron dados de alta entre dos fechas.", "Clientes entre fechas"),
	
	ALTA_LLAMADA("Dar de alta una llamada.", "Nueva Llamada"),
	LISTAR_LLAMADAS_CLIENTE("Listar todas las llamadas de un cliente.", "Listado Llamadas"),
	LLAMADAS_ENTRE_FECHAS("Mostrar un listado de llamadas de un cliente que fueron realizadas entre dos fechas.", "Llamadas entre fechas"),
	
	EMITIR_FACTURA_CLIENTE("Emitir una factura para un cliente, calculando el importe de la misma en funcion de las llamadas.", "Emitir Factura"),
	RECUPERAR_FACTURA_DE_CODIGO("Recuperar los datos de una factura a partir de su codigo.", "Buscar Factura"),
	RECUPERAR_FACTURAS_CLIENTE("Recuperar todas las facturas de un cliente.", "Facturas de Cliente"),
	FACTURAS_ENTRE_FECHAS("Mostrar un listado de facturas de un cliente emitidas entre dos fechas.", "Facturas entre fechas");

	private String descripcion;
	private String descrCorta;
	
	private OpcionesMenu(String descripcion, String corta) {
        this.descripcion = descripcion;
        this.descrCorta = corta;
    }
	
	public String getDescripcion() {
        return descripcion;
    }
	
	public String getDescripcionCorta() {
		return descrCorta;
	}
	
	public static String[] getCortaArray() {
		OpcionesMenu[] lista = OpcionesMenu.values();
		String[] devolver = new String[lista.length];
		for(int i=0; i<lista.length; i++) {
			devolver[i]=lista[i].getDescripcionCorta();
		}
		return devolver;
	}

	public static String[] getLargaArray() {
		OpcionesMenu[] lista = OpcionesMenu.values();
		String[] devolver = new String[lista.length];
		for(int i=0; i<lista.length; i++) {
			devolver[i]=lista[i].getDescripcion();
		}
		return devolver;
	}
}
