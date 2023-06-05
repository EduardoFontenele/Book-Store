package spring6api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring6api.exceptions.NotFoundException;
import spring6api.exceptions.NullPathVarException;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;
import spring6api.services.AuthorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final static String AUTHOR_ONLY_PATH = "author";
    private final static String AUTHOR_ONLY_PATH_ID = "author/{id}";
    private final static String AUTHORS_PATH = "authors";
    private final static String AUTHOR_COMPLETE_ID = "author_with_books/{id}";
    @PostMapping(value = AUTHOR_ONLY_PATH)
    public ResponseEntity<AuthorDTO> saveNewAuthor(@Validated @RequestBody AuthorDTO dto) {
        return new ResponseEntity<>(authorService.saveNewAuthor(dto), HttpStatus.CREATED);
    }
    @GetMapping(value = AUTHORS_PATH)
    public ResponseEntity<List<AuthorDTO>> findAllAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }
    @GetMapping(value = AUTHOR_COMPLETE_ID)
    public ResponseEntity<AuthorFullDTO> findAuthorWithBooksById(@PathVariable("id") Integer id) {
        if(id == null || id <= 0) throw new NullPathVarException();
        return ResponseEntity.ok().body(authorService.getAuthorWithBooksById(id).orElseThrow(NotFoundException::new));
    }
    @GetMapping(value = AUTHOR_ONLY_PATH_ID)
    public AuthorDTO findAuthorById(@PathVariable("id") Integer id) {
        if(id == null || id <= 0) throw new NullPathVarException();
        return authorService.getAuthorById(id).orElseThrow(NotFoundException::new);
    }

    @DeleteMapping(value = AUTHOR_ONLY_PATH_ID)
    public ResponseEntity<Void> deleteAuthorById(@PathVariable("id") Integer id) {
        if(!authorService.deleteAuthorById(id)) throw new NotFoundException();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Path", "author/" + id);
        return ResponseEntity.ok().headers(headers).build();
    }

    @PutMapping(value = AUTHOR_ONLY_PATH_ID)
    public ResponseEntity<Void> updateAuthorById(@PathVariable("id") Integer id, @RequestBody AuthorDTO dto) {
        if(id == null || id <= 0) throw new NullPathVarException();

        if(!authorService.updateAuthorById(id, dto)) throw new NotFoundException();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Path", "author/" + id);
        return ResponseEntity.ok().headers(headers).build();
    }
}
