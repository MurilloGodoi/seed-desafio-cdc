package com.example.cdc.usecases.createcategory;

import com.example.cdc.domain.Category;
import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequest(@NotBlank String name) {
    public Category toModel() {
        return new Category(name);
    }
}
