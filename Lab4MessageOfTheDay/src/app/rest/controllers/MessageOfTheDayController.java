package app.rest.controllers;

import app.components.MessageOfTheDay;
import app.components.TwilioReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/api/messageOfTheDay")
public class MessageOfTheDayController {

    private final MessageOfTheDay messageOfTheDay;

    @Autowired
    public MessageOfTheDayController(MessageOfTheDay messageOfTheDay) {
        this.messageOfTheDay = messageOfTheDay;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessage(@QueryParam("userId") Long userId, @QueryParam("category") String category) {
        // Forward the user ID and category to the MessageOfTheDay component
        TwilioReply reply = messageOfTheDay.sendMessageOfTheDay(userId, category);
        
        // Return the TwilioReply as a JSON response
        return Response.ok(reply).build();
    }
}