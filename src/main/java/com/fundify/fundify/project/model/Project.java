package com.fundify.fundify.project.model;

import com.fundify.fundify.common.enums.Category;
import jakarta.validation.constraints.*;

import java.util.List;

public record Project (
        @NotEmpty
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
        String owner,
        @NotEmpty
        @PositiveOrZero
        int index,
        @NotEmpty
        @Positive
        double goal,
        @NotEmpty
        @Positive
        double milestones,
        @NotEmpty
        @PositiveOrZero
        double funded,
        @NotEmpty
        @PositiveOrZero
        double released,
        @NotEmpty
        @Positive
        int timestamp
) {}