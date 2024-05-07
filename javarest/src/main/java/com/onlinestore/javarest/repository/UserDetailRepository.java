package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.UserDetail;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Integer> {
}
