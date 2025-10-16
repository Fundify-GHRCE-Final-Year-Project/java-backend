package com.fundify.fundify.user.repository;

import com.fundify.fundify.user.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> get() {
        return users;
    }

    public Optional<User> get(String wallet) {
        return users.stream().filter(user -> user.wallet().equals(wallet)).findFirst();
    }

    public void create(User user) {
        users.add(user);
    }

    public void update(User user, String wallet) {
        Optional<User> existingInvestment = get(wallet);
        existingInvestment.ifPresent(value -> users.set(users.indexOf(value), user));
    }

    public void delete(String wallet) {
        users.removeIf(user -> user.wallet().equals(wallet));
    }

    @PostConstruct
    private void init() {

    }
}
