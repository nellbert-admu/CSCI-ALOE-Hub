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

import app.entities.Event;
import app.entities.Organization;
import app.repositories.EventRepository;
import app.repositories.OrganizationRepository;

@Component
@Path("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private OrganizationRepository organizationRepository;

    @POST
    @Path("/add")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
    public String addEvent(
        @FormParam("title") String title,
        @FormParam("description") String description,
        @FormParam("date") String date,
        @FormParam("time") String time,
        @FormParam("location") String location,
        @FormParam("organizationId") Long organizationId) {
        
        Organization organization = organizationRepository.findById(organizationId).orElse(null);
        if (organization == null) {
            return "Organization not found!";
        }
        Event event = new Event(title, description, date, time, location, organization);
        eventRepository.save(event);
        return "Event saved with ID: " + event.getId();
    }

    @GET
    @Path("/all")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
