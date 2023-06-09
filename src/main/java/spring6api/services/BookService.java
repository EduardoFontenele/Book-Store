package spring6api.services;

import org.springframework.data.domain.Page;
import spring6api.models.BookDTO;

import java.util.Optional;

public interface BookService {
    BookDTO saveNewBook(BookDTO dto);
    Optional<BookDTO> findBookById(Integer id);
    Page<BookDTO> listBooks(String bookCategory, String author, Integer pageNumber, Integer pageSizer);
    Boolean updateBookById(Integer id, BookDTO dto);
    Boolean patchBookById(Integer id, BookDTO book);
    Boolean deleteBookById(Integer id);
}
