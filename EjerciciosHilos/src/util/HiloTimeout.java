package util;


public class HiloTimeout extends Thread{
	public void run() {		
    	try {
    		Thread.sleep(30000);
        	System.out.println("Disco borrado");
        } catch (InterruptedException e) {
        	System.out.println("Por esta vez te has salvado, no te fíes de los extraños");
        }
    	System.exit(0);
	}
}
