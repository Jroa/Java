package pe.com.jroa.ventas.dao;

import java.io.InputStream;
import java.util.Properties;

public abstract class VentasFactoryDao {

	public abstract LocalDao getLocalDao();
	public abstract VendedorDao getVendedorDao();
	
	public static VentasFactoryDao getFactory() throws VentasDaoException{
		VentasFactoryDao ventasFactoryDao = null;
		
		try{			
			//Aqui se instancia la clase
			//ventasFactoryDao = new VentasFactoryDaoMysql();
			Properties properties = new Properties();
			InputStream inputStream = VentasFactoryDao.class.getResourceAsStream("/pe/com/jroa/ventas/dao/factory.properties"); 
			properties.load(inputStream);
			String clase = properties.getProperty("clase");
			ventasFactoryDao = (VentasFactoryDao)Class.forName(clase).newInstance();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new VentasDaoException("No se puedo crear la instancia");
		}
		
		return ventasFactoryDao;
	}
	
}
