package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.StrayAnimalComponent;
import app.entities.StrayAnimal;

@Component // Use Spring's @Component for JAX-RS to be recognized
@Path("/strays") // This defines the base URI for this resource
public class StrayAnimalController {

    @Autowired
    private StrayAnimalComponent strayAnimalComponent;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) // Expecting form URL encoded request
    public Response addStrayAnimal(
            @javax.ws.rs.FormParam("type") String type,
            @javax.ws.rs.FormParam("color") String color,
            @javax.ws.rs.FormParam("neutered") Boolean neutered,
            @javax.ws.rs.FormParam("description") String description) {

        StrayAnimal strayAnimal = new StrayAnimal();
        strayAnimal.setType(type);
        strayAnimal.setColor(color);
        strayAnimal.setNeutered(neutered);
        strayAnimal.setDescription(description);

        Long id = strayAnimalComponent.saveStrayAnimal(strayAnimal);
        return Response.status(Response.Status.CREATED).entity(id).build(); // Return created ID with status 201
    }

    @GET
    @Path("/bytype/{type}")
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    public Response getStrayAnimalsByType(@PathParam("type") String type) {
        List<StrayAnimal> strayAnimals = strayAnimalComponent.getStrayAnimalsByType(type);
        return Response.ok(strayAnimals).build(); // Return the list of stray animals with status 200
    }

    @GET
    @Path("/neutered")
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    public Response getNonNeuteredStrayAnimals() {
        List<StrayAnimal> strayAnimals = strayAnimalComponent.getNonNeuteredStrayAnimals();
        return Response.ok(strayAnimals).build(); // Return the list of non-neutered stray animals with status 200
    }
}