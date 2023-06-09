package spring6api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring6api.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByMainCategoryIsLikeIgnoreCase(String category, Pageable pageable);
    Page<Book> findAllByAuthor_Name(String author, Pageable pageable);
}
