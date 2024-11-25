package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Organization;
import app.repositories.OrganizationRepository;

@Component
@Path("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @POST
    @Path("/add")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
    public String addOrganization(
        @FormParam("name") String name,
        @FormParam("contactNumber") String contactNumber,
        @FormParam("email") String email,
        @FormParam("description") String description) {
        
        Organization org = new Organization(name, contactNumber, email, description);
        organizationRepository.save(org);
        return "Organization saved with ID: " + org.getId();
    }

    @GET
    @Path("/all")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }
}
