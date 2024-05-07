package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.MbwayPostRequest;

@Repository
public interface MbwayPostRequestRepository extends CrudRepository<MbwayPostRequest, Integer> {
}