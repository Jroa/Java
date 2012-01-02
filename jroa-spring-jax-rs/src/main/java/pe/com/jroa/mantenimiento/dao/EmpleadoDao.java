package pe.com.jroa.mantenimiento.dao;

import java.util.List;

import pe.com.jroa.mantenimiento.model.Empleado;

public interface EmpleadoDao {
	public void agregar(Empleado empleado);
	public void modificar(Empleado empleado);
	public void eliminar(Empleado empleado);
	public Empleado buscarPorId(int idEmpleado);
	public Empleado buscarPorDocumento(String numDocumento);
	public List<Empleado> buscarTodos();
}
