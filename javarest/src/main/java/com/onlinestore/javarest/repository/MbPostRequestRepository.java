package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.MbPostRequest;

@Repository
public interface MbPostRequestRepository extends CrudRepository<MbPostRequest, Integer> {
}