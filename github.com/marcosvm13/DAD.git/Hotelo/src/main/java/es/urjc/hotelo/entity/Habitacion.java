package es.urjc.hotelo.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	/*
	 * Número
	 * Hotel
	 * Reservas
	 * Tamayo
	 * Imagenes
	 * Servicios
	 */

	private int numero;
	
	@ManyToOne
	private Hotel hotel;
	
	@OneToMany(mappedBy="habitacion")
	private List<Reserva> reserva;
	
	private String tamayo;
	
	
	private HashSet<LocalDate> ocupacion;
	
	//private List<MultipartFile> imagenes;
	
	@ManyToMany
	private List<ServicioHabitacion> servicios;

	
	public Habitacion() {
		
	}

	public Habitacion(int numero, Hotel hotel, List<Reserva> reservas, String tamayo, /*List<MultipartFile> imagenes,*/
			List<ServicioHabitacion> servicios) {
		this.numero = numero;
		this.hotel = hotel;
		this.reserva = reservas;
		this.tamayo = tamayo;
		//this.imagenes = imagenes;
		this.servicios = servicios;
		ocupacion = new HashSet<>();
	}

	public HashSet<LocalDate> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(HashSet<LocalDate> ocupacion) {
		this.ocupacion = ocupacion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Reserva> getReservas() {
		return reserva;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reserva = reservas;
	}

	public String getTamayo() {
		return tamayo;
	}

	public void setTamayo(String tamayo) {
		this.tamayo = tamayo;
	}

	/*public List<MultipartFile> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<MultipartFile> imagenes) {
		this.imagenes = imagenes;
	}*/

	public List<ServicioHabitacion> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioHabitacion> servicios) {
		this.servicios = servicios;
	}

	public long getId() {
		return id;
	}
	
	
	
}
