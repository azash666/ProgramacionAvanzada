package Practica1;

import java.util.Scanner;

public class Entrada {
	Scanner teclado;
	public Entrada() {
		teclado= new Scanner(System.in);
	}
	
	public String esperaEntrada() {
		return teclado.nextLine();
	}
}
