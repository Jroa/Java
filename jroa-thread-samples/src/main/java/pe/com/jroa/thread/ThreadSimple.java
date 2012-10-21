package pe.com.jroa.thread;

public class ThreadSimple {
	public void mostrarMensaje(){
		Thread hilo = new Thread(){
			public void run(){
				System.out.println("Hola Mundo desde Thread Simple");
			}
		};
		
		hilo.start();
	}
}
