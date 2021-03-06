package org.smart4j.smartrest.service;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.smart4j.smartrest.model.Product;

public interface ProductService {

	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveAllProducts();

	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product retrieveProductById(@PathParam("id") long id);

	@POST
	@Path("/products")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> retrieveProductByName(@FormParam("name") String name);

	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product createProduct(Product product);

	@PUT
	@Path("/product/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product updateProduct(@PathParam("id") long id, Map<String, Object> fieldMap);

	@DELETE
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product deleteProductById(@PathParam("id") long id);
}
