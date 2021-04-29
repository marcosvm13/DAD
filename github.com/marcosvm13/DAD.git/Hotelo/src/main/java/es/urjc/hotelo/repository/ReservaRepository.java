package es.urjc.hotelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva,Long>{

	Reserva findByHuesped(Huesped huesped);
	
}

