package com.fundify.fundify.user.model;

import com.fundify.fundify.common.enums.Category;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document("users")
public record User (
    @Id
    String id,
    @NotEmpty
    @Indexed(unique = true)
    String wallet,
    @NotEmpty
    String name,
    @NotEmpty
    String country,
    @NotEmpty
    String role,
    String phone,
    @NotEmpty
    String address,
    @NotEmpty
    List<String> skills,
    List<Experience> experiences,
    @NotEmpty
    String linkedin,
    String x,
    String github,
    List<Category> interests,
    @CreatedDate
    Instant createdAt,
    @LastModifiedDate
    Instant updatedAt
) {}
