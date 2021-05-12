package es.urjc.hotelo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.entity.ActividadHotel;


public interface ActividadHotelRepository extends JpaRepository<ActividadHotel,Long>{
		ActividadHotel findByNombre(String nombre);
}
