package es.urjc.hotelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;
import es.urjc.hotelo.entity.Reseya;

public interface ReservaRepository extends JpaRepository<Reserva,Long>{

	List<Reserva> findByHuesped(Huesped huesped);
	
}

