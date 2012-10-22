package pe.com.jroa.ventas.service;

import java.util.List;

public interface GenericoService<T> {
	public void crear(T entidad) throws VentasServiceException;
	public void modificar(T entidad) throws VentasServiceException;
	public void eliminar(T entidad) throws VentasServiceException;
	public T traerPorId(T entidad) throws VentasServiceException;
	public List<T> traerTodos() throws VentasServiceException;
	public List<T> traerPorNombre(String nombre) throws VentasServiceException;
}
