package pe.com.jroa.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.jroa.mantenimiento.dao.EmpleadoDao;
import pe.com.jroa.mantenimiento.model.Empleado;
import pe.com.jroa.mantenimiento.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Override
	public void agregar(Empleado empleado) {
		this.empleadoDao.agregar(empleado);
	}

	@Override
	public void modificar(Empleado empleado) {
		this.empleadoDao.modificar(empleado);
	}

	@Override
	public void eliminar(Empleado empleado) {
		this.empleadoDao.eliminar(empleado);
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) {
		return this.empleadoDao.buscarPorId(idEmpleado);
	}

	@Override
	public List<Empleado> buscarTodos() {
		return this.empleadoDao.buscarTodos();
	}

	@Override
	public Empleado buscarPorDocumento(String numDocumento) {
		return this.empleadoDao.buscarPorDocumento(numDocumento);
	}

}
