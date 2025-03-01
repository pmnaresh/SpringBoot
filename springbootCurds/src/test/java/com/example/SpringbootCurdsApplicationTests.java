package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringbootCurdsApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Test
	@Order(1)
	public void testcreate()
	{
		Product product = new Product();
		product.setId(2);
		product.setName("cool");
		product.setPrice(38.90);
		product.setQuantity(3);
		productRepository.save(product);
		assertNotNull(productRepository.findById(1).get());
	}
	@Test
	@Order(2)
	public void testReadAll()
	{
		List<Product>list =productRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void testSingleProduct()
	{
		Product p=productRepository.findById(1).get();
		assertEquals("cool",p.getName());
	}
	@Test
	@Order(4)
	public void testUpdate()
	{
		Product pr = productRepository.findById(1).get();
		pr.setPrice(38.90);
		productRepository.save(pr);
		assertNotEquals(300.00,productRepository.findById(1).get().getPrice());
		
	}
	@Test
	@Order(5)
	public void testDelete()
	{
		productRepository.deleteById(1);
		assertThat(productRepository.existsById(1)).isFalse();
	}

}
;