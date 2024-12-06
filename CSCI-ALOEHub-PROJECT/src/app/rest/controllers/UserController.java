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

import app.entities.User;
import app.repositories.UserRepository;

@Component
@Path("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @POST
    @Path("/add")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
    public Response addUser(
        @FormParam("email") String email,
        @FormParam("firstName") String firstName,
        @FormParam("lastName") String lastName,
        @FormParam("contactNumber") String contactNumber,
        @FormParam("password") String password) {
        
        User user = new User(email, firstName, lastName, contactNumber, password);
        userRepository.save(user);
        return Response.status(Response.Status.CREATED).entity("User saved with ID: " + user.getId()).build();
    }

    @GET
    @Path("/all")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}