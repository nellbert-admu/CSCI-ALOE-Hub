package app.components;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.entities.Registration;
import app.entities.User;
import app.entities.Event;
import app.repositories.RegistrationRepository;
import app.repositories.UserRepository;
import app.repositories.EventRepository;

@Component
public class RegistrationInitializer {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @PostConstruct
    public void init() {
        if (registrationRepository.count() == 0) {
            User user1 = userRepository.findById(1L).orElse(null);
            User user2 = userRepository.findById(2L).orElse(null);
            Event event1 = eventRepository.findById(1L).orElse(null);
            Event event2 = eventRepository.findById(2L).orElse(null);

            if (user1 != null && event1 != null) {
                Registration reg1 = new Registration(user1, event1);
                registrationRepository.save(reg1);
            }
            if (user2 != null && event2 != null) {
                Registration reg2 = new Registration(user2, event2);
                registrationRepository.save(reg2);
            }

            System.out.println("Sample Registrations have been initialized.");
        } else {
            List<Registration> registrations = registrationRepository.findAll();
            System.out.println("Registrations already exist: " + registrations);
        }
    }
}
