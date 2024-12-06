package app.repositories;

import app.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    // You can add custom query methods if needed
    Tag findByName(String name);  // Example: Find Tag by name
}