package util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import datos.Bombo;
import datos.Cuenta;
import hilos.Jugador;
import hilos.Lanzador;

public class MainLoteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el numero de sortenos: ");
		int nSorteos = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el numero de jugadores");
		int nJugadores = sc.nextInt();
		sc.nextLine();
		int vueltas;

		Cuenta banca = new Cuenta(1000 + 10 * nJugadores);
		Bombo bombo = new Bombo();
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		Random r = new Random();

		for (int i = 0; i < nJugadores; i++) {
			vueltas = r.nextInt(0, 10);
			jugadores.add(new Jugador(bombo, banca, 100, vueltas));
			jugadores.get(i).start();
		}
		
		Lanzador lanzador = new Lanzador(bombo,jugadores,nSorteos);
		lanzador.start();
		
		for(int i=0; i < nJugadores; i++) {
			try {
				jugadores.get(i).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			lanzador.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
