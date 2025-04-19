package com.example.RestApiDemo;

import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;

public class User extends RepresentationModel<User> {

    @NotBlank(message = "Name must not be blank")
    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

