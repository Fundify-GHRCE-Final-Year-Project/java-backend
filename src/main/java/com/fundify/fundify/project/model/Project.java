package com.fundify.fundify.project.model;

import com.fundify.fundify.common.enums.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.List;

@Document("projects")
public record Project (
        @Id String id,
        String title,
        String description,
        List<String> members,
        Category category,
        @Indexed String owner,
        @Indexed int index,
        double goal,
        double milestones,
        double funded,
        double released,
        int timestamp,
        @CreatedDate Instant createdAt,
        @LastModifiedDate Instant updatedAt
) {}