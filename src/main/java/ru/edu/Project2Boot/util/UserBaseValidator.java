package ru.edu.Project2Boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import ru.edu.Project2Boot.models.User;
import ru.edu.Project2Boot.services.UserService;

@Component
abstract public class UserBaseValidator implements Validator {

	protected final UserService userService;

	@Autowired
	public UserBaseValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

}
