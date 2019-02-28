package Modelo;

public class Direccion {
	public String CP;
	public String provincia;
	public String poblacion;
	public String direccion;
	
	public String toString() {
		return "Direccion: "+direccion + ", "+poblacion + ", "+provincia+"  CP: "+CP;
	}
}
