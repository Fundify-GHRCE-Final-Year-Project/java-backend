package com.fundify.fundify.user.controller;

import com.fundify.fundify.user.exception.UserNotFoundException;
import com.fundify.fundify.user.model.User;
import com.fundify.fundify.user.repository.NewUserRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final NewUserRepository userRepository;

    public UserController(NewUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    List<User> get() {
        return userRepository.findAll();
    }

    @GetMapping("/{wallet}")
    Optional<User> get(
            @PathVariable String wallet
    ) {
        Optional<User> existingUser = userRepository.findById(wallet);
        if (existingUser.isEmpty()) {
            throw new UserNotFoundException();
        }
        return existingUser;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    void create(
            @Valid @RequestBody User user
    ) {
        userRepository.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/")
    void update(
            @Valid @RequestBody User user
    ) {
        userRepository.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{wallet}")
    void delete(
            @PathVariable String wallet
    ) {
        userRepository.deleteById(wallet);
    }
}

