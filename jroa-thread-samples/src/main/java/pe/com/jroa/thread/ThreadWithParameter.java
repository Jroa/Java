package pe.com.jroa.thread;

public class ThreadWithParameter {

	private class MyThread extends Thread{
		private String nombre;
		
		public MyThread(String nombre){
			this.nombre = nombre;
		}
		
		public void run(){
			System.out.println("Hola " + nombre + " desde ThreadWithParameter");
		}
	}
	
	public void mostrarMensaje(String nombre){
		MyThread hilo = new MyThread(nombre);
		hilo.start();
	}	
}
