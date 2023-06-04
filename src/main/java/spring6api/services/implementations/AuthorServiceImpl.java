package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring6api.entities.Author;
import spring6api.factories.AuthorFactory;
import spring6api.mappers.AuthorMapper;
import spring6api.mappers.BookMapper;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;
import spring6api.repositories.AuthorRepository;
import spring6api.repositories.BookRepository;
import spring6api.services.AuthorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public AuthorDTO saveNewAuthor(AuthorDTO dto) {
        Author savedAuthor = authorMapper.dtoToEntity(dto);
        savedAuthor = authorRepository.save(savedAuthor);
        return authorMapper.entityToDto(savedAuthor);
    }

    @Override
    public AuthorFullDTO getAuthorWithBooksById(Integer id) {
        Author author = authorRepository.findById(id).get();
        return AuthorFactory.entityToFullDto(author);
    }

    @Override
    public AuthorDTO getAuthorById(Integer id) {
        Author author = authorRepository.findById(id).get();
        return authorMapper.entityToDto(author);
    }

    @Override
    public List<AuthorDTO> getAuthors() {
        List<Author> authorList = authorRepository.findAll();
        return authorList.stream()
                .map(authorMapper::entityToDto)
                .toList();
    }

}
