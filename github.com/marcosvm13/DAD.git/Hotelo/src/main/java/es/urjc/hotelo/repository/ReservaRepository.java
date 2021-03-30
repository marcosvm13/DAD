package es.urjc.hotelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva,Long>{

	Reserva findByHuesped(Huesped huesped);
	
}

