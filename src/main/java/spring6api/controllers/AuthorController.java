package spring6api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring6api.models.AuthorDTO;
import spring6api.services.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final static String AUTHOR_PATH = "authors";
    private final AuthorService authorService;

    @PostMapping(value = AUTHOR_PATH)
    public ResponseEntity<AuthorDTO> save(@Validated @RequestBody AuthorDTO dto) {
        return new ResponseEntity<>(authorService.saveNewAuthor(dto), HttpStatus.CREATED);
    }



}
