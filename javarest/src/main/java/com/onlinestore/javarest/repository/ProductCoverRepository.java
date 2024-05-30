package com.onlinestore.javarest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductImage;

@Repository
public interface ProductCoverRepository extends CrudRepository<ProductImage, Integer> {

	List<ProductImage> findByProductProductId(Integer productId);

}