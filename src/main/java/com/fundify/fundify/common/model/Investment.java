package com.fundify.fundify.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;

@Document("investments")
public record Investment (
    @Id String id,
    @Indexed String funder,
    @Indexed int investmentIndex,
    @Indexed String projectOwner,
    @Indexed int projectIndex,
    double amount,
    int timestamp,
    @CreatedDate Instant createdAt,
    @LastModifiedDate Instant updatedAt
) {}

