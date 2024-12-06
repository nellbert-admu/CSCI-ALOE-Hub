package app.repositories;

import app.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // You can add custom query methods if needed
    Event findByTitle(String title);  // Example: Find Event by title
}