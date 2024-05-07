package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.MbPostResponse;

@Repository
public interface MbPostResponseRepository extends CrudRepository<MbPostResponse, Integer> {
}