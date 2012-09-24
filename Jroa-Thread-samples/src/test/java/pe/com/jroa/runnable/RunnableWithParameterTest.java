package pe.com.jroa.runnable;

import org.junit.Test;

public class RunnableWithParameterTest {

	@Test
	public void testMostrarMensaje(){
		RunnableWithParameter runnableWithParameter = new RunnableWithParameter();
		runnableWithParameter.mostrarMensaje("Jonathan");
	}
}
