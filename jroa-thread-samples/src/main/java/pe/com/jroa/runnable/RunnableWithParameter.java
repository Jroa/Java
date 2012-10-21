package pe.com.jroa.runnable;

public class RunnableWithParameter {
	private class MyRunnable implements Runnable{
		String nombre;
		
		public MyRunnable(String nombre){
			this.nombre = nombre;
		}
		
		@Override
		public void run() {
			System.out.println("Hola " + nombre + " desde RunnableWithParameter");
		}
		
	}
	
	public void mostrarMensaje(String nombre){
		Thread hilo = new Thread(new MyRunnable(nombre));
		hilo.start();
		
	}
}
