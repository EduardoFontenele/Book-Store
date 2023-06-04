package spring6api.mappers;

import org.mapstruct.Mapper;
import spring6api.entities.Author;
import spring6api.models.AuthorDTO;
import spring6api.models.AuthorFullDTO;

@Mapper
public interface AuthorMapper {

    public AuthorFullDTO entityToFullDto(Author entity);
    public Author fullDtoToEntity(AuthorFullDTO dto);
    public AuthorDTO entityToDto(Author entity);
    public Author dtoToEntity(AuthorDTO dto);

}
