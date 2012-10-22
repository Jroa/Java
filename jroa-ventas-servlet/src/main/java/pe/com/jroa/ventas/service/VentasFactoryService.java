package pe.com.jroa.ventas.service;

import java.io.InputStream;
import java.util.Properties;

public abstract class VentasFactoryService {
	public abstract LocalService getLocalService();
	public abstract VendedorService getVendedorService();
	
	public static VentasFactoryService getFactory() throws VentasServiceException{
		VentasFactoryService ventasFactoryService = null;
		try {
			Properties properties = new Properties();
			InputStream inputStream = VentasFactoryService.class.getResourceAsStream("/pe/com/jroa/ventas/service/factoryservice.properties");			
			properties.load(inputStream);
			String clase = properties.getProperty("clase");
			ventasFactoryService = (VentasFactoryService) Class.forName(clase).newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new VentasServiceException("No se pudo crear la instancia");
		}
		
		return ventasFactoryService;
	};
}
