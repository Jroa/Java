package pe.com.jroa.mantenimiento.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	
	@POST
	public void agregar(Empleado empleado){
		this.empleadoService.agregar(empleado);
	}
	
	@PUT
	public void modificar(Empleado empleado){
		this.empleadoService.modificar(empleado);
	}
	
	@DELETE
	public void eliminar(Empleado empleado){
		this.empleadoService.eliminar(empleado);
	}
	
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)	
	@GET
	public Empleado buscarPorId(int idEmpleado){
		return this.empleadoService.buscarPorId(idEmpleado);
	}
	
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@GET 
	public List<Empleado> buscarTodos(){
		return this.empleadoService.buscarTodos();
	}
}
