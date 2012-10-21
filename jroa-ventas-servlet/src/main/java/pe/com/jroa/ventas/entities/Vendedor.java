package pe.com.jroa.ventas.entities;

import java.util.Date;

public class Vendedor {
	private int id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String direccion;
	private Date fecnac;
	private boolean sexo;
	private Local local;
	private String usuario;
	
	
	public Vendedor() {
	}
	
	
	public Vendedor(int id, String nombre, String apellido, String telefono,
			String direccion, Date fecnac, boolean sexo, Local local,
			String usuario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fecnac = fecnac;
		this.sexo = sexo;
		this.local = local;
		this.usuario = usuario;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFecnac() {
		return fecnac;
	}
	public void setFecnac(Date fecnac) {
		this.fecnac = fecnac;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
