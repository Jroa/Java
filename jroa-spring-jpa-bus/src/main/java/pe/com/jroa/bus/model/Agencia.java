package pe.com.jroa.bus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Agencia")
public class Agencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idAgencia")
    private int idAgencia;
	@Column(name="nombre")
    private String nombre;
	@Column(name="direccion")
    private String direccion;
    
	public int getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
