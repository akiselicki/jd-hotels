package mvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rooms")
public class RoomController {

	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model) {
		return "rooms/home";
	}
	
}
