package es.urjc.hotelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
	
	private String fechaDeEntrada;
	
	private String fechaDeSalida;
	

	public Reserva() {
		
	}
	
	public Reserva(Huesped huesped, Habitacion habitacion,  String fechaDeEntrada,  String fechaDeSalida) {
		
		this.huesped = huesped;
		this.habitacion = habitacion;

		this.fechaDeEntrada = fechaDeEntrada;
		this.fechaDeSalida = fechaDeSalida;
		
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
