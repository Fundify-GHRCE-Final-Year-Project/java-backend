package com.fundify.fundify.investment.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;

@Document("investments")
public record Investment (
    @Id
    String id,
    @NotEmpty
    @Indexed
    String funder,
    @PositiveOrZero
    @Indexed
    int investmentIndex,
    @NotEmpty
    @Indexed
    String projectOwner,
    @PositiveOrZero
    @Indexed
    int projectIndex,
    @Positive
    double amount,
    @Positive
    int timestamp,
    @CreatedDate
    Instant createdAt,
    @LastModifiedDate
    Instant updatedAt
) {}

