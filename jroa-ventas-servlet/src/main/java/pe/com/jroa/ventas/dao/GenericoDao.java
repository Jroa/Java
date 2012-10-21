package pe.com.jroa.ventas.dao;

import java.util.List;

public interface GenericoDao<T> {
	public void crear(T entidad) throws VentasDaoException;
	public void modificar(T entidad) throws VentasDaoException;
	public void eliminar(T entidad) throws VentasDaoException;
	public T traerPorId(T entidad) throws VentasDaoException;
	public List<T> traerTodos() throws VentasDaoException;
	public List<T> traerPorNombre(String nombre) throws VentasDaoException;
}
