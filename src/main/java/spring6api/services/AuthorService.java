package spring6api.services;

import spring6api.models.AuthorDTO;

public interface AuthorService {
    public AuthorDTO saveNewAuthor(AuthorDTO author);
}
