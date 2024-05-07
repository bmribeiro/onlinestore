package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {
}