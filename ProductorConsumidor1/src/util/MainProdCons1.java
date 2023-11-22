package util;

public class MainProdCons1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola c=new Cola();
		Productor prod=new Productor(c,1);
		Consumidor cons=new Consumidor(c,1);
		
		prod.start();
		cons.start();
			
	}

}
