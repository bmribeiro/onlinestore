package com.onlinestore.javarest.images;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.onlinestore.javarest.entities.CategoryImage;
import com.onlinestore.javarest.entities.Product;
import com.onlinestore.javarest.entities.ProductCategory;
import com.onlinestore.javarest.entities.ProductImage;
import com.onlinestore.javarest.entities.ProductItem;
import com.onlinestore.javarest.entities.ProductItemImage;

@SuppressWarnings("removal")
@Component
public class LocalImageFileService {

	// Category Hierarchy
	private Map<ProductCategory, ProductCategory> categoryHierarchy(ProductCategory category) {

		Map<ProductCategory, ProductCategory> categoryHierarchy = new HashMap<>();
		ProductCategory currentCategory = category;

		while (currentCategory != null) {
			ProductCategory parentCategory = currentCategory.getParentProductCategory();
			categoryHierarchy.put(currentCategory, parentCategory);

			// Debug Purpose
			if (parentCategory != null) {
				System.out.println("CAT " + currentCategory.getProductCategoryId().toString());
				System.out.println("PARENT " + parentCategory.getProductCategoryId().toString());
			} else {
				System.out.println("CAT " + currentCategory.getProductCategoryId().toString());
				System.out.println("PARENT NULL");
			}

			currentCategory = parentCategory;
		}
		return categoryHierarchy;
	}

	// Map Parent to Children
	private Map<ProductCategory, List<ProductCategory>> parentToChildren(
			Map<ProductCategory, ProductCategory> categoryHierarchy) {

		Map<ProductCategory, List<ProductCategory>> parentToChildrenMap = new HashMap<>();
		for (Map.Entry<ProductCategory, ProductCategory> entry : categoryHierarchy.entrySet()) {
			ProductCategory child = entry.getKey();
			ProductCategory parent = entry.getValue();
			parentToChildrenMap.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
		}
		return parentToChildrenMap;
	}

	// Root Category
	private ProductCategory rootCategory(Map<ProductCategory, ProductCategory> categoryHierarchy) {

		ProductCategory root = null;
		for (ProductCategory category : categoryHierarchy.keySet()) {
			if (categoryHierarchy.get(category) == null) {
				root = category;
				break;
			}
		}
		return root;
	}

	// Build Category Path
	private String imagePath(ProductCategory root, Map<ProductCategory, List<ProductCategory>> parentToChildrenMap,
			String productId, String itemId, String filename, boolean isToRead) {

		List<String> paths = new ArrayList<>();
		buildPaths(root, parentToChildrenMap, "", paths);

		// Path Folder
		String projectPath = System.getProperty("user.dir");
		StringBuilder pathBuilder = new StringBuilder();
		pathBuilder.append("images");

		for (String path : paths) {
			pathBuilder.append(path);
		}

		if (productId != null && itemId != null) {
			pathBuilder.append("/productImages/" + productId + "/itemImages/" + itemId);
		} else if (productId != null) {
			pathBuilder.append("/productImages/" + productId);
		}

		String imagePath = "";

		if (isToRead) {
			imagePath = Paths.get(projectPath, pathBuilder.toString(), filename).toString();
		} else {
			imagePath = Paths.get(projectPath, pathBuilder.toString()).toString();
		}
		return imagePath;
	}

	// Build Paths
	private static void buildPaths(ProductCategory parent,
			Map<ProductCategory, List<ProductCategory>> parentToChildrenMap, String path, List<String> paths) {
		if (parent != null) {
			if (!path.isEmpty()) {
				path += "/childCategory/" + parent.getProductCategoryId();
			} else {
				path += "/" + parent.getProductCategoryId();
			}
		}

		List<ProductCategory> children = parentToChildrenMap.get(parent);
		if (children == null || children.isEmpty()) {
			paths.add(path);
		} else {
			for (ProductCategory child : children) {
				buildPaths(child, parentToChildrenMap, path, paths);
			}
		}
	}

