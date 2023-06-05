package spring6api.mappers;

import org.mapstruct.Mapper;
import spring6api.entities.Book;
import spring6api.models.BookDTO;
import spring6api.models.BookFullDTO;

@Mapper
public interface BookMapper {
    public BookFullDTO entityToFullDto(Book entity);
    public Book fullDtoToEntity(BookFullDTO dto);
    public BookDTO entityToDto(Book entity);
    public Book dtoToEntity(BookDTO dto);
}
