package com.onlinestore.javarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.Colour;
import com.onlinestore.javarest.entities.ProductItem;

@Repository
public interface ProductItemRepository extends CrudRepository<ProductItem, Integer> {

	@Query("SELECT pi FROM ProductItem pi WHERE pi.product.productId = :productId")
	List<ProductItem> getProductItemsByProduct(@Param("productId") Integer productId);

    @Query("SELECT DISTINCT pi.colour FROM ProductItem pi WHERE pi.product.productId = :productId")
	List<Colour> findColoursByProducItemtId(int productId);
}