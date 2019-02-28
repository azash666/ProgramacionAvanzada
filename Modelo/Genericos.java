package Modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import Modelo.exceptions.InvalidDatesException;
import Modelo.interfaces.FechaDeAlta;


public class Genericos {
	public static <T extends FechaDeAlta> Set<T> entreFechas(Set<T> conjunto, Date fechaDeInicio, Date fechaDeFinal){
		try {
			compruebaFechas(fechaDeInicio, fechaDeFinal);
		} catch (InvalidDatesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<T> devolver = new HashSet<T>();
		long inicio=fechaDeInicio.getTime(), fin=fechaDeFinal.getTime(), fechaAuxiliar;
		Iterator<T> iter = conjunto.iterator();
		while(iter.hasNext()) {
			T aux = (T) iter.next();
			fechaAuxiliar = aux.getFecha().getTime();
			if(fechaAuxiliar>=inicio && fechaAuxiliar <= fin )
				devolver.add(aux);
		}
		return devolver;
	}
	
	private static void compruebaFechas(Date finicio, Date ffinal) throws InvalidDatesException {
		if((finicio.getTime()-ffinal.getTime())>0) throw new InvalidDatesException();
	}
}
