package pe.com.jroa.mantenimiento.service;

import java.util.List;

import pe.com.jroa.mantenimiento.model.Empleado;

public interface EmpleadoService {
	public void agregar(Empleado empleado);
	public void modificar(Empleado empleado);
	public void eliminar(Empleado empleado);
	public Empleado buscarPorId(int idEmpleado);
	public Empleado buscarPorDocumento(String numDocumento);
	public List<Empleado> buscarTodos();
}
