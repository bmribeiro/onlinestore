package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.UserPaymentPhone;

@Repository
public interface UserPaymentPhoneRepository extends CrudRepository<UserPaymentPhone, Integer> {
}