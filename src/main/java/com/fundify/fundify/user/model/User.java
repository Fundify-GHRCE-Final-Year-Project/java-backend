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
public record User (
    @Id String id,
    @Indexed(unique = true) String wallet,
    String name,
    String country,
    String role,
    String phone,
    String address,
    List<String> skills,
    List<Experience> experiences,
    String linkedin,
    String x,
    String github,
    List<Category> interests,
    @CreatedDate Instant createdAt,
    @LastModifiedDate Instant updatedAt
) {}
