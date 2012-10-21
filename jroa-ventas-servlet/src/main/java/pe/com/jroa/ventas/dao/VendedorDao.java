package pe.com.jroa.ventas.dao;

import java.util.List;
import java.util.Map;

import pe.com.jroa.ventas.entities.Vendedor;

public interface VendedorDao extends GenericoDao<Vendedor>{
	public List<Vendedor> traerPorLocal(int ind) throws VentasDaoException;
	public List<Map<String, Object>> traerPorNombreMap(String nombre) throws VentasDaoException;
}
