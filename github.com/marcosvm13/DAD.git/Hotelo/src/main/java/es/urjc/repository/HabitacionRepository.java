package es.urjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import es.urjc.model.Habitacion;
import es.urjc.model.Reserva;

public interface HabitacionRepository extends JpaRepository<Habitacion,Long>{

	List<Habitacion> findByNumero(int numero);
	
	Habitacion findByReserva(Reserva reserva);
}
