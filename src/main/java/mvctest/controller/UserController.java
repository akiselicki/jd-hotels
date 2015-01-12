package mvctest.controller;

import javax.validation.Valid;

import mvctest.model.Authority;
import mvctest.model.User;
import mvctest.repository.AuthorityRepository;
import mvctest.repository.UserRepository;
import mvctest.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String signupForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String signup(@Valid User user, BindingResult bindingResult, Model model,
			@RequestParam(value="username", required=false) String username, @RequestParam(value="password", required=false) String password) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		
		userValidator.validate(newUser, bindingResult);

		if (!bindingResult.hasErrors()) {
			userRepository.save(newUser);
			
			Authority newAuthority = new Authority();
			newAuthority.setAuthority("USER");
			newAuthority.setUser(newUser);
			authorityRepository.save(newAuthority);
			
			return "login";
		}
		return "register";
	}
}
