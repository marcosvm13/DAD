package es.urjc.hotelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.ActividadHotel;
import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Hotel;



public interface HotelRepository extends JpaRepository<Hotel,Long>{

	Hotel findByNombreHotel(String nombreHotel);
	
	Hotel findByHabitacion(Habitacion Habitacion);
	
	List<Hotel> findByActividadHotel(ActividadHotel actividadHotel);
	
	List<Hotel> findAll();
	
	
}