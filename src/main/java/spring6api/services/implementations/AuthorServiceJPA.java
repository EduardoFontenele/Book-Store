package spring6api.services.implementations;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring6api.models.AuthorDTO;
import spring6api.services.AuthorService;

@Service
public class AuthorServiceJPA implements AuthorService {
    @Override
    public AuthorDTO saveNewAuthor(AuthorDTO author) {
        return null;
    }
}
