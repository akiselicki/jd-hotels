package mvctest.controller;

import java.util.List;

import javax.validation.Valid;

import mvctest.model.Room;
import mvctest.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/rooms")
public class RestRoomController {
	private RoomRepository roomRepository;

	@Autowired
	public RestRoomController(RoomRepository roomRepository){
		this.roomRepository = roomRepository;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Room create(@RequestBody @Valid Room room){
		return this.roomRepository.save(room);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Room> list() {
		return this.roomRepository.findAll();
	}
	
	@RequestMapping(value="/hotel", method=RequestMethod.GET)
	public List<Room> listByHotel() {
		return this.roomRepository.findAll();
	}
	@RequestMapping(value="/hotel/{id}", method=RequestMethod.GET)
	public List<Room> listByHotel(@PathVariable("id") long id) {
		return this.roomRepository.findAllByHotelId(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Room get(@PathVariable("id") long id) {
		return this.roomRepository.findOne(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Room update(@PathVariable("id") long id, @RequestBody @Valid Room room) {
		return roomRepository.save(room);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		this.roomRepository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
