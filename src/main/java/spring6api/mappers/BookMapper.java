package spring6api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring6api.entities.Book;
import spring6api.models.BookDTO;
import spring6api.models.BookFullDTO;

@Mapper
public interface BookMapper {
    public BookFullDTO entityToFullDto(Book entity);
    public Book fullDtoToEntity(BookFullDTO dto);
    @Mapping(source = "mainCategory", target = "category")
    public BookDTO entityToDto(Book entity);
    @Mapping(source = "category", target = "mainCategory")
    public Book dtoToEntity(BookDTO dto);
}
