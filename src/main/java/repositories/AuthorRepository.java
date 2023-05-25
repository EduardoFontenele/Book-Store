package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6api.entities.Author;

public interface AuthorRepository extends JpaRepository<Integer, Author> {
}
