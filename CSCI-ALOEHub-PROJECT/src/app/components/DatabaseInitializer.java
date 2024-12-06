package app.components;

import app.entities.Event;
import app.entities.Organization;
import app.entities.User;
import app.repositories.EventRepository;
import app.repositories.OrganizationRepository;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DatabaseInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @PostConstruct
    @Transactional
    public void init() {
        // Initialize organizations if not already present
        if (organizationRepository.count() == 0) {
            Organization org1 = new Organization(
                "Ateneo Gabay",
                "0917-987-6543",
                "ateneogabay@gmail.com",
                "A student organization focused on empowering marginalized communities through education and community service."
            );

            Organization org2 = new Organization(
                "Ateneo Management Information Systems Association (MISA)",
                "0917-555-1234",
                "ateneomisa@gmail.com",
                "An organization that promotes the integration of business and technology among Ateneo students through various events, talks, and projects."
            );

            organizationRepository.save(org1);
            organizationRepository.save(org2);
            logger.info("Sample organizations initialized.");
        }

        // Initialize users if not already present
        if (userRepository.count() == 0) {
            User user1 = new User(
                "nellbert.pineda@student.ateneo.edu",
                "Nellbert",
                "Pineda",
                "0917-555-1234",
                "ethan123"
            );
            User user2 = new User(
                "maristel.lluch@student.ateneo.edu",
                "Maristel",
                "Lluch",
                "0917-555-5678",
                "maris234"
            );

            userRepository.save(user1);
            userRepository.save(user2);
            logger.info("Sample users initialized.");
        }

     // Initialize events if not already present
        if (eventRepository.count() == 0) {
            Organization org1 = organizationRepository.findById(1L).orElse(null);
            Organization org2 = organizationRepository.findById(2L).orElse(null);

            if (org1 != null && org2 != null) {
                Event event1 = new Event(
                    "Silent Night: Gabay Christmas Party 2024🕸️",
                    "Celebrate the season of giving with the Ateneo Gabay Christmas Party...",
                    LocalDate.parse("2024-12-09"),
                    LocalTime.parse("16:00"),
                    "CTC 105",
                    org1
                );

                Event event2 = new Event(
                    "Hexceed 2024: Serving with purpose for the future",
                    "Join us for Hexceed 2024...",
                    LocalDate.parse("2024-11-20"),
                    LocalTime.parse("17:00"),
                    "CTC 102",
                    org2
                );

                eventRepository.save(event1);
                eventRepository.save(event2);
                logger.info("Sample events initialized.");
            } else {
                logger.warn("Could not find organizations for event creation.");
            }
        }
    }
}