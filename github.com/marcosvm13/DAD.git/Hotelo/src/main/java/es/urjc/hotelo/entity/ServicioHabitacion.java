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
	/*
	 * Clase Que hereda de Actividad que representa los servicios de una habitacion
	 * Lista de Habitaciones asociadas con el servicion
	 */
	@ManyToMany
	private List<Habitacion> habitacion;
	
	public ServicioHabitacion() {
	
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private int plazas;
	
	
	public long getId() {
		return id;
	}


	public ServicioHabitacion(String nombre, String descripcion, int plazas) {
		super();
		this.habitacion = new LinkedList<>();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.plazas = plazas;
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


	public int getPlazas() {
		return plazas;
	}


	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}


	public List<Habitacion> getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(List<Habitacion> habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
}
