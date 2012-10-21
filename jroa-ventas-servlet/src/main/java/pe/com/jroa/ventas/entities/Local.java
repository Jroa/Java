package pe.com.jroa.ventas.entities;

import java.io.Serializable;

public class Local implements Serializable{
	private static final long serialVersionUID = -120695641190462064L;
	
	private int id;
	private String nombre;
	
	public Local(){
	}
	
	public Local(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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
	
	
	
}
