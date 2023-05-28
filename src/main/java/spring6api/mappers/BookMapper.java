package spring6api.mappers;

import org.mapstruct.Mapper;
import spring6api.entities.Book;
import spring6api.models.BookDTO;

@Mapper
public interface BookMapper {
    public BookDTO entityToDto(Book entity);
    public Book DtoToEntity(BookDTO dto);
}
