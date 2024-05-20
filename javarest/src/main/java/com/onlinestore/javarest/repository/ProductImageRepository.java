package com.onlinestore.javarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlinestore.javarest.entities.ProductImage;

public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {

	@Query("SELECT pi FROM ProductImage pi WHERE pi.productItem.productItemId = :productItemId")
	List<ProductImage> getProductImagesByProductItem(@Param("productItemId") Integer productItemId);
}
