package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;

@Service
public class ProductServiceImpl  {
	@Autowired
	private ProductRepository productrepo;

	public Product saveProduct(Product product) {
		return productrepo.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return productrepo.saveAll(products);
	}

	public List<Product> getProducts() {
		return productrepo.findAll();
	}

	public Product getProductById(int id) {
		
		Optional<Product> product = productrepo.findById(id);
		if (! product.isPresent())
		{
			throw new ProductNotFoundException();
		}
		return product.get();
		
	}

	public Product getProductByName(String name) {
		
		Optional<Product> product = productrepo.findByName(name);
		if (! product.isPresent())
		{
			throw new ProductNotFoundException();
		}
		return product.get();
		
	}

	public String deleteProduct(int id) {
		productrepo.deleteById(id);
		return "Product removed " + id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = null;
		Optional<Product> optionalProduct = productrepo.findById(product.getId());

		if (optionalProduct.isPresent()) {
			existingProduct = optionalProduct.get();
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setQuantity(product.getQuantity());
		}
		return existingProduct;

	}

}
