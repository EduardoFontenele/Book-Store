package spring6api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;
import spring6api.services.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    private final static String AUTHOR_ONLY_PATH = "author";
    private final static String AUTHOR_ONLY_PATH_ID = "author/{id}";
    private final static String AUTHORS_PATH = "authors";
    private final static String AUTHOR_COMPLETE_ID = "author_with_books/{id}";

    @PostMapping(value = AUTHOR_ONLY_PATH)
    public ResponseEntity<AuthorDTO> saveAuthor(@Validated @RequestBody AuthorDTO dto) {
        return new ResponseEntity<>(authorService.saveNewAuthor(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = AUTHOR_COMPLETE_ID)
    public ResponseEntity<AuthorFullDTO> getAuthorWithBooksById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(authorService.getAuthorWithBooksById(id));
    }

    @GetMapping(value = AUTHORS_PATH)
    public ResponseEntity<List<AuthorDTO>> findAllAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }

    @GetMapping(value = AUTHOR_ONLY_PATH_ID)
    public AuthorDTO getAuthorById(@PathVariable("id") Integer id) {
        return authorService.getAuthorById(id);
    }
}
