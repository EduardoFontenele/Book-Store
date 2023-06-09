package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import spring6api.entities.Book;
import spring6api.exceptions.NullPathVarException;
import spring6api.factories.BookFactory;
import spring6api.mappers.BookMapper;
import spring6api.models.BookDTO;
import spring6api.repositories.AuthorRepository;
import spring6api.repositories.BookRepository;
import spring6api.services.BookService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 5;

    @Override
    public BookDTO saveNewBook(BookDTO dto) {
        Book bookEntity = bookMapper.dtoToEntity(dto);
        bookEntity.setAuthor(authorRepository.findById(dto.getAuthor_id()).get());
        bookRepository.save(bookEntity);
        return BookFactory.entityToBookDto(bookEntity);
    }

    @Override
    public Optional<BookDTO> findBookById(Integer id) {
        if(id == null || id <= 0) throw new NullPathVarException();
        if(bookRepository.findById(id).isEmpty())
            throw new NoSuchElementException("Element with id " + id + " does not exist in the database");
        Book foundBook = bookRepository.findById(id).get();
        BookDTO dto = bookMapper.entityToDto(foundBook);
        dto.setAuthor(foundBook.getAuthor().getName());
        return Optional.of(dto);
    }

    @Override
    public Page<BookDTO> listBooks(String bookCategory, String author, Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
        Page<Book> booksPage;

        if(StringUtils.hasText(bookCategory) && !StringUtils.hasText(author)) {
            booksPage = listBooksByCategory(bookCategory, pageRequest);
        } else if(!StringUtils.hasText(bookCategory) && StringUtils.hasText(author)) {
            booksPage = listBooksByAuthorName(author, pageRequest);
        } else {
            booksPage = bookRepository.findAll(pageRequest);
        }

        return booksPage.map(BookFactory::entityToBookDto);
    }

    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize) {
        int queryPageNumber;
        int queryPageSize;

        if(pageNumber != null && pageNumber > 0) {
            queryPageNumber = pageNumber - 1;
        } else {
            queryPageNumber = DEFAULT_PAGE;
        }

        if(pageSize == null) {
            queryPageSize = DEFAULT_PAGE_SIZE;
        } else {
            if(pageSize > 20) {
                queryPageSize = 20;
            } else {
                queryPageSize = pageSize;
            }
        }

        Sort sort = Sort.by(Sort.Order.asc("name"));

        return PageRequest.of(queryPageNumber, queryPageSize, sort);
    }

    private Page<Book> listBooksByAuthorName(String author, Pageable pageRequest) {
        return bookRepository.findAllByAuthor_Name(author, pageRequest);
    }

    private Page<Book> listBooksByCategory(String category, Pageable pageRequest) {
        return bookRepository.findAllByMainCategoryIsLikeIgnoreCase("%" + category + "%", pageRequest);
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
