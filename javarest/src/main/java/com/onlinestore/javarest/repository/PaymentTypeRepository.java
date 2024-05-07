package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.PaymentType;

@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType, Integer> {
}