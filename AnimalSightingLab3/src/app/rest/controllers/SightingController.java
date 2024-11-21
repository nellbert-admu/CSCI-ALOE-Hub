package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.SightingComponent;
import app.entities.Location;
import app.entities.Sighting;
import app.entities.StrayAnimal;
import app.repositories.LocationRepository;

@Component // Use Spring's @Component for JAX-RS to be recognized
@Path("/sighting") // This defines the base URI for this resource
public class SightingController {

    private static final Logger logger = LoggerFactory.getLogger(SightingController.class); // Logger instance

    @Autowired
    private SightingComponent sightingComponent;

    @Autowired
    private LocationRepository locationRepository;

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON) // Expecting JSON request
    @Produces(MediaType.APPLICATION_JSON) // Producing JSON response
    public Response createSighting(SightingDTO sightingDTO) {
        logger.info("Received request to create a new sighting."); // Log the incoming request

        if (sightingDTO == null) {
            logger.error("SightingDTO is null."); // Log an error if the DTO is null
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("SightingDTO cannot be null").build();
        }

        // Log the incoming DTO values
        logger.info("SightingDTO values - Location: {}, Type: {}, Color: {}, Neutered: {}, Description: {}",
                    sightingDTO.getLocation(), sightingDTO.getType(), sightingDTO.getColor(),
                    sightingDTO.getNeutered(), sightingDTO.getAnimalDescription());

        // Create a new StrayAnimal using the DTO’s type, color, neutered, and animalDescription.
        StrayAnimal strayAnimal = new StrayAnimal();
        strayAnimal.setType(sightingDTO.getType());
        strayAnimal.setColor(sightingDTO.getColor());
        strayAnimal.setNeutered(sightingDTO.getNeutered());
        strayAnimal.setDescription(sightingDTO.getAnimalDescription());

        // Create a new Sighting using the DTO’s location, comment, latitude, and longitude.
        Sighting sighting = new Sighting();
        sighting.setLocation(sightingDTO.getLocation());
        sighting.setComment(sightingDTO.getComment());

        // Search for the location in the Location table
        logger.info("Searching for location: {}", sightingDTO.getLocation());
        Location location = locationRepository.findByLocationName(sightingDTO.getLocation());
        
        if (location != null) {
            // If it exists, use its latitude and longitude values for the new sighting.
            sighting.setLatitude(location.getLatitude());
            sighting.setLongitude(location.getLongitude());
            logger.info("Found existing location: {}, Latitude: {}, Longitude: {}", 
                        location.getLocationName(), location.getLatitude(), location.getLongitude());
        } else {
            // If it doesn’t, use the provided latitude and longitude, then save this new location to the table
            sighting.setLatitude(sightingDTO.getLatitude());
            sighting.setLongitude(sightingDTO.getLongitude());

            logger.info("Creating new location with name: {}, Latitude: {}, Longitude: {}", 
                        sightingDTO.getLocation(), sightingDTO.getLatitude(), sightingDTO.getLongitude());

            location = new Location();
            location.setLocationName(sightingDTO.getLocation());
            location.setLatitude(sightingDTO.getLatitude());
            location.setLongitude(sightingDTO.getLongitude());
            locationRepository.save(location);
        }

        // Log the sighting details before processing
        logger.info("Processing new sighting: {}", sighting);
        
        // Forward the DTO to the SightingComponent
        Sighting savedSighting = sightingComponent.processNewSighting(sighting, strayAnimal);

        // Log the saved Sighting object
        logger.info("Sighting created successfully with ID: {}", savedSighting.getId());
        
        // Return the saved Sighting object as a JSON response
        return Response.ok(savedSighting).build();
    }
}