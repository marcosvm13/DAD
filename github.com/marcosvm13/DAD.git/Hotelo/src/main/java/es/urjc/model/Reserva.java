package es.urjc.model;

import java.util.List;

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
	
	private String fecha;
	
	public Reserva(Huesped huesped, Habitacion habitacion,  String fecha) {
		

		this.huesped = huesped;
		this.habitacion = habitacion;

		this.fecha = fecha;
		this.reseyas = null;
	}
	
	public Long getId() {
		return id;
	}
	

	
	public Huesped getHuesped() {
		return huesped;
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
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
		
}
