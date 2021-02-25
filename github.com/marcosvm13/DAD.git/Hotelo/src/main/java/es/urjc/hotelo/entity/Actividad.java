package es.urjc.hotelo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

public class Actividad{

	
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

	@Override
	public String toString() {
		return "Actividad [nombre=" + nombre + ", descripcion=" + descripcion + ", plazas=" + plazas
				+ "]";
	}

	
}
