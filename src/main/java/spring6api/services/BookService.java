package spring6api.services;

import spring6api.models.AuthorDTO;
import spring6api.models.BookDTO;

public interface BookService {
    public BookDTO saveNewBook(BookDTO dto);
}
