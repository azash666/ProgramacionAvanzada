package Modelo.tarifas;

import Modelo.exceptions.diaNoValidoException;
import Modelo.interfaces.FactoryTarifaInterface;

public class TarifaFactory implements FactoryTarifaInterface{
	private Tarifa tarifa;
	private Tarifa tarifaBase;
	
	
	public TarifaFactory() {
		// TODO Auto-generated constructor stub
		tarifa=new Tarifa();
		tarifaBase=tarifa;
	}
	
	@Override
	public Tarifa putTarifaNormal(double valor) {
		// TODO Auto-generated method stub
		tarifaBase.putTarifa(valor);
		return null;
	}

	@Override
	public Tarifa putTarifaFranjaHoraria(double precio, float horaInicio, float horaFinal) {
		// TODO Auto-generated method stub
		tarifa=new ConFranjaHoraria(tarifa, precio, horaInicio, horaFinal);
		return tarifa;
	}

	@Override
	public Tarifa putTarifaFranjaDiaria(double valor, String dia) throws diaNoValidoException {
		// TODO Auto-generated method stub
		dia=dia.toLowerCase();
		int diaNum;
		switch (dia){
		case "lunes":
		case "monday":
		case "montag":
		case "dilluns":
			diaNum=1;
			break;
		case "martes":
		case "tuesday":
		case "dienstag":
		case "dimarts":
			diaNum=2;
			break;
		case "miercoles":
		case "miércoles":
		case "wednesday":
		case "mittwoch":
		case "dimecres":
			diaNum=3;
			break;
		case "jueves":
		case "thursday":
		case "donnerstag":
		case "dijous":
			diaNum=4;
			break;
		case "viernes":
		case "friday":
		case "freitag":
		case "divendres":
			diaNum=5;
			break;
		case "sabado":
		case "sábado":
		case "saturday":
		case "samstag":
		case "disabte":
			diaNum=6;
			break;
		case "domingo":
		case "sunday":
		case "sonntag":
		case "diumenge":
			diaNum=7;
			break;
		default:
			diaNum=0;
		}
		if (diaNum==0) {
			throw new diaNoValidoException();
		}
		tarifa=new ConFranjaDiaria(tarifa, valor, diaNum);
		return tarifa;
	}

	@Override
	public Tarifa removeDescuentos() {
		// TODO Auto-generated method stub
		tarifa=tarifaBase;
		return null;
	}

}
