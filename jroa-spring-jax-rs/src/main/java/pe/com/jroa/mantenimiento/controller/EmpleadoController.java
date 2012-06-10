package pe.com.jroa.mantenimiento.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	public Response buscarTodos() {
		try{
			List<Empleado> empleados = this.empleadoService.buscarTodos();
			return Response.status(Status.ACCEPTED).entity(empleados).build();
		}catch(Exception ex){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("No se pudo listar los empleados").build();
		}
	}
	
	@GET
	@Path("/{numDocumento}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response buscarPorDocumento(@PathParam("numDocumento") String numDocumento){
		try{
			Empleado empleado = this.empleadoService.buscarPorDocumento(numDocumento);
			if (empleado==null){
				return Response.status(Status.NOT_FOUND).entity("No se encontro al empleado").build();
			}
			return Response.status(Status.ACCEPTED).entity(empleado).build();
		}catch(Exception ex){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Fallo la busqueda").build();
		}
	}
	
	@POST
	public Response agregarEmpleado(Empleado empleado){
		try{
			this.empleadoService.agregar(empleado);
			return Response.status(Status.CREATED).entity("Empleado Creado").build();
		}catch(Exception ex){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("No se pudo agregar el empleado").build();
		}
	}
	
	@PUT
	public Response actualizarEmpleado(Empleado empleado){
		try{
			this.empleadoService.modificar(empleado);
			return Response.status(Status.ACCEPTED).entity("Empleado Actualizado").build();
		}catch(Exception ex){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("No se pudo agregar al empleado").build();
		}
	}

	@DELETE
	@Path("/{numDocumento}")
	public Response eliminarEmpleado(@PathParam("numDocumento") String numDocumento){
		try{
			Empleado empleado = this.empleadoService.buscarPorDocumento(numDocumento);
			this.empleadoService.eliminar(empleado);
			return Response.status(Status.ACCEPTED).entity("Empleado eliminado").build();
		}catch(Exception ex){
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("No se pudo eliminar al empleado").build();
		}
	}
}
