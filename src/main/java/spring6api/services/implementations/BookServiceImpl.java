package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring6api.entities.Book;
import spring6api.factories.BookFactory;
import spring6api.mappers.BookMapper;
import spring6api.models.BookDTO;
import spring6api.repositories.AuthorRepository;
import spring6api.repositories.BookRepository;
import spring6api.services.BookService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public BookDTO saveNewBook(BookDTO dto) {
        Book bookEntity = bookMapper.dtoToEntity(dto);
        bookEntity.setAuthor(authorRepository.findById(dto.getAuthor_id()).get());
        bookRepository.save(bookEntity);
        return BookFactory.entityToBookDto(bookEntity);
    }

    @Override
    public Optional<BookDTO> findBookById(Integer id) {
        return Optional.of(bookMapper.entityToDto(bookRepository.findById(id).get()));
    }

    @Override
    public List<BookDTO> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::entityToDto)
                .toList();
    }

    @Override
    @Transactional
    public Boolean updateBookById(Integer id, BookDTO dto) {
        if(bookRepository.existsById(id)) {
            bookRepository.findById(id).ifPresent(foundBook -> {
                foundBook.setId(id);
                foundBook.setName(dto.getName());
                foundBook.setQuantity(dto.getQuantity());
                foundBook.setPrice(dto.getPrice());
                foundBook.setDescription(dto.getDescription());
                foundBook.setMain_category(dto.getCategory());
                foundBook.setAuthor(foundBook.getAuthor());
            });
            return true;
        };

        return false;
    }
}
