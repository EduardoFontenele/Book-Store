package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import spring6api.entities.Book;
import spring6api.factories.BookFactory;
import spring6api.mappers.BookMapper;
import spring6api.models.BookDTO;
import spring6api.repositories.AuthorRepository;
import spring6api.repositories.BookRepository;
import spring6api.services.BookService;

import java.util.ArrayList;
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
        Book foundBook = bookRepository.findById(id).get();
        BookDTO dto = bookMapper.entityToDto(foundBook);
        dto.setAuthor(foundBook.getAuthor().getName());
        return Optional.of(dto);
    }

    @Override
    public List<BookDTO> findAllBooks(String bookCategory, String author) {

        List<Book> listOfBooks;

        if(StringUtils.hasText(bookCategory) && !StringUtils.hasText(author)) {
            listOfBooks = listBooksByCategory(bookCategory);
        }
        else if(!StringUtils.hasText(bookCategory) && StringUtils.hasText(author)) {
            listOfBooks = listBooksByAuthorName(author);
        } else {
            listOfBooks = bookRepository.findAll();
        }

        return listOfBooks.stream()
                .map(BookFactory::entityToBookDto)
                .toList();
    }

    private List<Book> listBooksByAuthorName(String author) {
        return bookRepository.findAllByAuthor_Name(author);
    }

    private List<Book> listBooksByCategory(String category) {
        return bookRepository.findAllByMainCategoryIsLikeIgnoreCase("%" + category + "%");
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
                foundBook.setMainCategory(dto.getCategory());
                foundBook.setAuthor(foundBook.getAuthor());
            });
            return true;
        };

        return false;
    }

    @Override
    public Boolean patchBookById(Integer id, BookDTO dto) {
        if(bookRepository.existsById(id)) {
            bookRepository.findById(id).ifPresent(foundBook -> {
                foundBook.setName(dto.getName());
                if(dto.getPrice() != null) foundBook.setPrice(dto.getPrice());
                foundBook.setAuthor(foundBook.getAuthor());
                if(dto.getQuantity() != null) foundBook.setQuantity(dto.getQuantity());
                if(dto.getDescription() != null) foundBook.setDescription(dto.getDescription());
                if(dto.getCategory() != null) foundBook.setMainCategory(dto.getCategory());
                bookRepository.save(foundBook);
            });
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteBookById(Integer id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
