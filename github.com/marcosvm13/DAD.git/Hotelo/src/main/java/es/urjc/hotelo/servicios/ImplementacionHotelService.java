package es.urjc.hotelo.servicios;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import es.urjc.hotelo.repository.HotelRepository;
import es.urjc.hotelo.entity.Hotel;

@Repository
public class ImplementacionHotelService implements HotelService{
		@Autowired
		private HotelRepository hotelRepository;
		
	    private RedisTemplate<String, Hotel> redisTemplate;


		 public ImplementacionHotelService( RedisTemplate<String, Hotel> redisTemplate) {
			 this.redisTemplate = redisTemplate;
		 }
	
 
	    

		@Override
	    public Hotel findById(Long id) {
	        final String key = "hotel_" + id;
	        final ValueOperations<String, Hotel> operations = redisTemplate.opsForValue();
	        final boolean hasKey = redisTemplate.hasKey(key);
	        if (hasKey) {
	            final Hotel hotel = operations.get(key);
	            System.out.println("HA FUNCIONADO LA CACHE");
	            return hotel;
	        }
	        final Optional<Hotel> hotel = hotelRepository.findById(id);
	        operations.set(key, hotel.get(), 10, TimeUnit.SECONDS);      
	        return hotel.get();
	    }




	    @Override
	    public void updateHotel(Hotel hotel) {
	        final String key = "hotel_" + hotel.getId();
	        final boolean hasKey = redisTemplate.hasKey(key);
	        if (hasKey) {
	            redisTemplate.delete(key);
	        }       
	    }

	    @Override
	    public void deleteHotel(Long id) {
	        final String key = "post_" + id;
	        final boolean hasKey = redisTemplate.hasKey(key);
	        if (hasKey) {
	            redisTemplate.delete(key);
	        }
	          
	    }
	    
	}
