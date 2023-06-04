package spring6api.factories;

import spring6api.entities.Author;
import spring6api.entities.Book;
import spring6api.models.AuthorFullDTO;
import spring6api.models.BookDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class AuthorFactory {
    public static AuthorFullDTO entityToFullDto(Author entity) {
        Collection<Book> bookDTOList = entity.getBooks().stream().toList();

        return new AuthorFullDTO().builder()
                .id(entity.getId())
                .name(entity.getName())
                .books(BookFactory.generateBookDtoList(bookDTOList).stream().collect(Collectors.toUnmodifiableSet()))
                .build();
    }
}
