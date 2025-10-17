package com.fundify.fundify.investment.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record Investment (
    @NotEmpty
    String id,
    @NotEmpty
    String funder,
    @NotEmpty
    @PositiveOrZero
    int investmentIndex,
    @NotEmpty
    String projectOwner,
    @NotEmpty
    @PositiveOrZero
    int projectIndex,
    @NotEmpty
    @Positive
    double amount,
    @NotEmpty
    @Positive
    int timestamp
) {}

