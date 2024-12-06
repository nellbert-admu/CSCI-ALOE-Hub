package app.components;

import app.entities.Registration;
import app.entities.User;
import app.entities.Event;
import app.repositories.RegistrationRepository;
import app.repositories.UserRepository;
import app.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class RegistrationInitializer {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationInitializer.class);

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @PostConstruct
    public void init() {
        if (registrationRepository.count() == 0) {
            logger.info("No existing registrations found. Initializing sample registrations.");

            // Retrieve sample users and events
            User user1 = userRepository.findById(1L).orElse(null);
            User user2 = userRepository.findById(2L).orElse(null);
            Event event1 = eventRepository.findById(1L).orElse(null);
            Event event2 = eventRepository.findById(2L).orElse(null);

            // Check if users and events are available
            if (user1 == null || event1 == null) {
                logger.warn("User or Event not found for Registration 1. Skipping.");
            } else {
                Registration reg1 = new Registration(user1, event1);
                registrationRepository.save(reg1);
                logger.info("Registration created: User {} -> Event {}", user1.getEmail(), event1.getTitle());
            }

            if (user2 == null || event2 == null) {
                logger.warn("User or Event not found for Registration 2. Skipping.");
            } else {
                Registration reg2 = new Registration(user2, event2);
                registrationRepository.save(reg2);
                logger.info("Registration created: User {} -> Event {}", user2.getEmail(), event2.getTitle());
            }

            logger.info("Sample registrations have been initialized.");
        } else {
            List<Registration> registrations = registrationRepository.findAll();
            logger.info("Existing registrations found: {}", registrations);
        }
    }
}