package main;

import java.util.Scanner;

import util.HiloPregunta;

public class MainInterrumpir {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	HiloPregunta hp = new HiloPregunta();
        
        hp.start();
        
        try {
			Thread.sleep(3000);
			hp.interrupt();
			if (!hp.ok) {
				sc.nextLine();
				System.out.println("Disco borrado");
			}
		} catch (InterruptedException e) {
		}
    }
}