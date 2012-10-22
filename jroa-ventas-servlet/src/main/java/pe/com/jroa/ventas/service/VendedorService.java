package pe.com.jroa.ventas.service;

import java.util.List;
import java.util.Map;

import pe.com.jroa.ventas.entities.Vendedor;

public interface VendedorService extends GenericoService<Vendedor>{
	public List<Vendedor> traerPorLocal(int ind) throws VentasServiceException;
	public List<Map<String, Object>> traerPorNombreMap(String nombre) throws VentasServiceException;
}
