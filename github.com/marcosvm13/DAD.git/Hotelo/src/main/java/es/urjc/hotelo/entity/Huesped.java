package es.urjc.hotelo.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Huesped {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	/*
	 * Nombre
	 * Apellidos
	 * Telefono
	 * Correo electrónico
	 * Lista de reservas asociadas
	 * Contraseya
	 * Roles
	 */
	
	private String nombreHuesped;
	
	private String apellidos;
	
	private long telefono;
	
	private String correo;

	@OneToMany(mappedBy="huesped")
	private List<Reserva> reserva;
	
	@JsonIgnore
	private String hashContraseya;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	
	public Huesped() {
		
	}

	public Huesped(String nombreHuesped, String hashContraseya, List<String> roles) {
		super();
		this.nombreHuesped = nombreHuesped;
		this.hashContraseya = hashContraseya;
		this.roles = roles;
	}

	public Huesped(String nombreHuesped, String apellidos, long telefono, String correo) {
		super();
		this.nombreHuesped = nombreHuesped;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.reserva = new LinkedList<>();;
	}

	public Huesped(String nombreHuesped, String apellidos, long telefono, String correo, List<Reserva> reserva,
			String hashContraseya, String... roles) {
		super();
		this.nombreHuesped = nombreHuesped;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.reserva = reserva;
		this.hashContraseya = hashContraseya;
		this.roles = List.of(roles);
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

	
	
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public void setHashContraseya(String hashContraseya) {
		this.hashContraseya = hashContraseya;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getHashContraseya() {
		return hashContraseya;
	}

	public List<String> getRoles() {
		return roles;
	}

}
