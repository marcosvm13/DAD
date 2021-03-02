package es.urjc.hotelo.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ServicioHabitacion {
 
	@ManyToMany
	private List<Habitacion> habitacion;
	
	public ServicioHabitacion() {
	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	 * Nombre
	 * Descripción del servicio
	 */
	
	private String nombre;
	
	private String descripcion;
	
	
	public long getId() {
		return id;
	}


	public ServicioHabitacion(String nombre, String descripcion) {
		super();
		this.habitacion = new LinkedList<>();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Habitacion> getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(List<Habitacion> habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
}
