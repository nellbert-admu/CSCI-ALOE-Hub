package app.rest.controllers;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.PetItemDto;
import app.components.PetItemDto2;
import app.components.RetrofitTesterComponent;


@Component
@Path("/retrofit")
public class RetrofitTester 
{
	@Autowired
	RetrofitTesterComponent rt;
	
	// GET TEST
	
	@GET
	@Path("/testGet")
	public String testGet() throws IOException
	{
		return rt.getTest();
	}

	// POST TEST
	
	@GET
	@Path("/testPost")
	public String testGet2() throws IOException
	{
		return rt.getTest2();
	}

	// JSON TEST
	@GET
	@Path("/testJson")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public PetItemDto add() throws IOException
	{
		return rt.testJson();
	}
	
	@POST
	@Path("/testJson2")
	@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public PetItemDto2 add(PetItemDto item) throws IOException
	{
		return rt.testJson2(item);
	}
}
