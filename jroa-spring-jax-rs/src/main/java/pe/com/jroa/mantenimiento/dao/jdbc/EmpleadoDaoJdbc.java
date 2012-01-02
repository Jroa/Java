package pe.com.jroa.mantenimiento.dao.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.com.jroa.mantenimiento.dao.EmpleadoDao;
import pe.com.jroa.mantenimiento.model.Empleado;

@Repository
public class EmpleadoDaoJdbc extends SimpleJdbcDaoSupport implements EmpleadoDao{

	@Autowired
	public EmpleadoDaoJdbc(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	
	@Override
	public void agregar(Empleado empleado) {
		this.getSimpleJdbcTemplate().update("insert into Empleado(nombre, apellido, numDocumento) values (?, ?, ?)", 
				empleado.getNombre(),
				empleado.getApellido(),
				empleado.getNumDocumento());
	}

	@Override
	public void modificar(Empleado empleado) {
		this.getSimpleJdbcTemplate().update("update Empleado set nombre=?, apellido=?, numDocumento=? where idEmpleado = ?",
				empleado.getNombre(),
				empleado.getApellido(),
				empleado.getNumDocumento(),
				empleado.getIdEmpleado());
	}

	@Override
	public void eliminar(Empleado empleado) {
		this.getSimpleJdbcTemplate().update("delete from Empleado where idEmpleado =?", 
				empleado.getIdEmpleado());
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) {
		try{
			return this.getSimpleJdbcTemplate().queryForObject("select idEmpleado, nombre, apellido, numDocumento from Empleado where idEmpleado =?", 
					new BeanPropertyRowMapper<Empleado>(Empleado.class), 
					idEmpleado);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public List<Empleado> buscarTodos() {
		return this.getSimpleJdbcTemplate().query("select idEmpleado, nombre, apellido, numDocumento from Empleado", 
				new BeanPropertyRowMapper<Empleado>(Empleado.class));
	}

	@Override
	public Empleado buscarPorDocumento(String numDocumento) {
		try{
			return this.getSimpleJdbcTemplate().queryForObject("select idEmpleado, nombre, apellido, numDocumento from Empleado where numDocumento =?", 
					new BeanPropertyRowMapper<Empleado>(Empleado.class), 
					numDocumento);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

}
