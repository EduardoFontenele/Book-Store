package spring6api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring6api.entities.Book;
import spring6api.models.BookDTO;
import spring6api.models.BookFullDTO;

@Mapper
public interface BookMapper {
    @Mapping(source = "mainCategory", target = "category")
    @Mapping(target = "author", ignore = true)
    BookDTO entityToDto(Book entity);
    @Mapping(source = "category", target = "mainCategory")
    @Mapping(target = "author", ignore = true)
    Book dtoToEntity(BookDTO dto);
}
