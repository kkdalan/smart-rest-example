package org.smart4j.smartrest.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.smart4j.smartrest.service.ProductService;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class JAXRSClient {

	public static void main(String[] args) {

		String baseAddress = "http://localhost:8080/ws/rest";

		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());

		//TODO: 無法直接由JSON物件轉Product
		ProductService productService = JAXRSClientFactory.create(baseAddress, ProductService.class, providerList);
		List productList = productService.retrieveAllProducts();
		for (Object product : productList) {
			System.out.println(product);
		}
	}

}
