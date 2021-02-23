package es.urjc.hotelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;


public interface HuespedRepository extends JpaRepository<Huesped,Long>{

	List<Huesped> findByNombreHuesped(String nombreHuesped);
	
	Huesped findByCorreo(String correo);
	
	Huesped findByTelefono(long telefono);
	
	Huesped findByReserva(Reserva reserva);
}