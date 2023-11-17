package hilos;

import datos.Contador;

public class HiloResta extends Thread{
	private Contador contador;
	public HiloResta(String n, Contador c){
		setName(n);
		this.contador=c;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for( int i=0; i<300;i++)
		{
			contador.decrementar();
//			try {
//				sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println(getName()+" contador vale "+contador.valor());
	}
}
