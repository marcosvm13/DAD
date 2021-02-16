package es.urjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.model.Habitacion;
import es.urjc.model.ServicioHabitacion;

public interface ServicioHabitacionRepository  extends JpaRepository<ServicioHabitacion,Long>{

	List<ServicioHabitacion> findByNombreServicio(String nombreServicio);
	
	List<ServicioHabitacion> findByHabitacion(Habitacion habitacion);
}
