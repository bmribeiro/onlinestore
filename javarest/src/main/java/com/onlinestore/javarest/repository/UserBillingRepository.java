package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.UserBilling;

@Repository
public interface UserBillingRepository extends CrudRepository<UserBilling, Integer> {
}