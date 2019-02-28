package Modelo.exceptions;

public class diaNoValidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public diaNoValidoException() {
		super("Dia de la semana no valida.");
	}
}
