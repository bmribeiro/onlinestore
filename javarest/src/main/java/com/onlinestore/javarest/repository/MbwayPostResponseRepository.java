package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.MbwayPostResponse;

@Repository
public interface MbwayPostResponseRepository extends CrudRepository<MbwayPostResponse, Integer> {
}