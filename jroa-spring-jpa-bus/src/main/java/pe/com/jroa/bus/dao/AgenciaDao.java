package pe.com.jroa.bus.dao;

import java.util.List;

import pe.com.jroa.bus.model.Agencia;

public interface AgenciaDao {
	public void agregar(Agencia agencia);
	public void modificar(Agencia agencia);
	public void eliminar(Agencia agencia);
	public Agencia buscarPorId(int idAgencia);
	public List<Agencia> buscarTodos();
}
