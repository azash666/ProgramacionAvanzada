package Modelo.exceptions;

public class InvalidDniException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDniException() {
		super("Invalid DNI");
	}
}
