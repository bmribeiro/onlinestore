package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.AttributeOption;

@Repository
public interface AttributeOptionRepository extends CrudRepository<AttributeOption, Integer> {
}