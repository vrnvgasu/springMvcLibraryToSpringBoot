package ru.edu.Project2Boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.edu.Project2Boot.models.Book;
import ru.edu.Project2Boot.models.User;
import ru.edu.Project2Boot.services.BookService;

@Component
public class BookValidator implements Validator {

	protected final BookService bookService;

	@Autowired
	public BookValidator(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Book book = (Book) target;

		if (bookService.findByTitleAndAuthorAndPublishedAt(book.getTitle(), book.getAuthor(), book.getPublishedAt())
				.isPresent()) {
			errors.rejectValue("title", "", "Такая книга уже существует");
			errors.rejectValue("author", "", "Такая книга уже существует");
			errors.rejectValue("published_at", "", "Такая книга уже существует");
		}
	}

}
