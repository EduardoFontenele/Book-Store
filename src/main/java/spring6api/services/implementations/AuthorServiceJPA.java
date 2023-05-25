package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring6api.mappers.AuthorFactory;
import spring6api.models.AuthorDTO;
import spring6api.repositories.AuthorRepository;
import spring6api.services.AuthorService;

@Service
@RequiredArgsConstructor
public class AuthorServiceJPA implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorFactory authorFactory;

    @Override
    public AuthorDTO saveNewAuthor(AuthorDTO author) {
        return null;
    }
}
