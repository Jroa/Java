package pe.com.jroa.bus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bus")
public class Bus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idBus")
    private int idBus;
	@Column(name="placa")
    private String placa;
	@Column(name="numAsiento")
    private int numAsiento;
	@Column(name="estado")
    private int estado;
    
	public int getIdBus() {
		return idBus;
	}
	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getNumAsiento() {
		return numAsiento;
	}
	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
    
    
}
