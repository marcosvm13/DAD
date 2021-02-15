package es.urjc.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;

public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	/*
	 * Numero
	 * Hotel
	 * Reservas
	 * Tamayo
	 * Imagenes
	 * Servicios
	 * huespedes
	 */

	private int numero;
	
	@ManyToOne
	private Hotel hotel;
	
	@OneToMany(mappedBy="habitacion")
	private List<Reserva> reservas;
	
	private String tamayo;
	
	private List<MultipartFile> imagenes;
	
	@ManyToMany
	private List<ServicioHabitacion> servicios;

	
	
	
	public Habitacion(int numero, Hotel hotel, List<Reserva> reservas, String tamayo, List<MultipartFile> imagenes,
			List<ServicioHabitacion> servicios) {
		this.numero = numero;
		this.hotel = hotel;
		this.reservas = reservas;
		this.tamayo = tamayo;
		this.imagenes = imagenes;
		this.servicios = servicios;
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
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getTamayo() {
		return tamayo;
	}

	public void setTamayo(String tamayo) {
		this.tamayo = tamayo;
	}

	public List<MultipartFile> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<MultipartFile> imagenes) {
		this.imagenes = imagenes;
	}

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
