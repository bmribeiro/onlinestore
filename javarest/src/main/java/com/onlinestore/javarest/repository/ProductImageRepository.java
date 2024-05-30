package com.onlinestore.javarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlinestore.javarest.entities.ProductItemImage;

public interface ProductImageRepository extends CrudRepository<ProductItemImage, Integer> {

	@Query("SELECT pi FROM ProductItemImage pi WHERE pi.productItem.productItemId = :productItemId")
	List<ProductItemImage> getProductImagesByProductItem(@Param("productItemId") Integer productItemId);
}
