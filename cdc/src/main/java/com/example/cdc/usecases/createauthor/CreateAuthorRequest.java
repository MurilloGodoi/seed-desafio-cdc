package com.example.cdc.usecases.createauthor;

import com.example.cdc.domain.Author;
import jakarta.validation.constraints.*;

public record CreateAuthorRequest(@NotBlank String name, @NotBlank @Email String email, @NotBlank @Size(max = 400) String description) {

    public Author toModel() {
        return new Author(name, email, description);
    }
}
