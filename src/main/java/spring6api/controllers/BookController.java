package spring6api.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring6api.exceptions.NotFoundException;
import spring6api.exceptions.NullPathVarException;
import spring6api.models.BookDTO;
import spring6api.services.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final static String BOOK_PATH = "book";
    private final static String BOOK_PATH_ID = "book/{id}";
    private final static String BOOKS_PATH = "books";

    @PostMapping(value = BOOK_PATH)
    public ResponseEntity<BookDTO>  saveNewBook(@RequestBody @Validated BookDTO dto) {
        return new ResponseEntity<>(bookService.saveNewBook(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = BOOK_PATH_ID)
    public ResponseEntity<BookDTO> findBookById(@PathVariable("id") Integer id) {
        if(id == null || id <= 0) throw new NullPathVarException();
        return ResponseEntity.ok(bookService.findBookById(id).orElseThrow(NotFoundException::new));
    }

    @GetMapping(value = BOOKS_PATH)
    public List<BookDTO> findAllBooks() {
        return bookService.findAllBooks();
    }

}
