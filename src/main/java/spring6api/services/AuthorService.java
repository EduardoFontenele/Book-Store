package spring6api.services;

import org.springframework.data.domain.Page;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;

import java.util.Optional;

public interface AuthorService {
     AuthorDTO saveNewAuthor(AuthorDTO author);
     Optional<AuthorFullDTO> getAuthorWithBooksById(Integer id);
     Optional<AuthorDTO> getAuthorById(Integer id);
     Page<AuthorDTO> getAuthors(Integer pageNumber, Integer pageSize);
     Boolean deleteAuthorById(Integer id);
     Boolean updateAuthorById(Integer id, AuthorDTO dto);
}
