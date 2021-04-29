package es.urjc.hotelo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Reserva;
@Repository
public interface HabitacionRepository extends CrudRepository<Habitacion,Long>{

	Habitacion findByNumero(int numero);
	
	Habitacion findByReserva(Reserva reserva);
}
