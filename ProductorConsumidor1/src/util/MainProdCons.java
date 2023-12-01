package util;

public class MainProdCons {

	public static void main(String[] args) {
		Cola c=new Cola();
		int n = 7;
		Productor[] productores = new Productor[n];
		Consumidor[] consumidores = new Consumidor[n];
		
		for (int i=0; i<productores.length; i++) {
			productores[i] = new Productor(c,i+1);
			consumidores[i] = new Consumidor(c,1);
		}

		for (int i=0; i<consumidores.length; i++) {
			productores[i].start();
			consumidores[i].start();
		}
		
		for (int i=0; i<productores.length; i++) {
			try {
				productores[i].join();
				consumidores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Aqui se puede comprobar que todos los productos han sido consumidos.
		int[] numeros;
		for (int i=0; i<(numeros=c.getNumeros()).length; i++) {
			if (numeros[i]!=-1) {
				System.out.println("No todos los productos fueron consumidos");
				System.exit(-1);
			}
		}
		System.out.println("Todos los productos han sido consumidos");
	}
}
