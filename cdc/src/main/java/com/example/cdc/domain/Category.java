package com.example.cdc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Deprecated
    public Category() {
    }

    public Category(@NotBlank String name) {
        this.name = name;
    }
}
