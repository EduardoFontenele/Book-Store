package spring6api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring6api.models.BookDTO;
import spring6api.services.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final static String BOOK_PATH = "books";

    @PostMapping(value = BOOK_PATH)
    public ResponseEntity<BookDTO> saveNewBook(@Validated @RequestBody BookDTO dto) {
        return new ResponseEntity<>(bookService.saveNewBook(dto), HttpStatus.CREATED);
    }
}
