package pe.com.jroa.thread;

import org.junit.Test;

public class ThreadWithParameterTest {

	@Test
	public void testMostrarMensaje(){
		ThreadWithParameter threadWithParameter = new ThreadWithParameter();
		threadWithParameter.mostrarMensaje("Jonathan");
	}
}
