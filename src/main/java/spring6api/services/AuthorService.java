package spring6api.services;

import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
     AuthorDTO saveNewAuthor(AuthorDTO author);
     Optional<AuthorFullDTO> getAuthorWithBooksById(Integer id);
     Optional<AuthorDTO> getAuthorById(Integer id);
     List<AuthorDTO> getAuthors();
     Boolean deleteAuthorById(Integer id);
     Boolean updateAuthorById(Integer id, AuthorDTO dto);
}
