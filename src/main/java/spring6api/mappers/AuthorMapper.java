package spring6api.mappers;

import org.mapstruct.Mapper;
import spring6api.entities.Author;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;

@Mapper
public interface AuthorMapper {
    AuthorDTO entityToDto(Author entity);
    Author dtoToEntity(AuthorDTO dto);
}
