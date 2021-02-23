package es.urjc.hotelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reseya {
	
	/*
	 * reserva asociada
	 * puntuacion
	 * texto
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private Reserva reserva;
	
	private float puntuacion;
	
	private String texto;

	public Reseya(Reserva reserva, float puntuacion, String texto) {
		this.reserva = reserva;
		this.puntuacion = puntuacion;
		this.texto = texto;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public float getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public long getId() {
		return id;
	}
	
	
	 
	
}
