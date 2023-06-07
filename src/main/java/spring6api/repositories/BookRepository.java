package spring6api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring6api.entities.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByMainCategoryIsLikeIgnoreCase(String category);
    List<Book> findAllByAuthor_Name(String author);
}
