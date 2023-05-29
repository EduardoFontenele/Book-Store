package spring6api.mappers;

import org.mapstruct.Mapper;
import spring6api.entities.Author;
import spring6api.models.AuthorDTO;

@Mapper
public interface AuthorMapper {

    public AuthorDTO entityToDto(Author entity);
    public Author DtoToEntity(AuthorDTO dto);

}
