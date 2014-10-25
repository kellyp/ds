package com.kelly.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kelly.Product;
import com.kelly.Size;
import com.kelly.dao.ProductDao;
import com.kelly.hystrix.*;

import java.util.ArrayList;
import java.util.List;

@Path("/json/products")
public class ProductService {

	@GET
	@Path("/index")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
        return new ProductIndexCommand().execute();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(Product product) {

        product = new ProductCreateCommand(product).execute();
		return Response.status(201).entity(product).build();
		
	}


    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product updateProduct(@PathParam("id") String id,  Product product) {

        product = new ProductUpdateCommand(id, product).execute();
        return product;

    }

    @GET
    @Path("/get/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") String id) {

        return new ProductGetCommand(id).execute();

    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") String id) {

        boolean didDelete = new ProductDeleteCommand(id).execute();
        return Response.status(200).entity("{\"message\":\"product with id: " + id + " deleted successfully.\"}").build();

    }
}