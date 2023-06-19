package spring6api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6api.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
