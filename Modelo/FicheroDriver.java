package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import Modelo.clientes.Cliente;
import Modelo.tarifas.Tarifa;

public class FicheroDriver {
	private String directorio;
	private PrintWriter prwr;
	private Scanner leer;
	
	public FicheroDriver() {
		directorio="lib/";
	}
	
	
	
	public boolean openLoad(String archivo) {
		try {
			leer = new Scanner(new File(directorio+archivo));
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}
	
	public boolean openSave(String archivo) {
		try {
			prwr=new PrintWriter(directorio+archivo);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}


	
	
	public void closeLoad() {
		try {
		leer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}
	public void closeSave() {
		prwr.close();
	}
	
	public boolean saveCliente(Cliente cliente) {
		if (prwr==null || cliente==null) return false;
		prwr.append(cliente.nombre+"||");
		prwr.append(cliente.nif+"||");
		prwr.append(cliente.direccion.CP+"||");
		prwr.append(cliente.direccion.provincia+"||");
		prwr.append(cliente.direccion.poblacion+"||");
		prwr.append(cliente.direccion.direccion+"||");
		prwr.append(cliente.email+"||");
		prwr.append(""+cliente.alta.getTime()+"||");
		//prwr.append(""+cliente.tarifa.getTarifa()+"||");
		int size = cliente.facturas.size();
		prwr.append(size+"||");
		Iterator<Integer> iter = cliente.facturas.iterator();
		while(iter.hasNext()) {
			prwr.append(iter.next().toString()+"||");
		}
		prwr.append("\n");
		return true;
	}
	
	public Cliente loadCliente(String string) {
		Cliente devolver = new Cliente();
		String[] auxiliar = string.split("\\|\\|");
		Direccion direccion = new Direccion();
		direccion.CP=auxiliar[2];
		direccion.provincia=auxiliar[3];
		direccion.poblacion=auxiliar[4];
		direccion.direccion=auxiliar[5];
		devolver.putNombre(auxiliar[0])
		.putDireccion(direccion)
		.putNif(auxiliar[1])
		.putEmail(auxiliar[6])
		.putAlta(new Date(Long.parseLong(auxiliar[7])));
		//.putTarifa(new Tarifa().putTarifa(Double.parseDouble(auxiliar[8])));
		
		for(int i=9; i<(Integer.parseInt(auxiliar[8])+9); i++) {
			devolver.facturas.add(Integer.parseInt(auxiliar[i]));
		}
		return devolver;
	}
	
	public boolean saveFactura(Factura factura) {
		if (prwr==null || factura==null) return false;
		prwr.append(factura.fechaEmision.getTime()+"||");
		prwr.append(factura.fechaInicio.getTime()+"||");
		prwr.append(factura.fechaFin.getTime()+"||");
		prwr.append(factura.importe+"||");
		//prwr.append(factura.tarifa.getTarifa()+"||");
		saveCliente(factura.cliente);
		return true;
	}
	
	public Factura loadFactura(String string) {
		Cliente cliente = new Cliente();
		String[] auxiliar = string.split("\\|\\|");
		//System.out.println("------->"+string+"\n"+auxiliar.length);
		Direccion direccion = new Direccion();
		direccion.CP=auxiliar[6];
		direccion.provincia=auxiliar[7];
		direccion.poblacion=auxiliar[8];
		direccion.direccion=auxiliar[9];
		cliente.putNombre(auxiliar[4])
		.putNif(auxiliar[5])
		.putEmail(auxiliar[10])
		.putAlta(new Date(Long.parseLong(auxiliar[11])));
		//.putTarifa(new Tarifa().putTarifa(Double.parseDouble(auxiliar[13])));
		
		for(int i=13; i<(Integer.parseInt(auxiliar[12])+13); i++) {
			cliente.facturas.add(Integer.parseInt(auxiliar[i]));
		}
		
		Factura devolver = new Factura(cliente)
				.putFechaEmision(new Date(Long.parseLong(auxiliar[0])))
				.putFechaInicio(new Date(Long.parseLong(auxiliar[1])))
				.putFechaFin(new Date(Long.parseLong(auxiliar[2])))
				.putImporte(Float.parseFloat(auxiliar[3]));
				//.putTarifa(new Tarifa().putTarifa(Double.parseDouble(auxiliar[4])));
		return devolver;
	}
	
	public boolean saveLlamada(Llamada llamada) {
		if (prwr==null || llamada==null) return false;
		prwr.append(llamada.getTelefono()+"||");
		prwr.append(llamada.getFecha().getTime()+"||");
		prwr.append(llamada.getDuracion()+"\n");
		return true;
	}

	public Llamada loadLlamada(String string) {
		String[] auxiliar = string.split("\\|\\|");
		Llamada llamada= new Llamada()
				.putTelf(auxiliar[0])
				.putFecha(new Date(Long.parseLong(auxiliar[1])))
				.putDuracion(Integer.parseInt(auxiliar[2]));
		return llamada;
	}
	
	
	public void saveInt(int num) {
		prwr.append(num+"\n");
	}
	
	public int loadInt(String string) {
		return Integer.parseInt(string);
	}
	
	public String readNextLine() {
		return leer.nextLine();
	}
	
	public boolean hasNextLine() {
		if(leer==null) return false;
		return leer.hasNextLine();
	}
}
