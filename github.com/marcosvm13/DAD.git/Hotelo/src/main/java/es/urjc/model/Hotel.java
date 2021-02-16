package es.urjc.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	 * nombre
	 * direccion
	 * habitaciones
	 * actividades
	 */
	
	private String nombreHotel;
	
	private String direccion;
	
	@OneToMany(mappedBy="hotel") 
	private List<Habitacion> habitaciones;
	
	@ManyToMany(mappedBy="hotel")
	private List<ActividadHotel> actividades;

	public Hotel(String nombreHotel, String direccion, List<Habitacion> habitaciones,
			List<ActividadHotel> actividades) {
		super();
		this.nombreHotel = nombreHotel;
		this.direccion = direccion;
		this.habitaciones = habitaciones;
		this.actividades = actividades;
	}

	public long getId() {
		return id;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public List<ActividadHotel> getActividades() {
		return actividades;
	}

	public void setActividades(List<ActividadHotel> actividades) {
		this.actividades = actividades;
	}
	
}
