package es.urjc.hotelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Reserva;

public interface HabitacionRepository extends JpaRepository<Habitacion,Long>{

	Habitacion findByNumero(int numero);
	
	Habitacion findByReserva(Reserva reserva);
}
