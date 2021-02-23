package es.urjc.hotelo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actividad {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	/*
	 * Nombre
	 * Descripcion
	 * plazas
	 */
	
	private String nombre;
	
	private String descripcion;
	
	private int plazas;
	
	public Actividad() {
		
	}

	public Actividad(String nombre, String descripcion, int plazas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.plazas = plazas;
		
	}

	public long getId() {
		return id;
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

}
