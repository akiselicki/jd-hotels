package mvctest.validator;

import mvctest.model.User;
import mvctest.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
	
	private static final String USERNAME_FIELD_NAME = "username";
	private static final String PASSWORD_FIELD_NAME = "password";
	private static final String MUST_NOT_BE_EMPTY = "mandatory";

	private static final int PASSWORD_LENGHT = 5;
	private static final String PASSWORD_MESSAGE_KEY = "Passowrd must be at least five characters long.";
	private static final String USERS_EMAIL_ALLREADY_EXISTS = "User with the same email address already exists.";
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target != null && supports(target.getClass())) {
			User user = (User) target;

			if (user.getUsername() == null || user.getUsername().equals("")) {
				errors.rejectValue(USERNAME_FIELD_NAME, MUST_NOT_BE_EMPTY);
			} else {
				User userDb = userRepository.findAllByusername(user.getUsername());
				if (userDb != null) {
					errors.rejectValue(USERNAME_FIELD_NAME, USERS_EMAIL_ALLREADY_EXISTS);
				}
			}
			
			if (user.getPassword() == null || user.getPassword().equals("")) {
				errors.rejectValue(PASSWORD_FIELD_NAME, MUST_NOT_BE_EMPTY);
			} else if (user.getPassword().length() < PASSWORD_LENGHT) {
				errors.rejectValue(PASSWORD_FIELD_NAME, PASSWORD_MESSAGE_KEY);
			} 
		}

	}
}
