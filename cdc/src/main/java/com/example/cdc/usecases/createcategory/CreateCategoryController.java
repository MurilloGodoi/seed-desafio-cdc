package com.example.cdc.usecases.createcategory;

import com.example.cdc.domain.Category;
import com.example.cdc.domain.CategoryRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateCategoryController {

    private final CategoryRepository categoryRepository;

    public CreateCategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/categories")
    @Transactional
    public HttpStatus createCategory(@RequestBody @Valid CreateCategoryRequest request) {
        if(categoryRepository.existsByName(request.name())) {
            return HttpStatus.CONFLICT;
        }
        Category category = request.toModel();
        categoryRepository.save(category);
        return HttpStatus.CREATED;
    }
}
