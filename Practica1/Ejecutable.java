package Practica1;

import java.util.Date;

import Modelo.Direccion;
import Modelo.Llamada;
import Modelo.RelacionClientes;
import Modelo.RelacionFacturas;
import Modelo.RelacionLlamadas;
import Modelo.clientes.Cliente;
import Modelo.clientes.Particular;
import Modelo.tarifas.Tarifa;
import Vista.VentanaPral;

public class Ejecutable {
	private StringBuffer SBsalida;
	private RelacionClientes clientes;
	private RelacionFacturas facturas;
	private RelacionLlamadas llamadas;
	private boolean salir;

	public Ejecutable() {
		// TODO Auto-generated method stub
		Salida salida = new Salida();
		Entrada entrada = new Entrada();
		Menu menu = new Menu();
		salir = false;

		clientes = new RelacionClientes();
		facturas = new RelacionFacturas();
		llamadas = new RelacionLlamadas();
		
		clientes.loadClientes();
		facturas.loadFacturas();
		llamadas.loadLlamadas();
		
		Cliente aux = null, aux2 = null;
		/*while(!salir) {
			salida.muestra(menu.muestraMenu());
			switch(Integer.parseInt(entrada.esperaEntrada())) {

			case 1:
				clientes.anadeCliente(aux2 = new Particular().putNif("12345678X").putAlta().putDireccion(new Direccion())
				.putEmail("qwert@uio.p").putNombre("Daniel").putTarifa(new Tarifa().putTarifa(20.0)));
				*/
	//			aux = clientes.anadeCliente(aux = new Particular().putNif("20249394X").putAlta().putDireccion(new Direccion())
	//					.putEmail("qwert@uio.p").putNombre("Daniel").putTarifa(new Tarifa().putTarifa(25.0)));
				/*facturas.nuevaFactura(aux2).putFechaInicio(new Date(1250)).putFechaFin(new Date(1300));
				break;
			case 2:
				clientes.borraCliente(aux);
				break;
			case 3:
				if(clientes.existeCliente("12345678X")) {
					clientes.getCliente("12345678X").putTarifa(new Tarifa().putTarifa(29.0));
				}
				break;
			case 4:
				if(clientes.existeCliente("12345678X")) {
					clientes.getCliente("12345678X");
				}
				break;
			case 5:
				clientes.listadoClientes();
				break;
			case 6:*/
//				llamadas.addLlamada(new Llamada().putDuracion(50), aux);
//				llamadas.addLlamada(new Llamada().putDuracion(75), aux);
				/*break;
			case 7:
				llamadas.llamadasDelCliente(aux2);
				break;
			case 8:
				System.out.println(facturas.emitirFactura(aux2));
				break;
			case 9:
				facturas.getFactura(1);
				break;
			case 0:
				facturas.facturasDelCliente(aux2);
				break;
			default:*/
//				llamadas.saveLlamadas();
//				facturas.saveFacturas();
//				clientes.saveClientes();
				/*salir=true;
			}
		}*/
		VentanaPral vewntana = new VentanaPral(clientes, facturas, llamadas);
	}

}
