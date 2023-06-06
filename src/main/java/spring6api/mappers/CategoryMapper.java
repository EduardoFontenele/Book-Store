package spring6api.mappers;

import org.mapstruct.Mapper;
import spring6api.entities.Category;
import spring6api.models.CategoryDTO;

@Mapper
public interface CategoryMapper {

    Category dtoToEntity(CategoryDTO dto);
    CategoryDTO entityToDto(Category entity);

}
