package Modelo.exceptions;

public class InvalidDatesException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDatesException() {
		super("Fecha de final es anterior a la fecha de inicio");
	}
}
