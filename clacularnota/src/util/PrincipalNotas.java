package util;

import java.util.Scanner;

public class PrincipalNotas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, contador = 0, suma = 0;
		double media;
		System.out.println("Introduce un numero");
		while ((num = sc.nextInt())!=0) {
			suma += num;
			contador++;
			System.out.println("Introduce un numero");
		}
		media = (double) suma/contador; 
		System.out.println("La media de las notas es " + media);
	}

}
