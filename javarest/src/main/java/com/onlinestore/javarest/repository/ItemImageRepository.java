package com.onlinestore.javarest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductItemImage;

@Repository
public interface ItemImageRepository extends CrudRepository<ProductItemImage, Integer> {


}