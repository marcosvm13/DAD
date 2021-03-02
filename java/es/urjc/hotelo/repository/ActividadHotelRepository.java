package es.urjc.hotelo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.hotelo.entity.ActividadHotel;


public interface ActividadHotelRepository extends JpaRepository<ActividadHotel,Long>{
		List<ActividadHotel> findByNombre(String nombre);
}
