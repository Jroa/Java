package pe.com.jroa.ventas.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import pe.com.jroa.ventas.dao.VentasDaoException;
import pe.com.jroa.ventas.dao.VentasFactoryDao;
import pe.com.jroa.ventas.entities.Local;
import pe.com.jroa.ventas.service.LocalService;
import pe.com.jroa.ventas.service.VentasServiceException;

public class LocalServiceImpl implements LocalService{
	Logger logger = Logger.getLogger(LocalServiceImpl.class);
	private VentasFactoryDao ventasFactoryDao = null;
	
	public LocalServiceImpl() {
		try {
			ventasFactoryDao = VentasFactoryDao.getFactory();
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}
	
	@Override
	public void crear(Local local) throws VentasServiceException {
		try {
			ventasFactoryDao.getLocalDao().crear(local);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void modificar(Local local) throws VentasServiceException {
		try {
			ventasFactoryDao.getLocalDao().modificar(local);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public void eliminar(Local local) throws VentasServiceException {
		try {
			ventasFactoryDao.getLocalDao().eliminar(local);
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public Local traerPorId(Local local) throws VentasServiceException {
		Local localEncontrado = null;
		try {
			localEncontrado = ventasFactoryDao.getLocalDao().traerPorId(local);
			return localEncontrado;
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
			return localEncontrado;
		}
	}

	@Override
	public List<Local> traerTodos() throws VentasServiceException {
		List<Local> locales = null;
		try {
			locales = ventasFactoryDao.getLocalDao().traerTodos();
			return locales;
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
			return locales;
		}
	}

	@Override
	public List<Local> traerPorNombre(String nombre)
			throws VentasServiceException {
		List<Local> locales = null;
		try {
			locales = ventasFactoryDao.getLocalDao().traerPorNombre(nombre);
			return locales;
		} catch (VentasDaoException ex) {
			logger.error(ex.getMessage());
			return locales;
		}
	}

}
