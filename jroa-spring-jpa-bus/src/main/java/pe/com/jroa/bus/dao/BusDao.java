package pe.com.jroa.bus.dao;

import java.util.List;

import pe.com.jroa.bus.model.Bus;

public interface BusDao {
	public void agregar(Bus bus);
	public void modificar(Bus bus);
	public void eliminar(Bus bus);
	public Bus buscarPorId(int idBus);
	public List<Bus> buscarTodos();
}
