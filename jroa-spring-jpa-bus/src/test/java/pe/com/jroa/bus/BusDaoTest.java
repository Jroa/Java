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

import pe.com.jroa.bus.dao.BusDao;
import pe.com.jroa.bus.model.Bus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class BusDaoTest {
	private Logger logger = Logger.getLogger(BusDaoTest.class);
	
	@Resource
	BusDao busDao;
	
	@Test
	public void BusDaoCrud(){
		Bus bus = new Bus();
		bus.setPlaca("ABC123");
		bus.setNumAsiento(40);
		bus.setEstado(1);
		
		busDao.agregar(bus);
		logger.debug("Bus Agregado");
		Assert.assertNotSame(0, busDao.buscarTodos().size());
		
		bus.setPlaca("XYZ123");
		busDao.modificar(bus);
		logger.debug("Bus modificado");
		Assert.assertEquals("XYZ123", busDao.buscarPorId(1).getPlaca());
		
		bus = busDao.buscarPorId(1);
		busDao.eliminar(bus);
		logger.debug("Bus elimado");
		Assert.assertEquals(0, busDao.buscarTodos().size());
	}
	
}
