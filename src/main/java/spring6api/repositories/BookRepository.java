package spring6api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6api.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
