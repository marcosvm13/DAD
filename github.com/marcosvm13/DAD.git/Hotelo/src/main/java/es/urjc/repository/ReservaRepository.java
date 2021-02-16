package es.urjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.model.Huesped;
import es.urjc.model.Reserva;
import es.urjc.model.Reseya;

public interface ReservaRepository extends JpaRepository<Reserva,Long>{

	List<Reserva> findByHuesped(Huesped huesped);
	
	Reserva findByReseya(Reseya reseya);
}

