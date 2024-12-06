package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Tag;
import app.repositories.TagRepository;

@Component
@Path("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @POST
    @Path("/add")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
    public Response addTag(@FormParam("name") String name) {
        Tag tag = new Tag(name);
        tagRepository.save(tag);
        return Response.status(Response.Status.CREATED).entity("Tag saved with ID: " + tag.getId()).build();
    }

    @GET
    @Path("/all")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}