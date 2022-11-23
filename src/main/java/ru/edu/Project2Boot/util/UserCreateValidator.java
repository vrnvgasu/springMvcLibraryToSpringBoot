package ru.edu.Project2Boot.util;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import ru.edu.Project2Boot.models.User;
import ru.edu.Project2Boot.services.UserService;

@Component
public class UserCreateValidator extends UserBaseValidator {

	@Autowired
	public UserCreateValidator(UserService userService) {
		super(userService);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		if (userService.findByFullName(user.getFullName()).isPresent()) {
			errors.rejectValue("fullName", "", "This fullName is already taken");
		}

		if (user.getBirthday() > Calendar.getInstance().get(Calendar.YEAR)) {
			errors.rejectValue("birthday", "", "birthday is more than current year");
		}
	}

}
