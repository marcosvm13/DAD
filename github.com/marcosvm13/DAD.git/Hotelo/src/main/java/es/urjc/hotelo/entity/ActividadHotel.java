package es.urjc.hotelo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ActividadHotel{
	/*
	 * Clase Que hereda de Actividad que representa las actividades disponibles de un hotel
	 * Lista de Hoteles asociadas con la actividad
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	private int plazas;
	
	
	@ManyToMany
	private List<Hotel> hoteles;
	
	public ActividadHotel() {
		
	}
	
	public ActividadHotel(String nombre, String descripcion, int plazas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.plazas = plazas;
	    this.hoteles = new ArrayList<Hotel>();
	}


	public long getId() {
		return id;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
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
		return "ActividadHotel [hoteles=" + hoteles + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getDescripcion()=" + getDescripcion() + ", getPlazas()=" + getPlazas() + "]";
	}

	
	
	
}
