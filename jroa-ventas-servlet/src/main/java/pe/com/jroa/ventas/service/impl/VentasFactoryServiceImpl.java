package pe.com.jroa.ventas.service.impl;

import pe.com.jroa.ventas.service.LocalService;
import pe.com.jroa.ventas.service.VendedorService;
import pe.com.jroa.ventas.service.VentasFactoryService;

public class VentasFactoryServiceImpl extends VentasFactoryService{

	@Override
	public LocalService getLocalService() {
		return new LocalServiceImpl();
	}

	@Override
	public VendedorService getVendedorService() {
		return new VendedorServiceImpl();
	}

}
