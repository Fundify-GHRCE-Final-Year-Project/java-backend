package com.fundify.fundify.user.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public record User(
        @Id
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
        String linkedin,
        String x,
        String github,
        @Version
        int version
) {
}
