package com.fundify.fundify.user.repository;

import com.fundify.fundify.common.enums.Category;
import com.fundify.fundify.user.model.Experience;
import com.fundify.fundify.user.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

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
        users.add(new User(
                "1",
                "0x1",                   // wallet
                "Arav",
                "India",
                "Software Engineer",
                "+91-98765-43210",
                "Nagpur",
                List.of("Java", "Blockchain", "TeX"),
                List.of(
                        new Experience("Software Engineer", "Innotech", "2 years"),
                        new Experience("Blockchain Dev", "ChainLabs", "1 year")
                ),
                "https://www.linkedin.com/in/arav",
                "xArav",
                "https://github.com/arav",
                List.of(Category.Technology, Category.Education),
                Instant.now(),
                Instant.now()
        ));

        users.add(new User(
                "2",
                "0x2",
                "Kartik",
                "India",
                "Software Engineer",
                "+91-98765-43210",
                "Flat 12A, Delhi",
                List.of("Python", "DeFi", "Data Science"),
                List.of(
                        new Experience("Data Analyst", "DataCorp", "3 years"),
                        new Experience("DeFi Researcher", "BlockFunder", "2 years")
                ),
                "https://www.linkedin.com/in/kartik",
                "xKartik",
                "https://github.com/kartik",
                List.of(Category.Finance, Category.Environment),
                Instant.now(),
                Instant.now()
        ));

        users.add(new User(
                "3",
                "0x3",
                "Pavan",
                "India",
                "Software Engineer",
                "+91-98765-43210",
                "Nagpur",
                List.of("UX Design", "Front End", "Web3"),
                List.of(
                        new Experience("UI/UX Designer", "DesignHive", "2 years"),
                        new Experience("Frontend Developer", "Web3Start", "1 year")
                ),
                "https://www.linkedin.com/in/pavan",
                "xPavan",
                "https://github.com/pavan",
                List.of(Category.Education, Category.Technology),
                Instant.now(),
                Instant.now()
        ));
    }
}
