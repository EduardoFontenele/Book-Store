package spring6api.services;

import spring6api.models.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public BookDTO saveNewBook(BookDTO dto);

    Optional<BookDTO> findBookById(Integer id);

    List<BookDTO> findAllBooks();
}
