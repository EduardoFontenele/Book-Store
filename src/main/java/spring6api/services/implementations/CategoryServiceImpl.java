package spring6api.services.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring6api.entities.Category;
import spring6api.mappers.CategoryMapper;
import spring6api.models.CategoryDTO;
import spring6api.repositories.CategoryRepository;
import spring6api.services.CategoryService;
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDTO createNewCategory(CategoryDTO dto) {
        Category entity = categoryMapper.dtoToEntity(dto);
        categoryRepository.save(entity);
        return categoryMapper.entityToDto(entity);
    }
}
