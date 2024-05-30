package com.onlinestore.javarest.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlinestore.javarest.entities.Colour;
import com.onlinestore.javarest.entities.ProductItem;
import com.onlinestore.javarest.entities.ProductItemImage;
import com.onlinestore.javarest.images.LocalImageFileService;
import com.onlinestore.javarest.repository.ItemImageRepository;
import com.onlinestore.javarest.repository.ProductItemRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductItemService {

	@Autowired
	private ProductItemRepository productItemRepository;
	
	@Autowired
	private ItemImageRepository itemImageRepository;
	
	@Autowired
	private LocalImageFileService localImageFileService;

	public List<ProductItem> getAllProductItems() {
		return (List<ProductItem>) productItemRepository.findAll();
	}

	public List<ProductItem> getProductItemsByProduct(int productId) throws IOException {
		List<ProductItem> productItems = productItemRepository.getProductItemsByProduct(Integer.valueOf(productId));
		
		System.out.println("Teste");
		for(ProductItem el : productItems) {
			localImageFileService.getItemImages(el);
		}
		return productItems;
	}

	public List<Colour> findColoursByProducItemtId(int productId) {
		return productItemRepository.findColoursByProducItemtId(productId);
	}

	public Optional<ProductItem> getProductItemById(Long productItemId) throws IOException {

		Optional<ProductItem> productItem = productItemRepository.findById(productItemId.intValue());
		localImageFileService.getItemImages(productItem.get());
		return productItem;
	}

	public ProductItem addProductItem(ProductItem productItemEntity) {

		ProductItem productItem = productItemRepository.save(productItemEntity);

		// Save each category image
		for (ProductItemImage image : productItemEntity.getProductItemImages()) {
			image.setProductItem(productItem);
			itemImageRepository.save(image);

			// Save Image Local
			localImageFileService.uploadItemImages(image);
		}

		return productItem;
	}

	public ProductItem updateProductItem(ProductItem productItemEntity, MultipartFile file) {

		if (!file.equals(null)) {
			uploadFile(productItemEntity.getProduct().getProductCategory().getProductCategoryId().toString(),
					productItemEntity.getProduct().getProductId().toString(),
					productItemEntity.getProductItemId().toString(), file);
		}

		return productItemRepository.save(productItemEntity);
	}

	private void uploadFile(String string, String string2, String string3, MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void deleteProductItemById(Long attributeOptionId) {
		productItemRepository.deleteById(attributeOptionId.intValue());
	}

}