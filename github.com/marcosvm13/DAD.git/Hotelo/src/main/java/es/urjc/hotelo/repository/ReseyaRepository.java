package es.urjc.hotelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.Reserva;
import es.urjc.hotelo.entity.Reseya;

public interface ReseyaRepository extends JpaRepository<Reseya,Long>{
	
	Reseya findByReserva (Reserva reserva);
	
	List<Reseya> findByPuntuacion (float puntuacion);

}
