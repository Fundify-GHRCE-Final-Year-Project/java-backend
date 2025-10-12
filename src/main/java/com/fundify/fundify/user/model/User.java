package com.fundify.fundify.user.model;

import com.fundify.fundify.common.enums.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document("users")
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String wallet;
    private String name;
    private String country;
    private String role;
    private String phone;
    private String address;
    private List<String> skills = new ArrayList<>();
    private List<Experience> experiences = new ArrayList<>();
    private String linkedin;
    private String x;
    private String github;
    private List<Category> interests = new ArrayList<>();
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    // getters and setters
}
