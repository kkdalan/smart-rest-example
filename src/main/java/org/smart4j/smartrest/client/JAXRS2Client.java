package org.smart4j.smartrest.client;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.smart4j.smartrest.model.Product;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class JAXRS2Client {

	public static void main(String[] args) {

		String baseAddress = "http://localhost:8080/ws/rest";

		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();

		List productList = ClientBuilder.newClient()
				.register(jsonProvider)
				.target(baseAddress)
				.path("/products")
				.request(MediaType.APPLICATION_JSON)
				.get(List.class);

		for (Object product : productList) {
			System.out.println(product);
		}
	}

}
