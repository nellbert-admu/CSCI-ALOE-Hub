package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // You can define custom queries here if needed
    // For example, find events by title or location
    List<Event> findByTitle(String title);
    List<Event> findByLocation(String location);
}