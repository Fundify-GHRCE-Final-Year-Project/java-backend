package com.fundify.fundify.user.model;

import com.fundify.fundify.common.enums.Category;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record User (
    @NotEmpty
    String id,
    @NotEmpty
    String wallet,
    @NotEmpty
    String username,
    @NotEmpty
    String country,
    @NotEmpty
    String job,
    String phone,
    @NotEmpty
    String address,
    @NotEmpty
    List<String> skills,
    List<Experience> experiences,
    @NotEmpty
    String linkedin,
    String x,
    String github,
    List<Category> interests
) {}
