package com.fundify.fundify.project.model;

import com.fundify.fundify.common.enums.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document("projects")
public class Project {
    @Id
    private String id;
    private String title = "";
    private String description = "";
    private List<String> members = new ArrayList<>();
    private Category category;
    @Indexed
    private String owner;
    @Indexed
    private double index;
    private double goal;
    private double milestones;
    private double funded;
    private double released;
    private int timestamp;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    // getters and setters
}

