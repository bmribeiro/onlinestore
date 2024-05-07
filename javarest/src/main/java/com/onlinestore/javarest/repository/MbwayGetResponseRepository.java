package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.MbwayGetResponse;

@Repository
public interface MbwayGetResponseRepository extends CrudRepository<MbwayGetResponse, Integer> {
}