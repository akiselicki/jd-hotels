package mvctest.repository;

import java.util.List;

import mvctest.model.Room;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long>{
	@Override
	List<Room> findAll();
	
	List<Room> findAllByHotelId(Long id);
}
