package spring6api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring6api.models.CategoryDTO;
import spring6api.services.CategoryService;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final static String CATEGORY_PATH = "category";

    @PostMapping(value = CATEGORY_PATH)
    public CategoryDTO createNewCategory(@Validated @RequestBody CategoryDTO category) {
        return categoryService.createNewCategory(category);
    }
}
