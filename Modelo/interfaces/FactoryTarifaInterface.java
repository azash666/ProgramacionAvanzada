package Modelo.interfaces;

import Modelo.exceptions.diaNoValidoException;
import Modelo.tarifas.Tarifa;

public interface FactoryTarifaInterface {
	public Tarifa putTarifaNormal(double valor);
	public Tarifa putTarifaFranjaHoraria(double precio, float horaInicio, float horaFinal);
	public Tarifa putTarifaFranjaDiaria(double valor, String dia) throws diaNoValidoException;
	public Tarifa removeDescuentos();
}
