package es.urjc.model;

import java.util.List;

import javax.persistence.ManyToMany;

public class ServicioHabitacion extends Actividad{
	/*
	 * Clase Que hereda de Actividad que representa los servicios de una habitacion
	 * Lista de Habitaciones asociadas con el servicion
	 */
	@ManyToMany
	private List<Habitacion> habitacion;
	
	public ServicioHabitacion(String nombreServicio, String descripcion, int plazas, List<Habitacion> habitacion) {
		super(nombreServicio, descripcion, plazas);
		this.habitacion = habitacion;
	}

	public List<Habitacion> getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(List<Habitacion> habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
}
