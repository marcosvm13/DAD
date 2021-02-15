package es.urjc.model;

import java.util.List;

import javax.persistence.ManyToMany;

public class ActividadHotel extends Actividad{
	/*
	 * Clase Que hereda de Actividad que representa las actividades disponibles de un hotel
	 * Lista de Hoteles asociadas con la actividad
	 */
	
	@ManyToMany
	private List<Hotel> hoteles;
	
	public ActividadHotel(String nombre, String descripcion, int plazas, List<Hotel> hoteles) {
		super(nombre, descripcion, plazas);
		this.hoteles = hoteles;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
	
}
