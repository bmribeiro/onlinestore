package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.Colour;

@Repository
public interface ColourRepository extends CrudRepository<Colour, Integer> {
}