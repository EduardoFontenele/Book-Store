package spring6api.mappers;

import spring6api.entities.Book;
import spring6api.models.BookDTO;

import java.util.Collection;

public class BookFactory {

    public static BookDTO entityToDTO(Book book) {
        return new BookDTO()
                .builder()
                .name(book.getName())
                .author(AuthorFactory.entityToDTO(book.getAuthor()))
                .build();
    }

    public static Collection<BookDTO> toBookDTOList(Collection<Book> books) {
        return books.stream().map(BookFactory::entityToDTO).toList();
    }

}
