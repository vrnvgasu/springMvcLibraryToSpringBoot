package ru.edu.Project2Boot.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.Project2Boot.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByFullName(String fullName);

}
