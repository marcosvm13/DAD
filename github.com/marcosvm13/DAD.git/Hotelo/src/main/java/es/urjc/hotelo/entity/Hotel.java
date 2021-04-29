package es.urjc.hotelo.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.hotelo.controller.HotelView;

@Entity
@RedisHash("Hotel")
public class Hotel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	 * Nombre
	 * Dirección
	 * Lista de habitaciones
	 * Actividades
	 */
	@JsonView(Views.Public.class)
	private String nombreHotel;
	@JsonView(Views.Public.class)
	private String localidad;
	@JsonView(Views.Public.class)
	private String direccion;
	
	@OneToMany(mappedBy="hotel", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER) 
	@JsonIgnoreProperties("hotel")
	private List<Habitacion> habitacion;
	
	@ManyToMany(mappedBy="hoteles",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnoreProperties("hoteles")
	private List<ActividadHotel> actividadHotel;
	@JsonView(Views.Public.class)
	private int estrellas;

	public Hotel() {
		
	}
	
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Hotel(String nombreHotel, String direccion,  String localidad,
			 int estrellas) {
		super();
		this.nombreHotel = nombreHotel;
		this.direccion = direccion;
		this.habitacion =  new LinkedList<>();
		this.actividadHotel = new LinkedList<>();
		this.estrellas = estrellas;
		this.localidad = localidad;
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

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", nombreHotel=" + nombreHotel + ", direccion=" + direccion + ", estrellas=" + estrellas + "]";
	}
	
}
