package pe.com.jroa.bus.dao.jpa;

import java.util.List;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;

import pe.com.jroa.bus.dao.AgenciaDao;
import pe.com.jroa.bus.model.Agencia;

public class AgenciaDaoJpa implements AgenciaDao{

	private JpaTemplate jpaTemplate;
	
	public void setJpaTemplate(JpaTemplate jpaTemplate){
		this.jpaTemplate = jpaTemplate;
	}
	
	@Transactional
	@Override
	public void agregar(Agencia agencia) {
		this.jpaTemplate.persist(agencia);
	}

	@Transactional
	@Override
	public void modificar(Agencia agencia) {
		this.jpaTemplate.merge(agencia);		
	}

	@Transactional
	@Override
	public void eliminar(Agencia agencia) {
		this.jpaTemplate.remove(agencia);
	}

	@Transactional(readOnly=true)
	@Override
	public Agencia buscarPorId(int idAgencia) {
		return this.jpaTemplate.find(Agencia.class, idAgencia);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Agencia> buscarTodos() {
		return this.jpaTemplate.find("from Agencia");
	}
	
}
