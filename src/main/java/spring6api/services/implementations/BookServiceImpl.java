package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring6api.entities.Book;
import spring6api.factories.BookFactory;
import spring6api.mappers.AuthorMapper;
import spring6api.mappers.BookMapper;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;
import spring6api.models.BookDTO;
import spring6api.models.BookFullDTO;
import spring6api.repositories.AuthorRepository;
import spring6api.repositories.BookRepository;
import spring6api.services.BookService;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public BookDTO saveNewBook(BookDTO dto) {
        Book bookEntity = bookMapper.dtoToEntity(dto);
        bookEntity.setAuthor(authorRepository.findById(dto.getAuthor_id()).get());
        bookRepository.save(bookEntity);
        return BookFactory.entityToBookDto(bookEntity);
    }
}
