package es.urjc.hotelo.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.entity.ActividadHotel;

@Repository
public interface ActividadHotelRepository extends CrudRepository<ActividadHotel,Long>{
		ActividadHotel findByNombre(String nombre);
}
