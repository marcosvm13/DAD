package es.urjc.hotelo.entity;

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
	private List<Habitacion> habitacion;
	
	@ManyToMany(mappedBy="hoteles")
	private List<ActividadHotel> actividadHotel;

	private float estrellas;

	public Hotel() {
		
	}
	
	public Hotel(String nombreHotel, String direccion, List<Habitacion> habitaciones,
			List<ActividadHotel> actividades, float estrellas) {
		super();
		this.nombreHotel = nombreHotel;
		this.direccion = direccion;
		this.habitacion = habitaciones;
		this.actividadHotel = actividades;
		this.estrellas = estrellas;
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
		return habitacion;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitacion = habitaciones;
	}

	public List<ActividadHotel> getActividades() {
		return actividadHotel;
	}

	public void setActividades(List<ActividadHotel> actividades) {
		this.actividadHotel = actividades;
	}
	
	public float getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(float estrellas) {
		this.estrellas = estrellas;
	}
	
}
