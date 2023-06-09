package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring6api.entities.Author;
import spring6api.exceptions.NullPathVarException;
import spring6api.factories.AuthorFactory;
import spring6api.mappers.AuthorMapper;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;
import spring6api.repositories.AuthorRepository;
import spring6api.services.AuthorService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 5;

    @Override
    public AuthorDTO saveNewAuthor(AuthorDTO dto) {
        Author savedAuthor = authorMapper.dtoToEntity(dto);
        savedAuthor = authorRepository.save(savedAuthor);
        return authorMapper.entityToDto(savedAuthor);
    }

    @Override
    public Optional<AuthorFullDTO> getAuthorWithBooksById(Integer id) {
        if(id == null || id <= 0) throw new NullPathVarException("ID must not be null or negative");
        if(authorRepository.findById(id).isEmpty())
            throw new NoSuchElementException("Element with id " + id + " does not exist in the database");
        return Optional.of(AuthorFactory.entityToFullDto(authorRepository.findById(id).get()));

    }

    @Override
    public Optional<AuthorDTO> getAuthorById(Integer id) {
        if(id == null || id <= 0) throw new NullPathVarException("ID must not be null or negative");
        if(authorRepository.findById(id).isEmpty())
            throw new NoSuchElementException("Element with id " + id + " does not exist in the database");
        return Optional.of(authorMapper.entityToDto(authorRepository.findById(id).get()));
    }

    @Override
    public Page<AuthorDTO> getAuthors(Integer pageNumber, Integer pageSize) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
        Page<Author> authorList = authorRepository.findAll(pageRequest);
        return authorList.map(authorMapper::entityToDto);
    }

    private PageRequest buildPageRequest(Integer pageNumber, Integer pageSize) {
        int queryPageNumber;
        int queryPageSize;

        if((pageNumber != null) && (pageNumber > 0)) {
            queryPageNumber = pageNumber - 1;
        } else {
            queryPageNumber = DEFAULT_PAGE;
        }

        if(pageSize == null){
            queryPageSize = DEFAULT_PAGE_SIZE;
        }
        else  {
            if(pageSize > 20) {
                queryPageSize = 20;
            } else {
                queryPageSize = pageSize;
            }
        }

        return PageRequest.of(queryPageNumber, queryPageSize);
    }

    @Override
    public Boolean deleteAuthorById(Integer id) {
        if(authorRepository.existsById(id)) {
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateAuthorById(Integer id, AuthorDTO dto) {
        if(authorRepository.existsById(id)) {
            authorRepository.updateName(id, dto.getName());
            return true;
        }
        return false;
    }

}
