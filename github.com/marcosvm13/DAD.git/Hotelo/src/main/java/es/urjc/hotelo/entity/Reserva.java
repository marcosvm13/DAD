package es.urjc.hotelo.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/*
	 * huesped
	 * habitacion
	 * reseyas
	 * fecha
	 */
	
	@ManyToOne
	private Huesped huesped;
	
	@ManyToOne
	private Habitacion habitacion;
	
	
	@OneToOne
	private Reseya reseyas;
	
	private String fechaDeEntrada;
	private String fechaDeSalida;
	
	private AtomicBoolean reservado;
	
	
	public Reserva() {
		
	}
	
	public Reserva(Huesped huesped, Habitacion habitacion,  String fechaDeEntrada,  String fechaDeSalida) {
		
		this.reservado.set(false);
		this.huesped = huesped;
		this.habitacion = habitacion;

		this.fechaDeEntrada = fechaDeEntrada;
		this.fechaDeSalida = fechaDeSalida;
		this.reseyas = null;
	}
	
	public Long getId() {
		return id;
	}
	
	public Huesped getHuesped() {
		return huesped;
	}
	
	
	
	public AtomicBoolean getReservado() {
		return reservado;
	}

	public void setReservado(AtomicBoolean reservado) {
		this.reservado = reservado;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}
	
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
	public Reseya getReseyas() {
		return reseyas;
	}
	
	public void setReseyas(Reseya reseyas) {
		this.reseyas = reseyas;
	}

	public String getFechaDeEntrada() {
		return fechaDeEntrada;
	}

	public void setFechaDeEntrada(String fechaDeEntrada) {
		this.fechaDeEntrada = fechaDeEntrada;
	}

	public String getFechaDeSalida() {
		return fechaDeSalida;
	}

	public void setFechaDeSalida(String fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	

		
}
