package spring6api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring6api.exceptions.NotFoundException;
import spring6api.exceptions.NullPathVarException;
import spring6api.models.BookDTO;
import spring6api.services.BookService;

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

        return ResponseEntity.ok(bookService.findBookById(id).orElseThrow(NotFoundException::new));
    }

    @GetMapping(value = BOOKS_PATH)
    public Page<BookDTO> findAllBooks(
            @RequestParam(required = false, name = "category") String bookCategory,
            @RequestParam(required = false, name = "author") String author,
            @RequestParam(required = false, name = "page") Integer pageNumber,
            @RequestParam(required = false, name = "size") Integer pageSize) {
        return bookService.listBooks(bookCategory, author, pageNumber, pageSize);
    }

    @PutMapping(value = BOOK_PATH_ID)
    public ResponseEntity<Void> updateBookById(@PathVariable Integer id, @RequestBody @Validated BookDTO book) {
        if(id == null || id <= 0) throw new NullPathVarException();
        if(!bookService.updateBookById(id, book)) throw new NotFoundException();
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(BOOK_PATH_ID)
    public ResponseEntity<Void> patchBookById(@PathVariable Integer id, @RequestBody @Validated BookDTO book) {
        if(id == null || id <= 0) throw new NullPathVarException();
        if(!bookService.patchBookById(id, book)) throw new NotFoundException();
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping(value = BOOK_PATH_ID)
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
        if(id == null || id <= 0) throw new NullPathVarException();
        if(!bookService.deleteBookById(id)) throw new NotFoundException();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Path", "book/" + id);
        return ResponseEntity.ok().headers(headers).build();
    }
}
