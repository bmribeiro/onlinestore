package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.SizeOption;

@Repository
public interface SizeOptionRepository extends CrudRepository<SizeOption, Integer> {
}