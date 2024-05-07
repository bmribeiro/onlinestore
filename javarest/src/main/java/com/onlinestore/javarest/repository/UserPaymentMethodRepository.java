package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.UserPaymentMethod;

@Repository
public interface UserPaymentMethodRepository extends CrudRepository<UserPaymentMethod, Integer> {
}