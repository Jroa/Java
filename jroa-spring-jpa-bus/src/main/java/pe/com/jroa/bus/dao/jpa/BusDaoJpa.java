package pe.com.jroa.bus.dao.jpa;

import java.util.List;

import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;

import pe.com.jroa.bus.dao.BusDao;
import pe.com.jroa.bus.model.Bus;

public class BusDaoJpa implements BusDao{

	private JpaTemplate jpaTemplate;
	
	public void setJpaTemplate(JpaTemplate jpaTemplate){
		this.jpaTemplate = jpaTemplate;
	}
	
	@Transactional
	@Override
	public void agregar(Bus bus) {
		this.jpaTemplate.persist(bus);
	}

	@Transactional
	@Override
	public void modificar(Bus bus) {
		this.jpaTemplate.merge(bus);
	}

	@Transactional
	@Override
	public void eliminar(Bus bus) {
		this.jpaTemplate.remove(bus);
	}

	@Transactional(readOnly=true)
	@Override
	public Bus buscarPorId(int idBus) {
		return this.jpaTemplate.find(Bus.class,idBus);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Bus> buscarTodos() {
		return this.jpaTemplate.find("from Bus");
	}

}
