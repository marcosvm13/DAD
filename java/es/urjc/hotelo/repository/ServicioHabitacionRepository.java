package es.urjc.hotelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.ServicioHabitacion;

public interface ServicioHabitacionRepository  extends JpaRepository<ServicioHabitacion,Long>{

	List<ServicioHabitacion> findByNombre(String nombreServicio);
	
	List<ServicioHabitacion> findByHabitacion(Habitacion habitacion);
}
