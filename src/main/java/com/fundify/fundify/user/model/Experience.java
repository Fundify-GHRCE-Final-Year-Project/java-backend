package com.fundify.fundify.user.model;

import jakarta.validation.constraints.NotEmpty;

public record Experience (
        @NotEmpty
        String role,
        @NotEmpty
        String company,
        @NotEmpty
        String duration
) {}


