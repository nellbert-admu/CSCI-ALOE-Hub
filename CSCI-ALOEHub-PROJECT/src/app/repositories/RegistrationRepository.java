package app.repositories;

import app.entities.Registration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    // You can add custom query methods if needed
    // Example: Find all registrations for a specific event
    List<Registration> findByEventId(Long eventId);

    // Example: Find all registrations for a specific user
    List<Registration> findByUserId(Long userId);
}