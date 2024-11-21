package app.components;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Sighting;
import app.entities.StrayAnimal;
import app.repositories.SightingRepository;
import app.repositories.StrayAnimalRepository;

@Component
public class SightingComponent {

    private static final Logger logger = LoggerFactory.getLogger(SightingComponent.class); // Logger instance

    @Autowired
    private SightingRepository sightingRepository;

    @Autowired
    private StrayAnimalRepository strayAnimalRepository;

    public List<StrayAnimal> getStrayAnimalsByType(String type) {
        logger.info("Retrieving stray animals by type: {}", type);
        return strayAnimalRepository.findByType(type);
    }

    public List<StrayAnimal> getNonNeuteredStrayAnimals() {
        logger.info("Retrieving non-neutered stray animals.");
        return strayAnimalRepository.findByNeutered(false);
    }

    public Sighting processNewSighting(Sighting sighting, StrayAnimal strayAnimal) {
        logger.info("Processing new sighting: {}", sighting);
        logger.info("Processing new stray animal: {}", strayAnimal);

        try {
            // Save the stray animal first to ensure you have an ID
            logger.info("Saving stray animal: {}", strayAnimal);
            StrayAnimal savedAnimal = strayAnimalRepository.save(strayAnimal);
            logger.info("Saved stray animal with ID: {}", savedAnimal.getId());

            // Set the saved animal ID in the sighting
            sighting.setAnimalId(savedAnimal.getId()); // Ensure Sighting has an animalId field

            // Save the sighting and return the saved sighting object
            logger.info("Saving sighting: {}", sighting);
            Sighting savedSighting = sightingRepository.save(sighting);
            logger.info("Sighting created successfully with ID: {}", savedSighting.getId());

            return savedSighting;
        } catch (Exception e) {
            // Log the error
            logger.error("Error processing new sighting: {}", e.getMessage(), e);
            throw e; // Optionally rethrow or handle as needed
        }
    }
}