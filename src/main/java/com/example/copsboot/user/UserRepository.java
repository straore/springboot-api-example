package com.example.copsboot.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> , UserRepositoryCustom  {

    Optional<User> findByEmailIgnoreCase(String email);
}
