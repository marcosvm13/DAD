package es.urjc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.model.ActividadHotel;
import es.urjc.model.Habitacion;
import es.urjc.model.Hotel;



public interface HotelRepository extends JpaRepository<Hotel,Long>{

	Hotel findByNombreHotel(String nombreHotel);
	
	Hotel findByHabitacion(Habitacion Habitacion);
	
	List<Hotel> findByActividadHotel(ActividadHotel actividadHotel);
}