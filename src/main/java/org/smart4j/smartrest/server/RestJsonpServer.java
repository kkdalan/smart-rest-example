package org.smart4j.smartrest.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpInInterceptor;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpPostStreamInterceptor;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpPreStreamInterceptor;
import org.apache.cxf.message.Message;
import org.smart4j.smartrest.service.impl.ProductServiceImpl;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestJsonpServer {

	public static void main(String[] args) {

		List<Class<?>> resourceClassList = new ArrayList<Class<?>>();
		resourceClassList.add(ProductServiceImpl.class);
		
		List<ResourceProvider> resourceProviderList = new ArrayList<ResourceProvider>();
		resourceProviderList.add(new SingletonResourceProvider(new ProductServiceImpl()));

		List<Object> prodviderList = new ArrayList<Object>();
		prodviderList.add(new JacksonJsonProvider());
		prodviderList.add(new JsonpPreStreamInterceptor());
		
		List<Interceptor<? extends Message>> inInterceptorList = new ArrayList<Interceptor<? extends Message>>();
		inInterceptorList.add(new JsonpInInterceptor());
		
		List<Interceptor<? extends Message>> outInterceptorList = new ArrayList<Interceptor<? extends Message>>();
		outInterceptorList.add(new JsonpPostStreamInterceptor());

		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setAddress("http://localhost:8080/ws/rest");
		factory.setResourceClasses(resourceClassList);
		factory.setResourceProviders(resourceProviderList);
		factory.setProviders(prodviderList);
		factory.setInInterceptors(inInterceptorList);
		factory.setOutInterceptors(outInterceptorList);
		
		factory.create();
		System.out.println("rest ws is published");
	}
}
