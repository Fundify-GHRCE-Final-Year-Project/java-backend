package com.fundify.fundify.project.model;

import com.fundify.fundify.common.enums.Category;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.List;

@Document("projects")
public record Project (
        @Id
        String id,
        @NotEmpty
        String title,
        @NotEmpty
        String description,
        @NotEmpty
        List<String> members,
        @NotNull
        Category category,
        @NotEmpty
        @Indexed
        String owner,
        @PositiveOrZero
        @Indexed
        int index,
        @PositiveOrZero
        double goal,
        @PositiveOrZero
        double milestones,
        @PositiveOrZero
        double funded,
        @PositiveOrZero
        double released,
        @Positive
        int timestamp,
        @CreatedDate
        Instant createdAt,
        @LastModifiedDate
        Instant updatedAt
) {}