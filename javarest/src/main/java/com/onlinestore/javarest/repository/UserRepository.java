package com.onlinestore.javarest.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByUserEmail(String email);

}