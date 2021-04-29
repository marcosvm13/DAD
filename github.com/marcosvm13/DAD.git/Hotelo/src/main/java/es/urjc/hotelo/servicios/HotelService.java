package es.urjc.hotelo.servicios;


import es.urjc.hotelo.entity.Hotel;

public interface  HotelService {

    Hotel findById(Long id);

    void updateHotel(Hotel post);

    void deleteHotel(Long id);
}
