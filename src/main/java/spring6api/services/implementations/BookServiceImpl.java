package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring6api.entities.Book;
import spring6api.mappers.BookMapper;
import spring6api.models.BookDTO;
import spring6api.repositories.BookRepository;
import spring6api.services.BookService;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public BookDTO saveNewBook(BookDTO dto) {
        Book savedBook = bookMapper.DtoToEntity(dto);
        bookRepository.save(savedBook);
        return bookMapper.entityToDto(savedBook);
    }
}
