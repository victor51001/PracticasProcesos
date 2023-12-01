package util;


public class Apostante extends Thread{
	int saldo;
	private Sorteo bola;
	private Banca banca;
	int rondas;

	public Apostante(Sorteo bola, Banca banca, int rondas) {
		this.bola = bola;
		this.banca = banca;
		this.saldo = 100;
		this.rondas = rondas;
		this.setName("Apostante " + this.getName().split("-")[1]);
	}

	@Override
	public void run() {
		int[] numeros = new int[3];
		int apuesta = 5;
		for(int i=0; i<rondas; i++) {
			int aciertos = 0;
			for (int j=0; j<numeros.length; j++) {
				numeros[j] = (int) ((Math.random() * 48) + 1);
			}
			synchronized (bola) {
				try {
					bola.wait();
					for (int  j=0; j<numeros.length; j++) {
						banca.ingresar(apuesta);
						saldo -= apuesta;
						System.out.println(this.getName() + " apuesta al " + numeros[j] + " la cantidad de " + apuesta + " y le queda " + saldo);
						if (numeros[j]==bola.getNumero()) {
							aciertos++;
						}
					}	
					switch (aciertos) {
						case 0:
							System.out.println(this.getName() + " pierde");
						case 1:
							System.out.println(this.getName() + " gana " + 5);
							banca.retirar(5);
							saldo += 5;
							break;
						case 2:
							System.out.println(this.getName() + " gana " + 25);
							banca.retirar(25);
							saldo += 25;
							break;							
						case 3:
							System.out.println(this.getName() + " gana " + 1000);
							banca.retirar(1000);
							saldo += 1000;
							break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}	
}
