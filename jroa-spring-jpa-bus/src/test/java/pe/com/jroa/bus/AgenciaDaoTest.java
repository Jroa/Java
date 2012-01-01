package pe.com.jroa.bus;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import pe.com.jroa.bus.dao.AgenciaDao;
import pe.com.jroa.bus.model.Agencia;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class AgenciaDaoTest {
	private Logger logger = Logger.getLogger(AgenciaDaoTest.class);
	
	@Resource
	AgenciaDao agenciaDao;
	
	@Test
	public void AgenciaDaoCrud(){
		Agencia agencia = new Agencia();
		agencia.setNombre("Arequipa");
		agencia.setDireccion("direccion A");
		
		agenciaDao.agregar(agencia);
		logger.debug("Agencia agregada");
		Assert.assertNotSame(0, agenciaDao.buscarTodos().size());
		
		agencia = agenciaDao.buscarPorId(1);
		agencia.setNombre("Arequipa Modificado");
		agenciaDao.modificar(agencia);
		logger.debug("Agencia Modificada");
		Assert.assertEquals("Arequipa Modificado", agenciaDao.buscarPorId(1).getNombre());
		
		agencia = agenciaDao.buscarPorId(1);
		agenciaDao.eliminar(agencia);
		logger.debug("Agencia eliminada");
		Assert.assertEquals(0, agenciaDao.buscarTodos().size());
	}
}