	/**
	 * GET ITEM IMAGES
	 * 
	 * @param productItem
	 * @throws IOException
	 */
	public void getItemImages(ProductItem productItem) throws IOException {

		System.out.println("ProductItemImages");

		for (ProductItemImage el : productItem.getProductItemImages()) {

			// Category Hierarchy
			Map<ProductCategory, ProductCategory> categoryHierarchy = categoryHierarchy(
					productItem.getProduct().getProductCategory());

			// Map Parent to Children
			Map<ProductCategory, List<ProductCategory>> parentToChildrenMap = parentToChildren(categoryHierarchy);

			// Root Category
			ProductCategory root = rootCategory(categoryHierarchy);

			// Product & ProductItem Filename
			String productId = el.getProductItem().getProduct().getProductId().toString();
			String itemId = el.getProductItem().getProductItemId().toString();
			String imageFilemane = el.getImageFilename();

			// Path
			String imagePath = imagePath(root, parentToChildrenMap, productId, itemId, imageFilemane, true);
			Path path = Paths.get(imagePath);

			if (Files.exists(path)) {
				byte[] imageBytes = Files.readAllBytes(path);
				String imgEncodedString = Base64.getEncoder().encodeToString(imageBytes);
				el.setImageBase64(imgEncodedString);
			}
		}
	}

