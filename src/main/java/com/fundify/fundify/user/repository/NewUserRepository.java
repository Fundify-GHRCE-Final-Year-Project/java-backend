package com.fundify.fundify.user.repository;

import com.fundify.fundify.user.model.User;
import org.springframework.data.repository.ListCrudRepository;

public interface NewUserRepository extends ListCrudRepository<User, String> {
}
