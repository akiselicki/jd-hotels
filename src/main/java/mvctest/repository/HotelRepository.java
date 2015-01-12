package mvctest.repository;


import java.util.List;

import mvctest.model.Hotel;

import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
	@Override
	List<Hotel> findAll();
}
