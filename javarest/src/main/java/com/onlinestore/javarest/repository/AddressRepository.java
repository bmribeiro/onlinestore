package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}