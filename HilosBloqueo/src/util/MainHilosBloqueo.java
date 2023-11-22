package util;

public class MainHilosBloqueo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjetoCompartido compartido=new ObjetoCompartido();
		
		HiloCadena a=new HiloCadena(compartido," A ");
		HiloCadena b=new HiloCadena(compartido," B ");
		a.start();
		b.start();
		
	}

}