	/**
	 * UPLOAD ITEM IMAGES
	 * 
	 * @param itemImage - ProductItemImage Object
	 */
	public void uploadItemImages(ProductItemImage itemImage) {

		// Current Category
		ProductCategory currentCategory = itemImage.getProductItem().getProduct().getProductCategory();

		// Category Hierarchy
		Map<ProductCategory, ProductCategory> categoryHierarchy = categoryHierarchy(currentCategory);

		// Map Parent to Children
		Map<ProductCategory, List<ProductCategory>> parentToChildrenMap = parentToChildren(categoryHierarchy);

		// Root Category
		ProductCategory root = rootCategory(categoryHierarchy);

		// Product
		String productId = itemImage.getProductItem().getProduct().getProductId().toString();
		String itemId = itemImage.getProductItem().getProductItemId().toString();

		// Path
		String imagePath = imagePath(root, parentToChildrenMap, productId, itemId, "", false);
		Path path = Paths.get(imagePath);

		// File Base64
		String base64String = null;
		if (itemImage.getImageBase64().startsWith("data:image")) {
			base64String = itemImage.getImageBase64().substring(itemImage.getImageBase64().indexOf(",") + 1);
		}

		byte[] imageBytes = Base64Utils.decodeFromString(base64String);

		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				System.out.println("Erro ao criar pasta");
			}
		}

		// Determine file path
		String fileName = itemImage.getImageFilename();
		Path writePath = path.resolve(fileName);

		// Write the file to disk
		try {
			Files.write(writePath, imageBytes);
		} catch (IOException e) {
			System.out.println("Erro ao escrever ficheiro");
		}

	}

	/**
	 * GET PRODUCT IMAGES
	 * 
	 * @param product - Product Object
	 * @throws IOException
	 */
	public void getProductImages(Product product) throws IOException {

		for (ProductImage el : product.getProductImages()) {

			// Current Category
			ProductCategory currentCategory = product.getProductCategory();

			// Category Hierarchy
			Map<ProductCategory, ProductCategory> categoryHierarchy = categoryHierarchy(currentCategory);

			// Map Parent to Children
			Map<ProductCategory, List<ProductCategory>> parentToChildrenMap = parentToChildren(categoryHierarchy);

			// Root Category
			ProductCategory root = rootCategory(categoryHierarchy);

			// Product & ProductImage Filename
			String productId = el.getProduct().getProductId().toString();
			String imageFilemane = el.getImageFilename();

			// Path
			String imagePath = imagePath(root, parentToChildrenMap, productId, null, imageFilemane, true);
			Path path = Paths.get(imagePath);

			if (Files.exists(path)) {
				byte[] imageBytes = Files.readAllBytes(path);
				String imgEncodedString = Base64.getEncoder().encodeToString(imageBytes);
				el.setImageBase64(imgEncodedString);
			}
		}
	}

	/**
	 * UPLOAD PRODUCT IMAGES
	 * 
	 * @param productImage - ProductImage Object
	 */
	public void uploadProductImages(ProductImage productImage) {

		// Current Category
		ProductCategory currentCategory = productImage.getProduct().getProductCategory();

		// Category Hierarchy
		Map<ProductCategory, ProductCategory> categoryHierarchy = categoryHierarchy(currentCategory);

		// Map Parent to Children
		Map<ProductCategory, List<ProductCategory>> parentToChildrenMap = parentToChildren(categoryHierarchy);

		// Root Category
		ProductCategory root = rootCategory(categoryHierarchy);

		// Product
		String productId = productImage.getProduct().getProductId().toString();

		// Path
		String imagePath = imagePath(root, parentToChildrenMap, productId, null, "", false);
		Path path = Paths.get(imagePath);

		// File Base64
		String base64String = null;
		if (productImage.getImageBase64().startsWith("data:image")) {
			base64String = productImage.getImageBase64().substring(productImage.getImageBase64().indexOf(",") + 1);
		}

		byte[] imageBytes = Base64Utils.decodeFromString(base64String);

		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				System.out.println("Erro ao criar pasta");
			}
		}

		// Determine file path
		String fileName = productImage.getImageFilename();
		Path writePath = path.resolve(fileName);

		// Write the file to disk
		try {
			Files.write(writePath, imageBytes);
		} catch (IOException e) {
			System.out.println("Erro ao escrever ficheiro");
		}
	}

	/**
	 * GET CATEGORY IMAGES
	 * 
	 * @param productCategory - ProductCategory Image
	 * @throws IOException
	 */
	public void getCaterogyImages(ProductCategory productCategory) throws IOException {
		for (CategoryImage elImg : productCategory.getCategoryImages()) {

			// Current Category
			ProductCategory currentCategory = productCategory;

			// Category Hierarchy
			Map<ProductCategory, ProductCategory> categoryHierarchy = categoryHierarchy(currentCategory);

			// Map Parent to Children
			Map<ProductCategory, List<ProductCategory>> parentToChildrenMap = parentToChildren(categoryHierarchy);

			// Root Category
			ProductCategory root = rootCategory(categoryHierarchy);

			// Filename
			String imageFilemane = elImg.getImageFilename();

			System.out.println(imageFilemane);

			// Path
			String imagePath = imagePath(root, parentToChildrenMap, null, null, imageFilemane, true);
			Path path = Paths.get(imagePath);

			if (Files.exists(path)) {
				byte[] imageBytes = Files.readAllBytes(path);
				String imgEncodedString = Base64.getEncoder().encodeToString(imageBytes);
				elImg.setImageBase64(imgEncodedString);
			}
		}
	}

	/**
	 * UPLOAD CATEGORY IMAGES
	 * 
	 * @param categoryImage - CategoryImage Object
	 */
	public void uploadCategoryImages(CategoryImage categoryImage) {

		if (categoryImage.getImageBase64() != null) {

			// Current Category
			ProductCategory currentCategory = categoryImage.getProductCategory();

			// Category Hierarchy
			Map<ProductCategory, ProductCategory> categoryHierarchy = categoryHierarchy(currentCategory);

			// Map Parent to Children
			Map<ProductCategory, List<ProductCategory>> parentToChildrenMap = parentToChildren(categoryHierarchy);

			// Root Category
			ProductCategory root = rootCategory(categoryHierarchy);

			// Path
			String imagePath = imagePath(root, parentToChildrenMap, null, null, "", false);
			Path path = Paths.get(imagePath);

			// File Base64
			String base64String = null;
			if (categoryImage.getImageBase64().startsWith("data:image")) {
				base64String = categoryImage.getImageBase64()
						.substring(categoryImage.getImageBase64().indexOf(",") + 1);
			}

			byte[] imageBytes = Base64Utils.decodeFromString(base64String);

			if (!Files.exists(path)) {
				try {
					Files.createDirectories(path);
				} catch (IOException e) {
					System.out.println("Erro ao criar pasta");
				}
			}

			// Determine file path
			String fileName = categoryImage.getImageFilename();
			Path writePath = path.resolve(fileName);

			// Write the file to disk
			try {
				Files.write(writePath, imageBytes);
			} catch (IOException e) {
				System.out.println("Erro ao escrever ficheiro");
			}
		}
	}
}
