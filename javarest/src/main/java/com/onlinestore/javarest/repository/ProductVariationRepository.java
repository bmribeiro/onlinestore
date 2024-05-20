package com.onlinestore.javarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductVariation;

@Repository
public interface ProductVariationRepository extends CrudRepository<ProductVariation, Integer> {
	
	@Query("SELECT pv FROM ProductVariation pv WHERE pv.productItem.productItemId = :productItemId")
	List<ProductVariation> getProductVariationsByProductItem(@Param("productItemId") Integer productItemId);
	
}