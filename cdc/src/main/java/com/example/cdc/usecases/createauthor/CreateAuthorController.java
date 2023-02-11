package com.example.cdc.usecases.createauthor;

import com.example.cdc.domain.Author;
import com.example.cdc.domain.AuthorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateAuthorController {

    private final AuthorRepository authorRepository;

    public CreateAuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/authors")
    @Transactional
    public HttpStatus CreateAuthor(@RequestBody @Valid CreateAuthorRequest request) {
        if(authorRepository.existsByEmail(request.email())) {
            return HttpStatus.CONFLICT;
        }
        Author author = request.toModel();
        authorRepository.save(author);
        return HttpStatus.CREATED;
    }
}
