package es.urjc.hotelo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.ActividadHotel;


public interface ActividadHotelRepository extends JpaRepository<ActividadHotel,Long>{
		ActividadHotel findByNombre(String nombre);
}
