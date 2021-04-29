package es.urjc.hotelo.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.entity.ActividadHotel;
import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Hotel;


@Repository
public interface HotelRepository extends CrudRepository<Hotel,Long>{

	Hotel findByNombreHotel(String nombreHotel);
	
	Hotel findByHabitacion(Habitacion Habitacion);
		
	List<Hotel> findAllByActividadHotel(ActividadHotel actividadHotel);
	
	List<Hotel> findAll();
	
	
	
	
}