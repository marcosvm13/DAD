package es.urjc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.model.ActividadHotel;


public interface ActividadHotelRepository extends JpaRepository<ActividadHotel,Long>{
		List<ActividadHotel> findByNombreActividad(String nombre);
}
