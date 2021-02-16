package es.urjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.model.Reserva;
import es.urjc.model.Reseya;

public interface ReseyaRepository extends JpaRepository<Reseya,Long>{
	
	Reseya findByReserva (Reserva reserva);
	
	List<Reseya> findByPuntuacion (float puntuacion);

}
