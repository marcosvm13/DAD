package es.urjc.hotelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva,Long>{

	Reserva findByHuesped(Huesped huesped);
	
}

