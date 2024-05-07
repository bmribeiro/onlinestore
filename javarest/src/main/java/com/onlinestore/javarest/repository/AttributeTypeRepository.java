package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.AttributeType;

@Repository
public interface AttributeTypeRepository extends CrudRepository<AttributeType, Integer> {
}