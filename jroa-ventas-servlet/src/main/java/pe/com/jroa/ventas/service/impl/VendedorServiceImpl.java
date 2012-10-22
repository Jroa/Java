package pe.com.jroa.ventas.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import pe.com.jroa.ventas.dao.VentasDaoException;
import pe.com.jroa.ventas.dao.VentasFactoryDao;
import pe.com.jroa.ventas.entities.Vendedor;
import pe.com.jroa.ventas.service.VendedorService;
import pe.com.jroa.ventas.service.VentasServiceException;

public class VendedorServiceImpl implements VendedorService{
	Logger logger = Logger.getLogger(VendedorServiceImpl.class);
	
	private VentasFactoryDao ventasFactoryDao = null;
	
	public VendedorServiceImpl(){
		try {
			ventasFactoryDao = VentasFactoryDao.getFactory();
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}
	
	@Override
	public void crear(Vendedor vendedor) throws VentasServiceException {
		try {
			ventasFactoryDao.getVendedorDao().crear(vendedor);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void modificar(Vendedor vendedor) throws VentasServiceException {
		try {
			ventasFactoryDao.getVendedorDao().modificar(vendedor);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void eliminar(Vendedor vendedor) throws VentasServiceException {
		try {
			ventasFactoryDao.getVendedorDao().eliminar(vendedor);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public Vendedor traerPorId(Vendedor vendedor) throws VentasServiceException {
		Vendedor vendedorEncontrado = null;
		try {
			vendedorEncontrado = ventasFactoryDao.getVendedorDao().traerPorId(vendedor);
			return vendedorEncontrado;
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
			return vendedorEncontrado;
		}	
	}

	@Override
	public List<Vendedor> traerTodos() throws VentasServiceException {
		List<Vendedor> vendedores = null;
		try {
			vendedores = ventasFactoryDao.getVendedorDao().traerTodos();
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
		return vendedores;
	}

	@Override
	public List<Vendedor> traerPorNombre(String nombre)
			throws VentasServiceException {
		List<Vendedor> vendedores = null;
		try {
			vendedores = ventasFactoryDao.getVendedorDao().traerPorNombre(nombre);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
		return vendedores;
	}

	@Override
	public List<Vendedor> traerPorLocal(int ind) throws VentasServiceException {
		List<Vendedor> vendedores = null;
		try {
			vendedores = ventasFactoryDao.getVendedorDao().traerPorLocal(ind);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
		return vendedores;
	}

	@Override
	public List<Map<String, Object>> traerPorNombreMap(String nombre)
			throws VentasServiceException {
		List<Map<String, Object>> vendedores = null;
		try {
			vendedores = ventasFactoryDao.getVendedorDao().traerPorNombreMap(nombre);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
		return vendedores;
	}

}
