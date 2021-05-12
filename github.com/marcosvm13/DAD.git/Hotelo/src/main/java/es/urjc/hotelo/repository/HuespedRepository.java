package es.urjc.hotelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;


public interface HuespedRepository extends JpaRepository<Huesped,Long>{

	Optional<Huesped> findByNombreHuesped(String nombreHuesped);
	
	Huesped findByCorreo(String correo);
	
	Huesped findByTelefono(long telefono);
	
	Huesped findByReserva(Reserva reserva);
}