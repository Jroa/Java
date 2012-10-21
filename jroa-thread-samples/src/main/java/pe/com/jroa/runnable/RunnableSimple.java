package pe.com.jroa.runnable;

public class RunnableSimple {
	public void mostrarMensaje(){
		Thread hilo = new Thread(new Runnable(){			
			public void run(){
				System.out.println("Hola Mundo desde Runnable Simple");
			}
		});
		
		hilo.start();
	}
}
