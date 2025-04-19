package com.example.RestApiDemo;

import jakarta.validation.Valid;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @GetMapping("/")
    public String printHello() {
        return "Hello Team! Abhishek Sharma, Shlok Goswami and Shashwat Tripathi";
    }

    @PostMapping("/greet")
    public ResponseEntity<User> greetUser(@Valid @RequestBody User user) {

        // Adding a self-link to the User object
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MyController.class)
                .greetUser(user)).withSelfRel();
        user.add(selfLink);

        return ResponseEntity.ok(user);
    }
}

