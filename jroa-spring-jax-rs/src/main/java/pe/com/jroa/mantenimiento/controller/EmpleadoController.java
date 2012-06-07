package pe.com.jroa.mantenimiento.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import pe.com.jroa.mantenimiento.model.Empleado;
import pe.com.jroa.mantenimiento.service.EmpleadoService;

@Path("/empleado")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GET
	@Path("/todos")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Empleado> buscarTodos(){
		List<Empleado> empleados = this.empleadoService.buscarTodos();
		return empleados;
	}
		
}
