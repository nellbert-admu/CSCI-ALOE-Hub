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
import app.entities.Registration;
import app.entities.User;
import app.repositories.EventRepository;
import app.repositories.RegistrationRepository;
import app.repositories.UserRepository;

@Component
@Path("/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @POST
    @Path("/add")
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED)
    public String addRegistration(
        @FormParam("userId") Long userId,
        @FormParam("eventId") Long eventId) {
        
        User user = userRepository.findById(userId).orElse(null);
        Event event = eventRepository.findById(eventId).orElse(null);
        if (user == null || event == null) {
            return "Invalid User or Event ID!";
        }
        Registration registration = new Registration(user, event);
        registrationRepository.save(registration);
        return "Registration saved with ID: " + registration.getId();
    }

    @GET
    @Path("/all")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
}
