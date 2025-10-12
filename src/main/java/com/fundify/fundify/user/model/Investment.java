package com.fundify.fundify.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;

@Document("investments")
public class Investment {
    @Id
    private String id;
    @Indexed
    private String funder;
    @Indexed
    private int investmentIndex;
    @Indexed
    private String projectOwner;
    @Indexed
    private int projectIndex;
    private double amount;
    private int timestamp;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    // getters and setters
}

