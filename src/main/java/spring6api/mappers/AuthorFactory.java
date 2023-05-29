package spring6api.mappers;

import spring6api.entities.Author;
import spring6api.entities.Book;
import spring6api.models.AuthorDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorFactory {

    public static AuthorDTO entityToDTO(Author author) {
        List<Book> books = author.getBooks().stream().collect(Collectors.toList());

        return new AuthorDTO().builder()
                .name(author.getName())
                .books(BookFactory.toBookDTOList(books)
                        .stream()
                        .collect(Collectors.toUnmodifiableSet()))
                .build();
    }

}
