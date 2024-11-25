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

@Component
public class DatabaseInitializer {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @PostConstruct
    public void init() {

        // Creating sample Organizations

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

        // Saving Organizations to the database
        organizationRepository.save(org1);
        organizationRepository.save(org2);

        // Creating sample Users
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

        // Saving Users to the database
        userRepository.save(user1);
        userRepository.save(user2);

        // Creating sample Events for each organization
        Event event1 = new Event(
        	    "Silent Night: Gabay Christmas Party 2024🕸️", 
        	    "Celebrate the season of giving with the Ateneo Gabay Christmas Party, a fun-filled evening of games, food, and sharing in the spirit of service.",
        	    "2024-12-09",  // Date in "yyyy-MM-dd" format
        	    "16:00-20:00", // Time in "HH:mm-HH:mm" format
        	    "CTC 105",     // Location
        	    org1            // Organization (Ateneo Gabay)
        	);

        Event event2 = new Event(
        	    "Hexceed 2024: Serving with purpose for the future", 
        	    "Join us for Hexceed 2024, an event designed to inspire and empower the next generation of leaders through purposeful service and innovative solutions.",
        	    "2024-11-20",  // Date in "yyyy-MM-dd" format
        	    "17:00-20:00", // Time in "HH:mm-HH:mm" format
        	    "CTC 102",     // Location
        	    org2            // Organization (Ateneo MISA)
        	);
        // Saving Events to the database
        eventRepository.save(event1);
        eventRepository.save(event2);

        // Log or print a message after initialization
        System.out.println("Sample Organizations, Users, and Events have been initialized.");
    }
}