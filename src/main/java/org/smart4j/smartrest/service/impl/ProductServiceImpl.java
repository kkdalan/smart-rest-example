package org.smart4j.smartrest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.smart4j.smartrest.model.Product;
import org.smart4j.smartrest.service.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> retrieveAllProducts() {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1,"product1",1000.0));
		productList.add(new Product(2,"product2",2000.0));
		productList.add(new Product(3,"product3",3000.0));
		return productList;
	}

	@Override
	public Product retrieveProductById(long id) {
		return new Product(1,"product1",1000.0);
	}

	@Override
	public List<Product> retrieveProductByName(String name) {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(4,"product4",1000.0));
		productList.add(new Product(5,"product5",2000.0));
		productList.add(new Product(6,"product6",3000.0));
		return productList;
	}

	@Override
	public Product createProduct(Product product) {
		return product;
	}

	@Override
	public Product updateProduct(long id, Map<String, Object> fieldMap) {
	    return new Product(id,"product1",1000.0);
	}

	@Override
	public Product deleteProductById(long id) {
		return new Product(id,"product1",1000.0);
	}

}
