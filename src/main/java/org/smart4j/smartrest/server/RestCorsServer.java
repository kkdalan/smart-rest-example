package org.smart4j.smartrest.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharingFilter;
import org.smart4j.smartrest.service.impl.ProductServiceImpl;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestCorsServer {

	public static void main(String[] args) {

		List<Class<?>> resourceClassList = new ArrayList<Class<?>>();
		resourceClassList.add(ProductServiceImpl.class);
		
		List<ResourceProvider> resourceProviderList = new ArrayList<ResourceProvider>();
		resourceProviderList.add(new SingletonResourceProvider(new ProductServiceImpl()));

		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());
		providerList.add(newCrossOriginResourceSharingFilter("http://localhost"));
		
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setAddress("http://localhost:8080/ws/rest");
		factory.setResourceClasses(resourceClassList);
		factory.setResourceProviders(resourceProviderList);
		factory.setProviders(providerList);
		factory.create();
		System.out.println("rest ws is published");
	}

	private static CrossOriginResourceSharingFilter newCrossOriginResourceSharingFilter(String url) {
		CrossOriginResourceSharingFilter corsFilter = new CrossOriginResourceSharingFilter();
		List<String> allowedOriginList = new ArrayList<String>();
		allowedOriginList.add(url);
		corsFilter.setAllowOrigins(allowedOriginList);
		return corsFilter;
	}
}
