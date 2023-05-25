package spring6api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6api.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
