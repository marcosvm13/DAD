package es.urjc.hotelo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Huesped {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	/*
	 * Nombre
	 * Apellidos
	 * Contraseya
	 * Telefono
	 * Correo electrónico
	 * Lista de reservas asociadas
	 */
	
	private String nombreHuesped;
	
	private String apellidos;
	
	private long telefono;
	
	private String correo;

	@OneToMany(mappedBy="huesped")
	private List<Reserva> reserva;
	
	public Huesped() {
		
	}

	public Huesped(String nombreHuesped, String apellidos, long telefono, String correo, List<Reserva> reservas) {
		super();
		this.nombreHuesped = nombreHuesped;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.reserva = reservas;
	}

	public long getId() {
		return id;
	}

	public String getNombreHuesped() {
		return nombreHuesped;
	}

	public void setNombreHuesped(String nombreHuesped) {
		this.nombreHuesped = nombreHuesped;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Reserva> getReservas() {
		return reserva;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reserva = reservas;
	}
	
	
}
