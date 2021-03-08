package es.urjc.hotelo.entity;



import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




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
	
	@OneToMany(mappedBy="habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reserva> reserva;
	
	private String tamayo;
	
    @Column(length = 16777215)
	private HashSet<String> ocupacion;
	
	//private List<MultipartFile> imagenes;
	
	

	
	public Habitacion() {
		
	}

	public Habitacion(int numero, Hotel hotel, String tamayo /*List<MultipartFile> imagenes,*/
			) {
		this.numero = numero;
		this.hotel = hotel;
		this.reserva = new LinkedList<>();
		this.tamayo = tamayo;
		//this.imagenes = imagenes;
		//this.servicios = new LinkedList<>();
		ocupacion = new HashSet<>();
	}

	public HashSet<String> getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(HashSet<String> ocupacion) {
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

	

	public long getId() {
		return id;
	}
	
	
	
}
