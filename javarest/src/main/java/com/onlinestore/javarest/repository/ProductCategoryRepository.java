package com.onlinestore.javarest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinestore.javarest.entities.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	
    @Query("SELECT DISTINCT pc FROM ProductCategory pc LEFT JOIN FETCH pc.categoryImages WHERE pc.parentProductCategory IS NULL")
    List<ProductCategory> getProductCategoriesWithNullParent();
	
	@Query("SELECT pc FROM ProductCategory pc WHERE pc.parentProductCategory.id = :parentId")
    List<ProductCategory>  getProductCategoriesFromParent(Long parentId);
}