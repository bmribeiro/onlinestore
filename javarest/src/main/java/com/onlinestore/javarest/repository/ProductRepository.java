package com.onlinestore.javarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.productCategory.productCategoryId = :categoryId")
	List<Product> getProductByCategory(@Param("categoryId") Integer categoryId);
}
