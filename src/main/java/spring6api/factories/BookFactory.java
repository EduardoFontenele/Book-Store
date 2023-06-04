package spring6api.factories;

import spring6api.entities.Book;
import spring6api.models.BookDTO;

import java.util.Collection;

public class BookFactory {
    public static BookDTO entityToBookDto(Book entity) {
        return new BookDTO().builder()
                .id(entity.getId())
                .name(entity.getName())
                .author_id(entity.getAuthor().getId())
                .build();
    }

    public static Collection<BookDTO> generateBookDtoList(Collection<Book> books) {
        return books.stream().map(BookFactory::entityToBookDto).toList();
    }
}
