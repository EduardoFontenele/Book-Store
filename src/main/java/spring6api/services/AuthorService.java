package spring6api.services;

import org.springframework.http.ResponseEntity;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;

import java.util.List;

public interface AuthorService {
     AuthorDTO saveNewAuthor(AuthorDTO author);
     AuthorFullDTO getAuthorWithBooksById(Integer id);
     AuthorDTO getAuthorById(Integer id);

     List<AuthorDTO> getAuthors();
}
