package app.components;

import app.entities.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserInitializer {

    private final UserRepository userRepository;

    @Autowired
    public UserInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        // Use a test phone number for all users
        String testPhoneNumber = "+18777804236"; // Twilio test number or other placeholder

        // Add sample users with different names
        userRepository.save(new User("Ethan", testPhoneNumber));
        userRepository.save(new User("Josh", testPhoneNumber));
        userRepository.save(new User("Isa", testPhoneNumber));
        // Additional users can be added here for testing purposes
    }
}