package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductServiceImpl;

@RestController
@RequestMapping("/com")
public class ProductControllerImpl
{
     @Autowired
	 private ProductServiceImpl productService;
     
     private static Logger logger=LoggerFactory.getLogger(ProductControllerImpl.class);
     @PostMapping("/addProduct")
     public ResponseEntity<Product > addProduct(@RequestBody Product product)
     {
    	 Product productToStore=productService.saveProduct(product);
    	 logger.info("It's Add one new Product");
    	 return new ResponseEntity<Product>(productToStore, HttpStatus.CREATED);
     }
      @PostMapping("/addProducts")
     public List<Product> addProducts(@RequestBody List<Product>products)
     {
    	  logger.info("It's add multiple products.");
    	 return productService.saveProducts(products);
     }
      
      @GetMapping("/products")
      public List<Product> findProduct() {
    	  logger.info("Retriving all  products");
    	  return productService.getProducts();
      }
      
      @GetMapping("/getProductById/{id}")
      public ResponseEntity<Product> findById(@PathVariable int id)
      {   
    	  Product producttoget=productService.getProductById(id);
    	  logger.info("Retriving only one product");
    	  return new ResponseEntity<Product>(producttoget, HttpStatus.OK);
      }
      @GetMapping("/product/{name}")
      public Product findByName(@PathVariable String name )
      {   

    	  logger.info("Retriving only one product");
    	  return productService.getProductByName(name);
      }
      @PutMapping("/update")
      public Product updateProduct(@RequestBody Product product)
      {    

    	  logger.info("updating  one product");
    	  return  productService.updateProduct(product);
      }
      @DeleteMapping("/delete/{id}")
      public String deleteProduct(@PathVariable int id)
      {   

    	  logger.info("Deleted only one product");
    	  return productService.deleteProduct(id);
      }
}
